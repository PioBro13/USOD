document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('logout').addEventListener('click', function (event) {
        const content = document.getElementById('content');
        const adminContent = document.getElementById('content-admin');

        content.classList.add("hide");
        if(adminContent){
            adminContent.classList.add("hide");
        }
        localStorage.clear();
        window.location.href = '/';
    });
});