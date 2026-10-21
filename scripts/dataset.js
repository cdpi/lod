
fetch('./dataset.jsonld')
.then(response => response.json())
.then(data =>
	{
	console.log(data);
	})
.catch(error =>
	{
	console.error('Erreur lors du chargement du fichier JSON-LD :', error);
	});
