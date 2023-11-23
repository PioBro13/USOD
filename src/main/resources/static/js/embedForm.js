
    ORBEON.fr.API.embedForm(
        document.getElementById("form-viewer"),
        "http://localhost:8040/orbeon",
        "summary",
        "student_financal_summary",
        "new"
    )
        .then(() => {
            console.log("`embedForm()` successfully loaded the form");
        })
        .catch((e) => {
            console.log("`embedForm()` returned an error");
            console.log(e);
        });
