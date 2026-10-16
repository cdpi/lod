
import { writeFileSync } from 'node:fs';
import { listItem, itemList, addContext } from './schema.js';
import { csv, uuid } from './util.js';


import ICAL from 'ical.js';

function getPrompts():{date:Date, prompt:string}[]
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

function prompts(prompts:string[]):void
	{
	const items = prompts.map((prompt, index) => listItem(index + 1, prompt));

	const list = itemList(items);

	list.itemListOrder = 'https://schema.org/ItemListOrderAscending';

	const jsonld = addContext(list);

	writeFileSync('datasets/inktober/dataset.jsonld', JSON.stringify(jsonld, null, 2), 'utf8');
	}

function jsonld():void
	{
	const prompts2026 = getPrompts()
		.filter(prompt => prompt.date.getFullYear() === 2026)
		.map(prompt => prompt.prompt);

	prompts(prompts2026);
	}

export
	{
	getPrompts,

	//wordToEvent,
	//wordsToEvents,

	//wordToListItem,
	//wordsToItemList,
	//wordsToJSONLD
	jsonld
	};
