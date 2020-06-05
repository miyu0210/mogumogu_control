<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>一覧</h2>
        <h3>${receipt_total}</h3>
        <table id="receipt_list">
            <tbody>
                <tr>
                    <th class="receipt_date">日付</th>
                    <th class="receipt_totalamount">金額</th>
                    <th class="rreceipt_action">編集</th>
                </tr>
                <c:forEach var="receipt" items="${receipt}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="receipt_date"><fmt:formatDate value='${receipt.receipt_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="recetipt_totalamount">${receipt.totalamount}</td>
                        <td class="receipt_action"><a href="<c:url value='/receipt/show?id=${receipt.id}' />">詳細</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="<c:url value='/receipt/new' />">新規</a></p>

    </c:param>
</c:import>