<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Freemarker Sample Page</title>
    <link href="css/freemarker.css" rel="stylesheet">
</head>
<body>

<h1>"У нас есть книги " </h1>
<ul>
    <#list books as book>
        <li>${book.name}</li>
        <li>${book.name}</li>
        <li>${book.name}</li>
        <li>${book.name}</li>
    </#list>
</ul>

</body>
</html>