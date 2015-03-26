[#macro printUserTable  usersList]
<table>
    <tr>
        <td>name</td>
        <td>surname</td>
        <td>email</td>
        <td>age</td>
        <td>action</td>
    </tr>

        [#list usersList as u]

        <tr>
            <td>${u.name}</td>
            <td>${u.surname}</td>
            <td>${u.email}</td>
            <td>${u.age}</td>
            <td><a href="/users?delete=${u.name}">Delete</a></td>
        </tr>
    [/#list]

</table>
[/#macro]