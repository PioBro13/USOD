document.addEventListener('DOMContentLoaded', function () {
    if(document.getElementById('all-apps-table')){
        fetch('http://localhost:8080/api/application')
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
                    <a role="button" class="btn btn-danger btn-sm">
                        <i class="bi bi-x"></i> Usuń
                    </a>
                `;

                });
            })
            .catch(error => console.error('Błąd pobierania danych z API:', error));
    }
    if(document.getElementById('user-apps-table')){
        fetch('http://localhost:8080/api/application/userId=' + localStorage.userId)
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
                    <a role="button" class="btn btn-danger btn-sm">
                        <i class="bi bi-x"></i> Usuń
                    </a>
                `;

                });
            })
            .catch(error => console.error('Błąd pobierania danych z API:', error));
    }
});
