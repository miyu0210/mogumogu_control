<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

       <form method="POST" action="<c:url value='/receipt/create' />">
            <c:import url="_form.jsp" />
       </form>
        <div class="z-box">
        <div class="box">
        <span class ="box-title">予算</span>
        <% Integer budget = (Integer) request.getAttribute("budget"); %>
        <p>${budget}円</p>
        </div>&nbsp;&nbsp;
        <div class="box">
        <span class="box-title">使用金額</span>
        <c:forEach var="m_total" items="${m_total}">
                   <p><c:out value="${m_total.sumM}"></c:out>円</p>
        </c:forEach>
        </div>&nbsp;&nbsp;
        <div class="box">
        <span class="box-title">残金</span>
                   <p>${zan}円</p>
        </div>
        </div>
        <br /><br />
        
        <c:import url="matome.jsp" />
        
    </c:param>
</c:import>