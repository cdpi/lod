
import { jsonld as inktober } from './inktober.js';
import { jsonld as sierre } from './sierre.js';

//inktober();
//sierre();

//import ICAL from 'ical.js';
//let calendar = new ICAL.Component([]);
//let event = new ICAL.Event();
//console.log(ICAL.stringify([calendar]));

/*
import { existsSync } from 'node:fs';

//import { readWordsFromCSV, readWordsFromTXT, wordsToEvents, wordsToJSONLD } from './inktober.js';
import { readWordsFromTXT } from './inktober.js';
import { getID, getLabels } from './wikidata.js';



async function translate(words)
	{
	const translations = await Promise.all(words.map(async word =>
		{
		if (existsSync(`identifiers/${word}.jsonld`))
			{
			const id = getID(word);

			const labels = await getLabels(id);

			const fr = labels && labels.fr ? labels.fr.value : word;

			return fr;
			}
		}));

	return translations;
	}

const x = await translate(words);

console.log(x.join('\n'));
*/

/*
//console.log(wordsToEvents(words));

writeFileSync('../docs/inktober/2026-en.jsonld', wordsToJSONLD(en, true), 'utf8');
writeFileSync('../docs/inktober/2026-fr-deepl.jsonld', wordsToJSONLD(frDeepL, true), 'utf8');
*/
