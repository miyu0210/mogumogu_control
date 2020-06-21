<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<label for="budget">予算</label><br />
<input type="text" name="budget" value="${budget.budget}" />円
<br /><br />

<label for="startday">開始日</label><br />
<input type="number" name="startday" min="1" max="31" value="${budget.startday}" />日
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
