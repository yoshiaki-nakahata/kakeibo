<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>日報管理システムへようこそ</h2>
    </c:param>
</c:import>


<!DOCTYPE html>
<html lang="ja">

<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style2.css' />">

<h2>出費/内容</h2>
<table class="table_box">
	<tr>
		<th class="kakeibo_date">日付</th>
		<th class="syokuhi">食費</th>
		<th class="nitiyouhin">日用品</th>
		<th class="kousai">交際費</th>
		<th class="biyou">美容</th>
		<th class="koutuu">交通費</th>
		<th class="iryou">医療</th>
		<th class="tuusin">通信費</th>
		<th class="suidou">水道</th>
		<th class="gasu">ガス</th>
		<th class="denki">電気</th>
		<th class="yatin">家賃</th>
		<th class="zeikin">税金</th>
		<th class="hoken">保険</th>
		<th class="sonota">その他</th>
		<th>  </th>
</tr>

<tr class="row${status.count % 2}">
	<c:forEach var="kakeibo" items="${kakeibos}" varStatus="status">
	<tr>
			<td class="kakeibo_date"><fmt:formatDate value='${kakeibo.kakeibo_date}' pattern='yyyy-MM-dd' /></td>
			<td class="kakeibo_syokuhi">${kakeibo.syokuhi}</td>
			<td class="kakeibo_nitiyouhin">${kakeibo.nitiyouhin}</td>
			<td class="kakeibo_kousai">${kakeibo.kousai}</td>
			<td class="kakeibo_biyou">${kakeibo.biyou}</td>
			<td class="kakeibo_koutuu">${kakeibo.koutuu}</td>
			<td class="kakeibo_iryou">${kakeibo.iryou}</td>
			<td class="kakeibo_tuusin">${kakeibo.tuusin}</td>
			<td class="kakeibo_suidou">${kakeibo.suidou}</td>
			<td class="kakeibo_gasu">${kakeibo.gasu}</td>
			<td class="kakeibo_denki">${kakeibo.denki}</td>
			<td class="kakeibo_yatin">${kakeibo.yatin}</td>
			<td class="kakeibo_zeikin">${kakeibo.zeikin}</td>
			<td class="kakeibo_hoken">${kakeibo.hoken}</td>
			<td class="kakeibo_sonota">${kakeibo.sonota}</td>
			<td><a href="<c:url value='/edit?id=${kakeibo.id}' />">編集する</a></td>

</c:forEach>
</tr>
</table>

<div id="pagination">
	（全 ${kakeibo_count} 件）<br />
	<c:forEach var="i" begin="1" end="${((kakeibos_count - 1) / 15) + 1}"
		step="1">
		<c:choose>
			<c:when test="${i == page}">
				<c:out value="${i}" />&nbsp;
                    </c:when>
			<c:otherwise>
				<a href="<c:url value='/kakeibos/index?page=${i}' />"><c:out
						value="${i}" /></a>&nbsp;
                    </c:otherwise>
		</c:choose>
	</c:forEach>
</div>

 <p><a href="<c:url value='/new' />">新規入力</a></p>