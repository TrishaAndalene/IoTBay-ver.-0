
// for changing the sign up page
var currentPage = 0;
var pages = ["formOne", "formTwo", "formThree"];

function continuePage(y){
    currentPage = y;
    var x = document.forms["form1"];
    var start = 0;
    var end = 0;

    for (var i = 0; i < x.length; i++){
        x.elements[i].style.display = "none";
    }
    
    if (y == 1){
        start = 0;
        end = 1;
    } else if (y == 2){
        start = 2;
        end = 4;
    } else {
        start = 5;
        end = x.length -1;
    }

    for (var n = start; n <= end; n++){
        x.elements[n].style.display = "block";
    }

}
