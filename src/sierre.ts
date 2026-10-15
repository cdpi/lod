
import { writeFileSync } from 'node:fs';

import { addContext, administrativeArea, dataDownload, itemList } from './schema.js';
import { csv } from './util.js';

function streets():void
	{
	const items = csv('data/sierre/streets.csv').map(record => administrativeArea(record[1].trim()));

	const list = itemList(items);

	const jsonld = addContext(list);

	writeFileSync('datasets/sierre/streets/dataset.jsonld', JSON.stringify(jsonld, null, 2), 'utf8');

	writeFileSync('datasets/sierre/streets/metadata.jsonld', JSON.stringify(dataDownload(), null, 2), 'utf8');
	}

function jsonld():void
	{
	streets();
	}

export
	{
	jsonld
	};
