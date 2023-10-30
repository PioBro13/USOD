document.addEventListener('DOMContentLoaded', function() {
    const examInput = document.getElementById('exam');
    toggleSwitch(examInput);
});

function toggleSwitch(toggle) {
    toggle.addEventListener('change',function (){
        if (toggle.checked) {
            toggle.value = 'true';
        } else {
            toggle.value = 'false';
        }
    });
}