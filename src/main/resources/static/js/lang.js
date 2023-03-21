function changeLanguage(pageName) {
    $("#locales").change(function () {
        const option = $('#locales').val();
        if (option != ''){
            window.location.replace(`${pageName}?lang=${option}`);
        }
    })
}
function changeLanguageOnReady(pageName){
    $(document).ready(function() {
        changeLanguage(pageName);
    })
}