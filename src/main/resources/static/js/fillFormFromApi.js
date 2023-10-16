function fillFormFromAPI(endpoint) {
    const form = document.getElementById('put-form-data');
    const fullEndpoint = endpoint + '/'+ document.getElementById('dropdownMenu').getAttribute('selected-value');
    const formData = new FormData(form);
    const dataMapping = {};
    for (let pair of formData.entries()) {
        dataMapping[pair[0]] = pair[0];
    }

    fetch(fullEndpoint)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            for (const key in dataMapping) {
                if (dataMapping.hasOwnProperty(key) && data.hasOwnProperty(key)) {
                    const element = document.getElementById(dataMapping[key]);
                    if (element) {
                        element.value = data[key];
                    } else {
                        console.error("Element not found:", dataMapping[key]);
                    }
                }
            }
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}