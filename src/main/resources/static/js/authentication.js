document.addEventListener('DOMContentLoaded', function() {
    authentication("/api/auth/user");
    authenticationAdmin("/api/auth/admin");
});


function authentication(redirect){
    const token = localStorage.getItem('jwtToken');
    const content = document.getElementById('content')
    authorize(token , content , redirect)
};

function authenticationAdmin(redirect){
    const token = localStorage.getItem('jwtToken');
    const content = document.getElementById('content-admin')
    authorize(token , content , redirect)
};

function authorize(token , content, redirect) {
    if (token) {

        const headers = new Headers({
            'Authorization': 'Bearer ' + token
        });


        fetch(redirect, {
            method: 'GET',
            headers: headers
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(data => {
                content.classList.remove("hide")
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
}