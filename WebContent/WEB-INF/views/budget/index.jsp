<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>予算</h2>
        
        <table class="budget">
            <tr>
                <th>予算金額</th>
                <th>開始日</th>
                <th>　　　</th>
            </tr>
            <c:forEach var="budget" items="${budget}">
                <tr>
                    <td><c:out value="${budget.budget}円"></c:out></td>
                    <td><c:out value="${budget.startday}日" /></td>
                    <td><a href="${pageContext.request.contextPath}/budget/edit?id=${budget.id}">
                        <c:out value="編集" /></a></td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="<c:url value='/receipt/index' />">戻る</a></p>
    </c:param>
</c:import>