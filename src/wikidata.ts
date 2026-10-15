
/*
import { readFileSync } from 'node:fs';

function getIDs(name)
	{
	const jsonld = readFileSync(`identifiers/${name}.jsonld`, 'utf-8');

	const thing = JSON.parse(jsonld);

	return thing.identifier.map(identifier => identifier.value);
	}

function getID(name)
	{
	return getIDs(name)[0];
	}
*/

async function getEntity(id:string):Promise<any>
	{
	const url = `http://www.wikidata.org/entity/${id}.json`;

	const response = await fetch(url);

	const json = await response.json();

	return json.entities[id];
	}

async function getLabels(id:string):Promise<Record<string, string>>
	{
	const entity = await getEntity(id);

	return entity.labels;
	}

export
	{
	//getID,
	//getIDs,
	getEntity,
	getLabels
	};
