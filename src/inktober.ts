
import { listItem } from './schema.js';
import { csv, uuid } from './util.js';

function getPrompts()
	{
	return csv('data/inktober/prompts.csv').map(record =>
		{
		return {date: new Date(Date.parse(record[0])), prompt: record[1]};
		});
	}

/*
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
*/

/*
function wordToListItem(word, index)
	{
	
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
*/

export
	{
	getPrompts,

	//wordToEvent,
	//wordsToEvents,

	//wordToListItem,
	//wordsToItemList,
	//wordsToJSONLD
	};
