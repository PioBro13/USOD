document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('put-form-data').addEventListener('submit', function (event) {
        event.preventDefault();
        const form = event.target;
        const entityId = document.getElementById('dropdownMenu').getAttribute('selected-value');
        const url = 'http://localhost:8080/api' + form.getAttribute('endpoint') + '/' + entityId;
        const formData = new FormData(form);
        const requestData = {
            id: entityId
        };


        formData.forEach((value, key) => {
            requestData[key] = value;
            console.log( requestData[key]);
        });
        console.log(JSON.stringify(requestData));

        const options = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
            },
            body: new URLSearchParams(requestData)
        };

        fetch(url, options)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                console.log('Data has been modified:', data);
                const successPopup = document.getElementById('success-edit-popup');
                showPopup(successPopup);
                form.reset();
            })
            .catch(error => {

                console.error('Error during data modifying:', error);
                const errorPopup = document.getElementById('error-popup');
                showPopup(errorPopup);
            });
    });
});