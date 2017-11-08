
var token = localStorage.getItem("token");
$.ajaxSetup({
    dataType:"JSON",
    cache:false,
    headers:{
        "token":token
    }
})