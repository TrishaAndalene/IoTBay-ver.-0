// for changing the sign up page
var currentPage;
var pages = ["page-1", "page-2", "page-3", "page-4"];

function continuePage(x){
    currentPage = x;

    for (var i = 0; i < pages.length; i++){
        document.getElementById(pages[i]).style.display = "none";
    }
    console.log(pages[x-1]);
    document.getElementById(pages[x-1]).style.display = "flex";
}