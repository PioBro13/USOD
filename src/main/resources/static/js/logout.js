document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('logout').addEventListener('click', function (event) {
        const content = document.getElementById('content');
        const adminContent = document.getElementById('content-admin');
        const logoutButton = document.getElementById('logout');
        const loginButton = document.getElementById('login');

        if(content){
            content.classList.add("hide");
        }

        if(adminContent){
            adminContent.classList.add("hide");
        }
        if(loginButton){
            logoutButton.classList.add("hide");
            loginButton.classList.remove("hide");
        }

        localStorage.clear();
        window.location.href = '/';
    });
});