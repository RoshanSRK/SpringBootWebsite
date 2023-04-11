const loginBtn = document.querySelector('#login-btn');
const registerBtn = document.querySelector('#register-btn');


const registerUser =  async() => {

    let name = document.getElementById("name").value;
    let dob = document.getElementById("dob").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    // let response = await fetch('http://localhost:8080/api/v1/user/all');

    let response2 = await fetch('http://localhost:8080/api/v1/user/save',
    {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "name": name,
            "email": email,
            "password": password,
            "dob": dob
          })

    })
    // console.log(response);
    // console.log(response2);

}


// loginBtn.addEventListener('click', validateUser);
registerBtn.addEventListener('click', registerUser);
