<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="receipt_date">日付</label><br />
<input type="date" name="receipt_date" value="<fmt:formatDate value='${receipt.receipt_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="totalamount">金額</label><br />
<input type="text" name="totalamount" value="${receipt.totalamount}" />円
<br /><br />

<label for="payment">決済方法</label><br />
<input type="text" name="payment" value="${receipt.payment}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
