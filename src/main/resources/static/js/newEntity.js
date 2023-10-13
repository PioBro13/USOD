
document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('post-form-data')
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Zapobiega domyślnej akcji formularza
        const apiUrl = 'http://localhost:8080/api' + form.getAttribute('endpoint');
        const formData = new FormData(form);
        const requestData = {};
        for (let pair of formData.entries()) {
            requestData[pair[0]] = pair[1];
        }


        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
            },
            body: new URLSearchParams(requestData)
        })
            .then(response => response.json())
            .then(data => {

                console.log('Success:', data);
                // Pokaż popup sukcesu
                const successPopup = document.getElementById('success-popup');
                showPopup(successPopup);
                form.reset();
            })
            .catch((error) => {
                console.error('Error:', error);
                const errorPopup = document.getElementById('error-popup');
                showPopup(errorPopup);
            });
    });
});

