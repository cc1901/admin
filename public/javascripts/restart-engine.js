$(function () {
    $('#restart-server').on('click', function(){
        $.get('/restart-engine');
    });
});