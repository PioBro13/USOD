document.addEventListener('DOMContentLoaded', function() {
    const dropdownButton = document.getElementById('dropdownMenu')
    const apiUrl = 'http://localhost:8080/api' + dropdownButton.getAttribute('endpoint');
    fetch('http://localhost:8080/api/operationFinances')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log("Received data:", data);
            const dropdownMenu = document.getElementById('myDropdown');
            if (Array.isArray(data)) {
                data.forEach(item => {
                    const listItem = document.createElement('li');
                    listItem.classList.add('dropdown-item');
                    listItem.textContent = item.id + ' ' +item.operationName;
                    listItem.setAttribute('value', item.id); // Ustawiamy id jako wartość atrybutu value
                    listItem.addEventListener('click', function() {
                        console.log("Selected ID:", item.id); // Wyświetlamy id wybranego elementu w konsoli
                        dropdownButton.textContent =  item.id + ' ' +item.operationName;
                        dropdownButton.setAttribute('selected-value' , item.id);
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
});