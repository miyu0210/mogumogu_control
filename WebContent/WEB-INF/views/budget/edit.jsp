<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>設定</h2>
        
        <form method="POST" action="<c:url value='/budget/update' />">
        
        <label for="budget">予算</label>
        <input type="text" name="budget" value="${budget.budget}" />円
        <br /><br />
        
        <label for="startday">開始日</label>
        <input type="number" name="startday" min="1" max="31" value="${budget.startday}" />日
        <br /><br />

        <input type="hidden" name="_token" value="${_token}" />
        <button type="submit">変更</button>
        </form>
        
        <p><a href="<c:url value='/receipt/index' />">戻る</a></p>
        
    </c:param>
</c:import>