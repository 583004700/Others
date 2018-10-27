$.ajax({
    url:"http://localhost/hello?name=zwb",
    type:"post",
    success:function(data){
        alert(data);
    }
});