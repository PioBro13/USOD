
    ORBEON.fr.API.embedForm(
        document.getElementById("form-viewer"),
        "/orbeon",
        "document",
        "TEST_FORM",
        "new"
    )
        .then(() => {
            console.log("`embedForm()` successfully loaded the form");
        })
        .catch((e) => {
            console.log("`embedForm()` returned an error");
            console.log(e);
        });
