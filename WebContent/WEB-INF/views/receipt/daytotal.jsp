<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">

    <c:param name="content">
       <h2>${today}の詳細</h2>
       <div class="box">
        <span class="box-title">合計</span>
        <c:forEach var="d_total" items="${d_total}">
                   <p><c:out value="${d_total.sum}"></c:out>円</p>
        </c:forEach>
        </div>
       
       
       <br /><br />
       <form method="POST" action="<c:url value='/receipt/create' />">
       <div class="z-box2">
        <label for="receipt_date">日付</label>
        <input type="date" class="hako" name="receipt_date" value="<fmt:formatDate value='${today}' pattern='yyyy-MM-dd' />" />
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
        </form>
        <br /><br /><br />
        <table id="receipt_list">
            <tbody>
                <tr>
                    <th>日付</th>
                    <th>金額</th>
                    <th>決済方法</th>
                    <th>編集</th>
                   
                </tr>
                <c:forEach var="daytotal" items="${daytotal}" varStatus="status">
                    <tr>
                        <td><c:out value="${daytotal.receipt_date}" /></td>
                        <td><c:out value="${daytotal.totalamount}" />円</td>
                        <td><c:out value="${daytotal.payment}" /></td>
                        <td><a href="<c:url value="/receipt/edit?id=${daytotal.id}" />">編集</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
              
        <p><a href="<c:url value="/receipt/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>