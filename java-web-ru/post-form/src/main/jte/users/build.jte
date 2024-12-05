<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Создание нового пользователя</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<h1>Создание нового пользователя</h1>
<form action="/users" method="POST">
    <div>
        <label>
            Имя:
        <input type="text" name="firstName" />
        </label>
    </div>
    <div>
        <label>
            Фамилия:
        <input type="text" name="lastName" />
        </label>
    </div>
    <div>
        <label>
            Электронная почта:
        <input type="email" required name="email" />
        </label>
    </div>
    <div>
        <label>
            Пароль:
        <input type="password" required name="password" />
        </label>
    </div>
    <div>
        <input type="submit" value="Создать пользователя" />
    </div>
</form>

</body>
</html>
