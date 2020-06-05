<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>もぐもぐ管理</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="header_menu">
                    <h1><a href="c:url value='/' />">もぐもぐ管理</a></h1>&nbsp;&nbsp;&nbsp;
                    <a href="<c:url value='/budget/new' />">設定</a>&nbsp;
                </div>
            </div>
        </div>
        <div id="content">
            <h2>新規登録</h2>
            <form method="POST" action="<c:url value='/receipt/create' />">
                <c:import url="../receipt/_form.jsp" />
            </form>
        </div>
        <div id="footer">
            <c:if test="${sessionScope.login_user != null}">
                <a href="<c:url value='/logout' />">ログアウト</a>
            </c:if>
        </div>
    </body>
</html>