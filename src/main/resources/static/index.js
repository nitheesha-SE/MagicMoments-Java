$(document).ready(function() {
    $.ajax({
        url: "https://7d77d4069bab1b5b.azurewebsites.net/car"
        // url: "http://localhost:8080/car"
    }).then(function(data) {
        $('.greeting-content').append(data.data[0].status);

        if ("OFF" === data.data[0].status) {
            $('#image-zoom img')
                .attr("src", "https://production-assets2.autolist.com/production/lifestyle_gallery/hash/7/9/8/8bc3ad7cbdb948130c8ae062a4589ce740b0c897.jpg");
        } else {
            $('#image-zoom img')
                .attr("src", "https://i.pinimg.com/236x/a6/e6/98/a6e6981a4c0cf678c3e18f02a4931695--ford-mondeo-ford-fusion.jpg");

        }
    });
});