function changeLanguage(pageName) {
    $("#locales").change(function () {
        const selectedOption = $('#locales').val();
        if (selectedOption != ''){
            window.location.replace(`${pageName}?lang=${selectedOption}`);
        }
    })
}
function changeLanguageOnReady(pageName){
    $(document).ready(function() {
        changeLanguage(pageName);
    })
}