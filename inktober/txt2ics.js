
//randomUUIDv7(); Node 26
import { randomUUID } from 'node:crypto';
import { readFileSync, writeFileSync } from 'node:fs';

const DTSTAMP = new Date().toISOString().replace(/[-:]/g, '').split('.')[0] + 'Z';

function wordToEvent(word, index)
	{
	const day = (index + 1).toString().padStart(2, '0');

	const event =
		[
		'BEGIN:VEVENT',
		`UID:${randomUUID()}`,
		`DTSTAMP:${DTSTAMP}`,
		`DTSTART;VALUE=DATE:202610${day}`,
		`DTEND;VALUE=DATE:202610${day}`,
		`SUMMARY:${word}`,
		'END:VEVENT'
		];

	return event.join('\r\n');
	}

const words = readFileSync('./2026/fr.txt', 'utf8').split('\n');

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

//writeFileSync('./2026/fr.ics', calendar.join('\r\n'), 'utf8');
writeFileSync('../docs/temp/inktober-2026-fr.ics', calendar.join('\r\n'), 'utf8');
