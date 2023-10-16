document.addEventListener('DOMContentLoaded', function() {
    const apiUrl = 'http://localhost:8080/api' + document.getElementById('').getAttribute('endpoint');
    fetch('http://example.com/api/data') // zastąp 'http://example.com/api/data' adresem Twojego endpointu
        .then(response => response.json())
        .then(data => {
            const dropdown = document.getElementById('myDropdown');
            data.forEach(item => {
                const option = document.createElement('option');
                option.text = item.id;
                option.value = item.id;
                dropdown.add(option);
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });



});
