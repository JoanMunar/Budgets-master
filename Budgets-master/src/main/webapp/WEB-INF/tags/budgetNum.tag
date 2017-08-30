<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:forEach items="${requestScope['bLine']}" var = 'budget_line'>

    <c:set var = "string1" value = "${budget_line.id}"/>
    <c:set var = "string2" value = "${fn:substring(string1, 0, 1)}" />

</c:forEach>

${string2}