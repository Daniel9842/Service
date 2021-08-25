

function getDataService() {
	const searchId = window.location.search;
	const urlParams = new URLSearchParams(searchId);
	var id = urlParams.get('identificador');
	console.log(id);

	const requestURL = 'https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=' + id + '&apikey=3A320OI0SQZ06SKJ';
	fetch(requestURL)
		.then(response => response.json())
		.then(data => console.log(data));
}






