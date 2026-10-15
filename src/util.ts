
import { readFileSync } from 'node:fs';

//const frCH = Intl.DateTimeFormat('fr-CH', {year: 'numeric', month: '2-digit', day: '2-digit'});

function readLines(path:string):string[]
	{
	return readFileSync(path, 'utf-8').split(/\r?\n/);
	}

function csv(path:string):string[][]
	{
	return readLines(path).map(line => line.split(','));
	}

function iso(date:Date):string
	{
	const pad = (n:number) => String(n).padStart(2, '0');

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

function yyyymmdd():string
	{
	return new Date().toISOString().slice(0, 10);
	}

function uuid():string
	{
	return readFileSync('/proc/sys/kernel/random/uuid', 'utf8').trim();
	}

export
	{
	readLines,
	csv,
	iso,
	yyyymmdd,
	uuid
	};
