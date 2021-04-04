<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login.html</title>
    <link rel="stylesheet" href="css/forms.css">
</head>

<body>
<main>
    <form action="/login" method="post">
        <fieldset>
            <div class="legend">
                <p>Welcome!</p>
                <img src="/images/1.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
            </div>
            <div class="form-element">
                <label for="user-email">username</label>
                <input type="username" name="username" id="user-username" placeholder="your username" required autofocus>
            </div>
            <div class="form-element">
                <label for="user-email">email</label>
                <input type="email" name="email" id="user-email" placeholder="your email" required autofocus>
            </div>
            <div class="form-element">
                <label for="user-password">password</label>
                <input type="password" name="user-password" id="user-password" placeholder="your password" required>
            </div>
            <div class="hr-line">
                <span class="details">one more step to go</span>
            </div>
        </fieldset>
    </form>
    <form action="/login" method="post">
        <fieldset>
            <INPUT TYPE="hidden" VALUE="registerPost" name="marker"/>
            <div class="form-element">
                <button class="register-button" type="submit">Register</button>
            </div>
        </fieldset>
    </form>
</main>
</body>

</html>