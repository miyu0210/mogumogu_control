<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="budget">予算</label><br />
<input type="text" name="budget" value="${budget.budget}" />
<br /><br />

<label for="startday">開始日</label><br />
<input type="text" name="startday" value="${budget.startday}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
