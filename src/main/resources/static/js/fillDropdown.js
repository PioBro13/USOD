document.addEventListener('DOMContentLoaded', function() {
    const dropdownButton = document.getElementById('dropdownMenu')
    const apiUrl = 'http://localhost:8080/api' + dropdownButton.getAttribute('endpoint');
    fillDropdown(apiUrl, dropdownButton);
});

function fillDropdown (endpointUrl, dropdownButton){
    const dropdownMenu = document.getElementById('dropdownList');
    dropdownMenu.innerHTML="";
    fetch(endpointUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {

            if (Array.isArray(data)) {
                data.forEach(item => {
                    const listItem = document.createElement('li');
                    listItem.classList.add('dropdown-item');
                    listItem.textContent = item.id + ' ' +item.operationName;
                    listItem.setAttribute('value', item.id);
                    listItem.addEventListener('click', function() {
                        dropdownButton.textContent =  item.id + ' ' +item.operationName;
                        dropdownButton.setAttribute('selected-value' , item.id);
                        fillFormFromAPI(endpointUrl);
                    });
                    dropdownMenu.appendChild(listItem);
                });
            } else {
                console.error("Invalid data format");
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}