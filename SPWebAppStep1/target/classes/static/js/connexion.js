async function send_sign() 
{
    json_obj=JSON.stringify({
        name: document.getElementById("userName_input").value,
        surname: document.getElementById("userSurname_input").value,
        password: document.getElementById("userPassword_input").value
	});
        

    fetch("/addUser", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        body: json_obj
    });
    

}

async function send_log() 
{
    json_obj=JSON.stringify({
        surname: document.getElementById("userSurname_input").value,
        password: document.getElementById("userPassword_input").value
	});
        

    fetch("/logIn", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        body: json_obj
    });
    

}