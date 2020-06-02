<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>編集ページ</h2>
        
        <form method="POST" actiom="${pageContext.request.contextPath}/budget/update">
            <c:import url="_form.jsp" />
        </form>
        
        <p><a href="${pageContext.request.contextPath}/budget/index">戻る</a></p>
        
    </c:param>
</c:import>