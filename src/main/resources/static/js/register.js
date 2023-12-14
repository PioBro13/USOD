document.getElementById('register-form-data').addEventListener('submit', function(event) {
    event.preventDefault(); // Zapobiegnij domyślnej akcji formularza (np. przekierowanie)

    // Odczytaj dane z formularza
    const formData = new FormData(this);
    console.log(document.getElementById('birthDate').value);
    console.log(typeof (document.getElementById('birthDate').value));
    // Wyślij żądanie do endpointa
    fetch('/api/auth/signup', {method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: formData
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Jeśli endpoint zwraca JSON
        })
        .then(data => {
            // Obsłuż odpowiedź z serwera
            console.log(data);
            // Wyswietl komunikat o sukcesie lub błędzie
            if (data.message) {
                // Wyświetl komunikat o sukcesie
                showPopup(document.getElementById('success-popup'));
            } else {
                // Wyświetl komunikat o błędzie
                showPopup(document.getElementById('error-popup'));
            }
        })
        .catch(error => {
            // Obsłuż błąd
            console.error('There has been a problem with your fetch operation:', error);
        });
});
