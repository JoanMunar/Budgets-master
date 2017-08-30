<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
    <head>
        <title>BudgetList</title>
    </head>
    <body>
        <tag:logOut></tag:logOut>
        <h1>Llista de presuposts</h1>
        <tag:budgetList></tag:budgetList>
        <a href="createBudget.jsp">Afegir presupost</a>
    </body>
</html>
