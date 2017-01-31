<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- NOTHING TO DO HERE -->
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/partials/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/partials/header.jsp"/>
        <form action="fc" method="post">
            <input type="hidden" name="action" value="add"/>
            <table>
                <tbody>
                    <tr>
                        <td>Text</td>
                        <td><input type="text" name="text"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Add"</td>
                    </tr>
                </tbody>
            </table>
        </form>
        <a href="/jee_orm/list.jsp"> Cancel</a>
        <jsp:include page="/partials/footer.jsp"/>
    </body>
</html>
