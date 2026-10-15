
import { yyyymmdd } from './util.js';

const context = 'https://schema.org';

function addContext(jsonld:any):any
	{
	jsonld['@context'] = context;

	return jsonld;
	}

function administrativeArea(name:string):any
	{
	const jsonld =
		{
		"@type": "AdministrativeArea",
		"name": name
		};

	return jsonld;
	}

function creativeWork(dateModified:string, encodingFormat:string):any
	{
	const jsonld =
		{
		"@type": "CreativeWork",
		"dateModified": dateModified,
		"encodingFormat": encodingFormat
		//license
		};

	return jsonld;
	}

function dataDownload():any
	{
	const jsonld = creativeWork(yyyymmdd(), "application/ld+json");

	jsonld["@type"] = "DataDownload";

	return jsonld;
	}

function listItem(position:number, name:string):any
	{
	const jsonld =
		{
		'@type': 'ListItem',
		'position': position,
		'name': name
		};

	return jsonld;
	}

function itemList(items:any[]):any
	{
	const jsonld =
		{
		"@type": "ItemList",
		"numberOfItems": items.length,
		"itemListElement": items
		};

	return jsonld;
	}

export
	{
	context,
	addContext,
	administrativeArea,
	creativeWork,
	dataDownload,
	listItem,
	itemList
	};
