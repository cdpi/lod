
import { readFileSync } from 'node:fs';

function iso(date)
	{
	const pad = (number) => String(number).padStart(2, '0');

	const dt =
		[
		date.getFullYear(),
		pad(date.getMonth() + 1),
		pad(date.getDate()),
		'T',
		pad(date.getHours()),
		pad(date.getMinutes()),
		pad(date.getSeconds()),
		'Z'
		];

	return dt.join('');
	}

function uuid()
	{
	return readFileSync('/proc/sys/kernel/random/uuid', 'utf8').trim();
	}

export
	{
	iso,
	uuid
	};
