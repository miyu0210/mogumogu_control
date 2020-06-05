<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        
            
                <h2>編集ページ</h2>
                <form method="POST" action="<c:url value='/receipt/update' />">
                    <c:import url="_form.jsp" />
                </form>
                
                <p><a href="#" onclick="confirmDestroy();">削除する</a></p>
                <form method="POST" action="${pageContext.request.contextPath}/receipt/destroy">
                     <input type="hidden" name="_token" value="${_token}" />
                 </form>
                 <script>
                 function confirmDestroy() {
                	    if(confirm("本当に削除してよろしいですか？")) {
                	        document.forms[1].submit();
                	        }
                	    }
                 </script>
        
        <p><a href="<c:url value='/receipt/index' />">戻る</a></p>
    </c:param>
</c:import>