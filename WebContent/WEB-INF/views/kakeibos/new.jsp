<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style2.css' />">
        <h2>新規登録ページ</h2>

        <form method="POST" action="<c:url value='/create' />">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="<c:url value='/index' />">一覧に戻る</a></p>
