<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>ログイン情報一覧</h2>
        <table id="user_list">
            <tbody>
                <tr>
                    <th>メールアドレス</th>
                    <th>詳細</th>
                </tr>
                <c:forEach var="user" items="${user}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${user.mail}" /></td>
                        <td>
                            <a href="<c:url value='/user/show?id=${user.id}' />">詳細を表示</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:param>
</c:import>