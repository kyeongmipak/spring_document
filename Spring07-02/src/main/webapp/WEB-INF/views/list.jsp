<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 주소록</title>
</head>
<body>

	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>전자우편</td>
			<td>관계</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td><a href="content_view?addressId=${dto.addressId}">${dto.addressId}</a></td>
			<td>${dto.addressName}</td>
			<td>${dto.addressTel}</td>
			<td>${dto.addressAddress}</td>
			<td>${dto.addressEmail}</td>
			<td>${dto.addressRelation}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6"> <a href="write_view">주소록 등록</a> </td>
		</tr>
	</table>


</body>
</html>