$(document).ready(function () {
    pollServer();
});

function pollServer() {
    $.ajax({
        url: "https://7d77d4069bab1b5b.azurewebsites.net/car"
        // url: "http://localhost:8080/car"
    }).then(function (data) {
        var car = data.data[0].car;

        if(car.charging){
            $(".night").prop('checked', true);
            $(".neon").prop('checked', true);
        } else {
            $(".night").prop('checked', false);
            $(".neon").prop('checked', false);
        }

        $(".run").prop('checked', car.running);
        $(".bonnet").prop('checked', car.openBonnet);
        $(".luggage").prop('checked', car.openTrunk);
        $(".door").prop('checked', car.openDoor);
        $(".roof").prop('checked', car.openTop);
        $(".headlight").prop('checked', car.lightsOn);
        $(".window").prop('checked', car.openWindow);
        $(".charging").attr('data-text', car.batteryLevel + "%");


        setTimeout(pollServer, 500);
    });
}