document.addEventListener("DOMContentLoaded", function () {
    const orbeonBaseLink = "http://localhost:8040/orbeon/fr";
    const userId = '?id=' + localStorage.getItem('userId');
    const resultsSummary = document.getElementById('results-overall-summary');
    const financesSummary = document.getElementById('overall-finances-summary');
    if(resultsSummary){
        resultsSummary.addEventListener('click', function () {
            window.location.href= orbeonBaseLink + '/summary/student_results_summary/new' +  userId;
        });
    }
    if(financesSummary){
        financesSummary.addEventListener('click', function () {
            window.location.href= orbeonBaseLink + '/summary/student_financial_summary/new' +  userId;
        });
    }

    }
);