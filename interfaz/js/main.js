$('#btnLogin').click(function(){

    var data = {
        user:$('#user').val(),
        pass:$('#password').val()
    }

    console.log(data);
} )