$(function() {
    $('#messages li').click(function() {
        $(this).fadeOut();
    });
    setTimeout(function() {
        $('#messages li.info').fadeOut();
    }, 3000);
    setClass(function(){
        $('#messages li.error').addClass("alert alert-danger alert-dismissible");
    })
});