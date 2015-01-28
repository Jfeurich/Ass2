<%@ page import="Model.Pattern" %>
<form action="PatternEditor.do" method="post">
    <table>
        <tr>
            <th>Username</th><td><input type="text" name="username" value="${cookie.username.value}" /></td>
        </tr>
        <tr>
            <th>Password</th><td><input type="password" name="password" /></td>
        </tr>
    </table>
    <p><input type="submit" value="Login!" /></p>
</form>
