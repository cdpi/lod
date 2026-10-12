
import { readFileSync } from 'node:fs';
import { uuid } from './util.js';

function readWordsFromCSV(path)
	{
	return readFileSync(path, 'utf-8')
		.split(/\r?\n/)
		.map(line => line.split(','));
	}

function readWordsFromTXT(path)
	{
	return readFileSync(path, 'utf-8').split(/\r?\n/);
	}

function wordToEvent(word, index)
	{
	const day = (index + 1).toString().padStart(2, '0');

	const event =
		[
		'BEGIN:VEVENT',
		`UID:${uuid()}`,
		//`DTSTAMP:${DTSTAMP}`,
		`DTSTART;VALUE=DATE:202610${day}`,
		`DTEND;VALUE=DATE:202610${day}`,
		`SUMMARY:${word}`,
		'END:VEVENT'
		];

	return event.join('\r\n');
	}

function wordsToEvents(words)
	{
	const events = words.map(wordToEvent);

	const calendar =
		[
		'BEGIN:VCALENDAR',
		'VERSION:2.0',
		'PRODID: -//github.com/cdpi/lod 0.0.1//FR',
		'CALSCALE:GREGORIAN',
		...events,
		'END:VCALENDAR'
		];

	return calendar.join('\r\n');
	}

function wordToListItem(word, index)
	{
	const listItem =
		{
		'@type': 'ListItem',
		'position': index + 1,
		'name': word
		};

	return listItem;
	}

function wordsToItemList(words)
	{
	const itemList =
		{
		'@context': 'https://schema.org',
		'@type': 'ItemList',
		'numberOfItems': words.length,
		'itemListOrder': 'https://schema.org/ItemListOrderAscending',
		'itemListElement': words.map(wordToListItem)
		};

	return itemList;
	}

function wordsToJSONLD(words, pretty = false)
	{
	return JSON.stringify(wordsToItemList(words), null, pretty ? 2 : undefined);
	}

export
	{
	readWordsFromCSV,
	readWordsFromTXT,

	wordToEvent,
	wordsToEvents,

	wordToListItem,
	wordsToItemList,
	wordsToJSONLD
	};
