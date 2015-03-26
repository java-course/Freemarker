[#ftl]
[#import "spring.ftl" as spring]
<h2 style="color:cadetblue;">Users</h2>
<table>
    <tr>
        <td bgcolor="cadetblue"><b>Login</b></td>
        <td bgcolor="cadetblue"><b>Password</b></td>
        <td bgcolor="cadetblue"><b>Email</b></td>
        <td bgcolor="cadetblue"><b>Actions</b></td>
    </tr>
    [#assign rowCount = 1]
    [#list users as user]
        [#if (rowCount % 2 == 0)]
            [#assign bgcolor = "#FFFFFF"]
        [#else]
            [#assign bgcolor = "#CCCCCC"]
        [/#if]
    <tr>
        <td bgcolor="$bgcolor">${user.login}</td>
        <td bgcolor="$bgcolor">${user.password}</td>
        <td bgcolor="$bgcolor">${user.email}</td>


        <td><a href="/users.htm?action=edit&userId=${user.userId}">edit</a>&nbsp;<td><a href="/users.htm?action=delete&userId=${user.userId}">delete</a>
    </tr>
    [#assign rowCount = rowCount + 1]
    [/#list]
</table>



<form action="" method="post">
[@spring.bind "newUser"/]
    <table>
        <tr>
            <td>Login</td>
            <td>
               [@spring.formInput "newUser.login"/]
               [@spring.showErrors "<br/>", "color:red;"/]

            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                   [@spring.formPasswordInput "newUser.password"/]
                   [@spring.showErrors "<br/>", "color:red;"/]
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                   [@spring.formInput "newUser.email"/]
                   [@spring.showErrors "<br/>", "color:red;"/]
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="submit"/></td>
        </tr>
    </table>


</form>
