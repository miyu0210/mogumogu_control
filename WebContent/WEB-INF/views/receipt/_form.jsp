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
<div class="z-box2">
<label for="receipt_date">日付</label>
<input type="date" class="hako" name="receipt_date" value="<fmt:formatDate value='${receipt.receipt_date}' pattern='yyyy-MM-dd' />" />
&nbsp;&nbsp;&nbsp;
<label for="totalamount">金額</label>
<input type="text" class="hako2" name="totalamount" value="${receipt.totalamount}" />円
&nbsp;&nbsp;&nbsp;
<label for="payment">決済方法</label>
<input type="text" class="hako2" name="payment" value="${receipt.payment}" list="pay" autocomplete="off" />
<datalist id="pay">
<option value="現金">
<option value="ID">
<option value="LINEPAY">
<option value="d払い">
</datalist>
&nbsp;&nbsp;&nbsp;
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
</div>