<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2> All Users</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="usrs" items="${allUsrs}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="usrId" value="${usrs.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="usrId" value="${usrs.id}"/>
        </c:url>

        <tr>
            <td>${usrs.name}</td>
            <td>${usrs.surname}</td>
            <td>${usrs.age}</td>
            <td>
                <input type="button" value="Update"
                onClick = "window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                       onClick = "window.location.href = '${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>

</table>

<br>

<input type="button" value="Add"
    onclick="window.location.href = 'addNewUser'"/>




</body>








</html>