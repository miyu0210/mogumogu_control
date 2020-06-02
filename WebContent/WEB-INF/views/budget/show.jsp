<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    
        <h2>詳細</h2>
        <p>予算:<c:out value="${budget.budget}" /></p>
        <p>開始日:<c:out value="${budget.startday}" /></p>
        
        <p><a href="${pageContext.request.contextPath}/budget/index">戻る</a></p>
        <p><a href="${pageContext.request.contextPath}/budget/edit?id=${budget.id}">編集</a></p>
        
    </c:param>
</c:import>