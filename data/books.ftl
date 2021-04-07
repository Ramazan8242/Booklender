<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>books.ftl</title>
    <link href="css/freemarker.css" rel="stylesheet">
</head>
<body>
<h1>КНИГИ!</h1>
<ul>
    <div class="legend">
        <img src="/images/Война_и_мир.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
        <#list books as book>
            <li>${book.name} написанная ${book.author} статус ${book.status}</li>
        </#list>
    </div>
    <div class="legend">
        <img src="/images/К_маяку.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
        <#list books as book>
            <li>${book.name} написанная ${book.author} статус ${book.status}</li>
        </#list>
    </div>
    <div class="legend">
        <img src="/images/Лолита.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
    </div>
    <#list books as book>
        <li>${book.name} написанная ${book.author} статус ${book.status}</li>
    </#list>
    <div class="legend">
        <img src="/images/uliss.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
        <#list books as book>
            <li>${book.name} написанная ${book.author} статус ${book.status}</li>
        </#list>
    </div>
    <div class="legend">
        <img src="/images/Невидимка.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
        <#list books as book>
            <li>${book.name} написанная ${book.author} статус ${book.status}</li>
        </#list>
    </div>
<#--    <#list books as book>-->
<#--        <li>${book.name} написанная ${book.author} статус ${book.status}</li>-->
<#--    </#list>-->
</ul>
</body>
</html>