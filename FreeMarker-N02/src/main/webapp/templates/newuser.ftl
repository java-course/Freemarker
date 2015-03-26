[#ftl]
[#include "header.ftl"/]

<form action="/newuser" method="POST">

    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td></tr>
        <tr>
            <td>Surname</td>
            <td><input type="text" name="surname"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form>