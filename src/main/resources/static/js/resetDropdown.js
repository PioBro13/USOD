document.addEventListener('DOMContentLoaded', function() {
    const resetButton = document.getElementById('reset-button');
    resetButton.addEventListener('click', function () {
        resetDropdown('dropdownMenu');
    })
});

function resetDropdown(dropdownId){
    const dropdown = document.getElementById(dropdownId);
    dropdown.innerText = 'Wybierz element';
    dropdown.removeAttribute('selected-value');
}
