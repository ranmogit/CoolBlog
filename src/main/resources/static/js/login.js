function login() {
    $.ajax({
        url:"/login",
        type:"post",
        dataType:"JSON",
        data:$(".login").serialize(),
        success:function (map) {
            if(map.token!=null){
                localStorage.setItem("token",map.token);
                window.location.href="/success";
            }else{
                alert("token为空");
            }
        }
    })
}