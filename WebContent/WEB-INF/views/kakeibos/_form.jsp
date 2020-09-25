<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<label for="kakeibo_date">日付</label>
<br />
<input type="date" name="kakeibo_date"
	value="<fmt:formatDate value='${kakeibo.kakeibo_date}' pattern='yyyy-MM-dd' />" />
<br />
<br />

<label for="syokuhi">食費</label><br />
<input type="text" name="syokuhi" value="${syokuhi}" />
<br /><br />

<label for="">日用品</label><br />
<input type="text" name="nitiyouhin" value="${nitiyouhin}" />
<br /><br />

<label for="">交際費</label><br />
<input type="text" name="kousai" value="${kousai}" />
<br /><br />

<label for="">美容</label><br />
<input type="text" name="biyou" value="${biyou}" />
<br /><br />

<label for="">交通費</label><br />
<input type="text" name="koutuu" value="${koutuu}" />
<br /><br />

<label for="">医療</label><br />
<input type="text" name="iryou" value="${iryou}" />
<br /><br />

<label for="">通信費</label><br />
<input type="text" name="tuusin" value="${tuusin}" />
<br /><br />

<label for="">水道</label><br />
<input type="text" name="suidou" value="${suidou}" />
<br /><br />

<label for="">ガス</label><br />
<input type="text" name="gasu" value="${gasu}" />
<br /><br />

<label for="">電気</label><br />
<input type="text" name="denki" value="${denki}" />
<br /><br />

<label for="">家賃</label><br />
<input type="text" name="yatin" value="${yatin}" />
<br /><br />

<label for="">税金</label><br />
<input type="text" name="zeikin" value="${zeikin}" />
<br /><br />

<label for="">保険</label><br />
<input type="text" name="hoken" value="${hoken}" />
<br /><br />

<label for="">その他</label><br />
<input type="text" name="sonota" value="${sonota}" />
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>



