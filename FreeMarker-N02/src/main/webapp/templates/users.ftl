[#ftl]

[#macro printUserTable usersList]
<table>
    <tr>
        <td>name</td>
        <td>surname</td>
        <td>email</td>
        <td>age</td>
        <td>action</td>
    </tr>

    [#list usersList as user]

        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td><a href="/users?delete=${user.name}">Delete</a></td>
        </tr>
    [/#list]

</table>
[/#macro]
[#--[#import "macro.ftl" as m/]--]
<html>

    <head><title>User management</title></head>

    <body>

    [#include "header.ftl"/]


    [#--[@m.printUserTable "users"/]--]
    [@printUserTable users/]



    </br>
    </br>

    <a href="/newuser">Create new user</a>





    </body>


</html>