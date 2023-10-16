document.addEventListener('DOMContentLoaded', function() {
    const dropdownMenu = document.getElementById('myDropdown');
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