
import { writeFileSync } from 'node:fs';
import { readWordsFromCSV, readWordsFromTXT, wordsToEvents, wordsToJSONLD } from './inktober.js';

const en = readWordsFromTXT('./2026/en.txt');
const frDeepL = readWordsFromTXT('./2026/fr-deepl.txt');

function csv(en, frDeepL)
	{
	let content = [];

	for (let i = 0; i < 31; i++)
		{
		content.push(`${en[i]},${frDeepL[i]}`);
		}

	return content.join('\n');
	}

writeFileSync('./2026/2026.csv', csv(en, frDeepL), 'utf8');

//const words = readWordsFromCSV('./2026/fr.csv').map(line => line[0]);
//console.log(words.join('\n'));

//console.log(wordsToEvents(words));

writeFileSync('../docs/inktober/2026-en.jsonld', wordsToJSONLD(en, true), 'utf8');
writeFileSync('../docs/inktober/2026-fr-deepl.jsonld', wordsToJSONLD(frDeepL, true), 'utf8');
