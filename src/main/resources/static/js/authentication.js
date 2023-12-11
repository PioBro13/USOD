document.addEventListener('click', function () {
    console.log('click detected')
    const token = localStorage.getItem('jwtToken');

    // Sprawdź, czy token jest dostępny
    if (token) {
        // Dodaj token do nagłówka Authorization
        var headers = new Headers({
            'Authorization': 'Bearer ' + token
        });

        // Przykładowe żądanie GET do zabezpieczonego zasobu
        fetch('/api/protected/resource', {
            method: 'GET',
            headers: headers
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                // Obsługa danych zabezpieczonego zasobu
                console.log('Protected Resource Data:', data);
            })
            .catch(error => {
                // Obsługa błędu, np. wyświetl komunikat użytkownikowi
                console.error('Error:', error.message);
            });
    } else {
        console.error('Token not available. User not logged in.');
        // Tutaj możesz obsługiwać sytuację, gdy token nie jest dostępny (użytkownik niezalogowany)
    }
});