document.addEventListener('DOMContentLoaded', function () {
    fillDropdownFromAPI();
});


// Funkcja do pobierania danych XML z API i wypełniania dropdowna
async function fillDropdownFromAPI() {
    const orbeonBaseAPI = 'http://localhost:8040/orbeon/fr/'
    const apiUrl = 'service/persistence/form/application';

    try {
        // Pobierz dane XML z API
        const response = await fetch(orbeonBaseAPI + apiUrl);

        // Sprawdź, czy odpowiedź jest w formie JSON
        const isJson = response.headers.get('content-type')?.includes('application/json');

        // Przetwórz dane XML lub JSON i wypełnij dropdown
        let xmlString;
        if (isJson) {
            const jsonData = await response.json();
            xmlString = JSON.stringify(jsonData);
        } else {
            xmlString = await response.text();
        }

        // Przetwórz dane XML i wypełnij dropdown
        fillDropdown(xmlString);
        const dropdownList = document.getElementById('dropdownList');
        dropdownList.addEventListener('click', (event) => {
            if (event.target.classList.contains('dropdown-item')) {
                document.getElementById('dropdownMenu').textContent = event.target.textContent;

                const redirectButton = document.getElementById('redirect-button');
                redirectButton.href= orbeonBaseAPI + "application/"+  event.target.getAttribute('formName')+"/new?id="+localStorage.getItem('userId');
            }
        });

    } catch (error) {
        console.error('Błąd podczas pobierania danych z API:', error);
    }
}


function fillDropdown(xmlString) {
    const parser = new DOMParser();
    const xmlDoc = parser.parseFromString(xmlString, "text/xml");

    // Znajdź formularze
    const forms = xmlDoc.querySelectorAll('form');

    // Pobierz dropdown
    const dropdownList = document.getElementById('dropdownList');

    // Iteruj przez formularze
    forms.forEach(form => {
        // Pobierz etykietę (title)
        const title = form.querySelector('title').textContent;
        const formName = form.querySelector('form-name').textContent;

        // Stwórz element li dla dropdowna
        const listItem = document.createElement('li');
        listItem.innerHTML = `<a class="dropdown-item" formName="${formName}">${title}</a>`;

        // Dodaj element li do listy dropdowna
        dropdownList.appendChild(listItem);
    });
}