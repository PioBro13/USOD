document.addEventListener("DOMContentLoaded", function () {
    const removeButton = document.getElementById('delete-button');
    const dropdownButton =document.getElementById('dropdownMenu');
    const form = document.getElementById('put-form-data');
    const apiDropdownUrl = 'http://localhost:8080/api' + dropdownButton.getAttribute('endpoint');
    removeButton.addEventListener('click', function () {
        const selectedValue = dropdownButton.getAttribute('selected-value');
        const apiUrl = 'http://localhost:8080/api' + removeButton.getAttribute('endpoint') +
            selectedValue;
        fetch( apiUrl, {
            method: 'DELETE'
        })
            .then( response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(data =>{
                console.log('Entity has been removed successfully :', data);
                const successPopup = document.getElementById('success-remove-popup');
                showPopup(successPopup);
                form.reset();
                resetDropdown('dropdownMenu');
                fillDropdown(apiDropdownUrl,dropdownButton);
            })
            .catch(error => {
                console.error('Error during data removal:', error);
                const errorPopup = document.getElementById('error-popup');
                showPopup(errorPopup);
            });
    })

})