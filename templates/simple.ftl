<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
	<title>${name}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<script type="module">

fetch('./dataset.jsonld')
  .then(response => response.json())
  .then(data => {
	console.log(data);
  })
  .catch(error => {
	console.error('Erreur lors du chargement du fichier JSON-LD :', error);
  });

</script>

</body>
</html>