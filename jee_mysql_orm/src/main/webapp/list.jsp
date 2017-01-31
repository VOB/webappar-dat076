<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- NOTHING TO DO HERE -->
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/partials/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/partials/header.jsp"/>
        <jsp:useBean id="bean" scope="request" class="orm.beans.ViewModel"/>
        <table>
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Text</td>
                    <td>Date</td>
                    <td>Done</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="note" items="${bean.notes}" >
                    <tr>
                        <td>${note.id}</td>
                        <td>${note.text}</td>
                        <td>${note.dateTime}</td>
                        <td>${note.done}</td>
                        <td><a href="/jee_orm/delete.jsp?id=${note.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add.jsp"> Add </a>
        <jsp:include page="/partials/footer.jsp"/>
    </body>
</html>
