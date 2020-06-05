<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        
        <form method="POST" action="<c:url value='/receipt/create' />">
            <c:import url="_form.jsp" />
        </form>
        
        <p><a href="<c:url value='/topPage/index' />">戻る</a></p>
    </c:param>
    
</c:import>