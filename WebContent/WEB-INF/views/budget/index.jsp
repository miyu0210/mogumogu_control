<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>設定</h2>
        <ul>
            <c:forEach var="budget" items="${budget}">
                <li>
                    <a href="${pageContext.request.contextPath}/budget/show?id=${budget.id}">
                        <c:out value="${budget.id}" />
                    </a>
                    : <c:out value="${budget.budget}"></c:out>&gt; <c:out value="${budget.startday}" />
                </li>
            </c:forEach>
        </ul>
        
        <p><a href="${pageContext.request.contextPath}/budget/new">新規登録</a></p>
    </c:param>
</c:import>