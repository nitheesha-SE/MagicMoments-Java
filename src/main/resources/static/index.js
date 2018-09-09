$(document).ready(function() {
    pollServer();
});

function pollServer(){
    $.ajax({
        url: "https://7d77d4069bab1b5b.azurewebsites.net/car"
        // url: "http://localhost:8080/car"
    }).then(function(data) {
        if ("ON" === data.data[0].status) {
            $(".run").prop('checked',true);
        } else {
            $('.run').prop('checked',false);
        }
        setTimeout(pollServer, 500);
    });
}