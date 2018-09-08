$(document).ready(function() {
    $.ajax({
        url: "https://7d77d4069bab1b5b.azurewebsites.net/car"
    }).then(function(data) {
        $('.greeting-content').append(data.status);
    });
});