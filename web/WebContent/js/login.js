
$('#btnLogin').click(function(){
var user=$('#user').val();
var password=$('#password').val();
	
	
	if(user=="" || password==""){
		alertify.alert("Por favor completa los dos campos")
	}else{
		$.ajax({
    		method:"POST",
    		url:"ControladorLogin",
    		async:true,
    		data:{
    				user:user,
    				password:password
    			},
    		}).done(function (data){
    			if(!isNaN(data)){
    				if(data!=0){
    					sessionStorage.setItem("userId", data);
        				window.location.replace("main.jsp");
    				}else{
    					alertify.alert("Clave o Usuario incorrecto");
    				}
    			}else{
        			alertify.alert("Ocurrio un error inesperado")

    			}
    		})
	}
})



