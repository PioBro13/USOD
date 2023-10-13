function showPopup(popup) {
    if(popup) {
        popup.style.display = 'block';

        // Automatyczne ukrycie popupa po 3 sekundach
        setTimeout(function(){
            popup.style.display = 'none';
        }, 3000);
    } else {
        console.error('Error: Element not found');
    }
}