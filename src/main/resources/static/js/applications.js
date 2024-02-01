document.addEventListener('DOMContentLoaded', function () {
    fulfillTable();
});

function fulfillTable(){
    const baseApiLink = 'http://localhost:8080/api/application';
    if(document.getElementById('all-apps-table')){
        fetch(baseApiLink)
            .then(response => response.json())
            .then(data => {

                const table = document.getElementById('all-apps-table');


                data.forEach(application => {
                    const row = table.insertRow();
                    const applicationName = application.applicationName;
                    const formName = application.formName;
                    const baseLink = "http://localhost:8040/orbeon/fr/" + applicationName +"/" + formName;
                    const viewLink = baseLink + "/view/" + application.documentId;
                    const editLink = baseLink + "/edit/" + application.documentId;

                    const applicationId = row.insertCell(0);
                    applicationId.textContent = application.id;

                    const documentTitle = row.insertCell(1);
                    documentTitle.textContent = application.documentTitle;

                    const userId = row.insertCell(2);
                    userId.textContent = application.userId;

                    const actionsCell = row.insertCell(3);
                    actionsCell.innerHTML = `
                    <a role="button" class="btn btn-primary btn-sm me-2" href=${viewLink}>
                        <i class="bi bi-eye"></i> Podgląd
                    </a>
                    <a role="button" class="btn btn-warning btn-sm me-2" href=${editLink}>
                        <i class="bi bi-pencil"></i> Edycja
                    </a>
                    <button role="button" class="btn btn-danger btn-sm" id="delete-button-${application.id}" endpoint="/deleteApplication/${application.id}>
                        <i class="bi bi-x"></i> Usuń
                    </button>
                `;
                const deleteButtonId = "delete-button-" + application.id;
                loadListeners(document.getElementById(deleteButtonId))
                });
            })
            .catch(error => console.error('Błąd pobierania danych z API:', error));
    }
    //table for user applications
    if(document.getElementById('user-apps-table')){
        fetch(baseApiLink +'/userId=' + localStorage.userId)
            .then(response => response.json())
            .then(data => {

                const table = document.getElementById('user-apps-table');


                data.forEach(application => {
                    const row = table.insertRow();
                    const applicationName = application.applicationName;
                    const formName = application.formName;
                    const baseLink = "http://localhost:8040/orbeon/fr/" + applicationName +"/" + formName;
                    const viewLink = baseLink + "/view/" + application.documentId;
                    const editLink = baseLink + "/edit/" + application.documentId;

                    const applicationId = row.insertCell(0);
                    applicationId.textContent = application.id;

                    const documentTitle = row.insertCell(1);
                    documentTitle.textContent = application.documentTitle;

                    const actionsCell = row.insertCell(2);
                    actionsCell.innerHTML = `
                    <a role="button" class="btn btn-primary btn-sm me-2" href=${viewLink}>
                        <i class="bi bi-eye"></i> Podgląd
                    </a>
                    <a role="button" class="btn btn-warning btn-sm me-2" href=${editLink}>
                        <i class="bi bi-pencil"></i> Edycja
                    </a>
                    <button role="button" class="btn btn-danger btn-sm delete-button" id="delete-button-${application.id}" endpoint="/deleteApplication/${application.id}">
                        <i class="bi bi-x"></i> Usuń
                    </button>
                `;
                const deleteButtonId = "delete-button-" + application.id;
                loadListeners(document.getElementById(deleteButtonId))
                });
            })
            .catch(error => console.error('Błąd pobierania danych z API:', error));
    }
}

function loadListeners(deleteButton){
    const baseApiLink = 'http://localhost:8080/api/application';
    deleteButton.addEventListener('click', function () {

        const apiUrl = baseApiLink + deleteButton.getAttribute('endpoint');
        const myModal = new bootstrap.Modal(document.getElementById('confirmationModal'), {
            keyboard: false
        });

        myModal.show();

        const confirmButton = document.getElementById('confirmButton');
        confirmButton.addEventListener('click', function () {
            removeApplication(apiUrl);
            myModal.hide();

        });
    });
}
function removeApplication(apiUrl) {
    const token = localStorage.getItem('jwtToken');

    fetch(apiUrl, {
        method: 'DELETE',
        headers: {
            'Authorization': 'Bearer ' + token
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            console.log('Entity has been removed successfully :', data);
            const successPopup = document.getElementById('success-remove-popup');
            showPopup(successPopup);
            refreshTable();
        })
        .catch(error => {
            console.error('Error during data removal:', error);
            const errorPopup = document.getElementById('error-popup');
            showPopup(errorPopup);
        });
}

function refreshTable(){
    let table;
    if(document.getElementById('all-apps-table')){
         table = document.getElementById('all-apps-table');
    }else if (document.getElementById('user-apps-table')){
         table = document.getElementById('user-apps-table');

    }

    while(table.rows.length>1){
        table.deleteRow(1);
    }
    fulfillTable();
}
