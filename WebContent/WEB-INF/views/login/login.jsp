<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>もぐもぐ管理</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style_login.css' />">
    </head>
    <body>
        <div id="weapper">
            <div id="header">
                <h1>もぐもぐ管理</h1>&nbsp;&nbsp;&nbsp;
            </div>
            <div id="content">
                <c:if test="${hasError}">
                    <div id="flush_error">
                        mailかpasswordが間違っています。
                    </div>
                </c:if>
        
        <br /><br /><br />
        <div class="label">
        <form method="POST" action="<c:url value='/login' />">
            <label for="mail">mail</label>
            <input type="text" name="mail" value="${mail}" />
            <br /><br />
            
            
            <label for="password">pass</label>
            <input type="password" name="password" />
            
            <br /><br />
            
            <input type="hidden" name="_token" value="${_token}" />
            <button type="submit">ログイン</button>
            
        </form>
        
            </div>
            <div id="footer">
            </div>
        </div>
        </div>
    </body>
</html>