document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('login-form-data').addEventListener('submit', function (event) {
        event.preventDefault();
        document.getElementByRole

        var formData = new FormData(this);

        fetch('/api/auth/signin', {
            method: 'POST',
            body: formData
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                // Obsługa sukcesu, np. zapisanie tokena JWT w localStorage
                localStorage.setItem('userData',data);
                localStorage.setItem('role', data.roles);
                localStorage.setItem('userId',data.id);
                localStorage.setItem('jwtToken',data.accessToken);

                window.location.href = '/';
            })
            .catch(error => {
                // Obsługa błędu, np. wyświetlenie komunikatu użytkownikowi
                console.error('Error:', error.message);
                // Pokaż komunikat o błędzie na stronie
                document.getElementById('error-popup').style.display = 'block';
            });
    });
});
