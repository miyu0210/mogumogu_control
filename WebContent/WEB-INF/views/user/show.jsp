<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${user != null}">
                <h2>id : ${user.id} の詳細ページ</h2>
                
                <table>
                    <tbody>
                        <tr>
                            <th>メールアドレス</th>
                            <td><c:out value="${user.mail}" /></td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${user.created_at}" pattern="yyyy-MM-dd" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${user.updated_at}" pattern="yyyy-MM-dd" />
                            </td>
                        </tr>
                    </tbody>
                </table>
                
                <p><a href="<c:url value='/user/edit?id=${user.id}' />">編集する</a></p>
            </c:when>
        <c:otherwise>
            <h2>お探しのデータは見つかりませんでした。</h2>
        </c:otherwise>
    </c:choose>
    
        <p><a href="<c:url value='/user/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>