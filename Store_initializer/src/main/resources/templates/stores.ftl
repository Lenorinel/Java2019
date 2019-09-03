<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Stores</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div>
    <table class ="table">
        <thead class = "thread-dark">
           <tr>
               <th>ID</th>
               <th>Store Name</th>
               <th>Address</th>
               <th>Work Time</th>
               <th>Comment</th>
               <th>Вещей из магазина</th>
           </tr>
        </thead>
        <#list stores as store>
            <tr>
                <td>${store.id}</td>
                <td>${store.name}</td>
                <td>${store.address}</td>
                <td>${store.workTime}</td>
                <td>${store.comment}</td>
                <td>${store.count}</td>
                <td><a href="plus?store=${store.id}">Купленные товары</a></td>
            </tr>
        </#list>
    </table>
</div>
<div>
    <form method="post">
        <input type="text" name="name" placeholder="Название магазина">
        <br>
        <input type="text" name="address" placeholder="Адрес">
        <br>
        <input type="text" name="workTime" placeholder="Часы работы">
        <br>
        <input type="text" name="comment" placeholder="Комментарий">
        <br>
        <input type="submit" value="Save">
    </form>
</div>
</body>

</html>