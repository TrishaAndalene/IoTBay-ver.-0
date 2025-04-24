
// for changing the sign up page
var currentPage;
var pages = ["page-1", "page-2"];

function continuePage(x){
    currentPage = x;

    for (var i = 0; i < pages.length; i++){
        document.getElementById(pages[i]).style.display = "none";
    }
    console.log(pages[x-1]);
    document.getElementById(pages[x-1]).style.display = "flex";
}

function redirect(){
    window.location.href = "http://localhost:8080/webapp/index.jsp";
}

function toPrevious(){
    window.location.href = "http://localhost:8080/webapp/jsp/Main.jsp";
}