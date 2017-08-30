<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${requestScope['bList'] != null}">
        <table>
            <tr>
                <th>Id Presupostos</th>
            </tr>
            <c:forEach items="${requestScope['bList']}" var = 'budget'>
                <tr>
                    <td><a href="BudgetLine?id=${budget.id_budget}" id="id_budget"><c:out value="${budget.id_budget}"></c:out></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:when>

</c:choose>
