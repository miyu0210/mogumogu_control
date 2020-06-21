<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>月の選択</title>
    </head>
    <body>
        <form action="<c:url value='/receipt/index' />" method="get">
            <select name="select_month">
                <c:forEach var="month" items="${months}">
                    <option value="${month}" <c:if test="${month eq selected_month}">selected</c:if>>
                    <fmt:parseDate value="${month}" pattern="yyyy-MM-dd" var="parseMonth" type="date" />
                    <fmt:formatDate value="${parseMonth}" var="displayMonth" type="date" pattern="yyyy年MM月" />
                    ${displayMonth}</option>
                </c:forEach>
            </select>
            <button type="submit">対象月選択</button>
        </form>

        <br /><br />
        <table id="receipt_list">
            <tbody>
                <tr>
                    <th>日付</th>
                    <th>金額</th>
                    <th>編集</th>
                   
                </tr>
                <c:forEach var="d_total" items="${d_total}" varStatus="status">
                    <tr>
                        <td><c:out value="${d_total.receipt_date}" /></td>
                        <td><c:out value="${d_total.sum}" />円</td>
                        <td><a href="<c:url value='/receipt/daytotal?receipt_date=${d_total.receipt_date}' />">詳細</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>