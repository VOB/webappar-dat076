<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- NOTHING TO DO HERE -->
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/partials/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/partials/header.jsp"/>
        <jsp:useBean id="bean" scope="request" class="orm.beans.ViewModel"/>
        <p> Delete ${param.id}</p>
        <c:set var="note" value="${bean.getById(param.id)}" />
        <form action="/jee_orm/fc" method="post">
            <input type="hidden" name="action" value="delete" />
            <table>         
                <tr>
                    <td><input type="text" name="id" value="${note.id}" readonly /> </td>
                </tr>
                <tr>
                    <td><input type="text" name="text" value="${note.text}" disabled /></td>
                </tr>
                <tr>
                    <td><input type="text" name="dateTime" value="${note.dateTime}" disabled /></td>
                </tr>
                <tr>
                    <td><input type="submit" name="update" value="Delete" /></td>
                </tr>
            </table>
        </form>
        <a href="/jee_orm/list.jsp"> Cancel</a>
        <jsp:include page="/partials/footer.jsp"/>
    </body>

</html>


