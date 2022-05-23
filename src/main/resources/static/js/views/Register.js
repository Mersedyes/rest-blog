export default function Register() {
    return `
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>Register</title>
        </head>
        <body>
        <h1>Register!</h1>
        
        <form id="register-form">
            <label for="username">Username</label>
            <input type="text" name="username" id="username"/>
            <label for="email">Email</label>
            <input type="email" name="email" id="email"/>
            <label for="password">Password</label>
            <input type="password" name="password" id="password"/>
            <input id="register-btn" type="submit" value="Register"/>
       </form>
       </body>
       </html>
    `;
}

export function RegisterEvent() {
    $(document).on('click', '#register-btn', function (e) {
        const reqBody = {
            username: $('#username').val(),
            email: $('#email').val(),
            password: $('#password').val()
        }

        const options = {
            headers: {
                "Content-Type":"application/json"
            },
            method: 'POST',
            body: JSON.stringify(reqBody)
        }

        fetch("http//localhost:8080/api/users", options)
            .then(response => response.json())
            .then(data => console.log(data))
            .catch(error => console.log(error))
    })
}