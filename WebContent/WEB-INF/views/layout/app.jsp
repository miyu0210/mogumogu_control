<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>もぐもぐ管理</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="weapper">
            <div id="header">
                <h1><a href="<c:url value='/' />">もぐもぐ管理</a></h1>&nbsp;&nbsp;&nbsp;
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                <c:if test="${sessionScope.login_user != null}">
                <a href="<c:url value='/logout' />">ログアウト</a>
                </c:if>
            </div>
        </div>

    </body>
</html>