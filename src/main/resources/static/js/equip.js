

$(document).ready(function(){
    $('#myselection').on('change', function(){
        let demovalue = $(this).val();
        $("div.myDiv").hide();
        $("#show"+demovalue).show();
    });
});
