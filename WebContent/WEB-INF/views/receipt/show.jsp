<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${receipt != null}">
                <h2>詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>日付</th>
                            <td><fmt:formatDate value="${receipt.receipt_date}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>金額</th>
                            <td>
                                <pre><c:out value="${receipt.totalamount}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${receipt.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${receipt.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                
                    <p><a href="<c:url value="/receipt/edit?id=${receipt.id}" />">編集する</a></p>
                
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/receipt/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>