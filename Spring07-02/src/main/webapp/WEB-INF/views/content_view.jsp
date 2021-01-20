<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
			<input type="hidden" name="addressId" value="${content_view.addressId}">
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="addressName" size = "50" value ="${content_view.addressName}"> </td>
			</tr>
			<tr>
				<td> 전화번호 </td>
				<td> <input type="text" name="addressTel" size = "50" value ="${content_view.addressTel}"> </td>
			</tr>
			<tr>
				<td> 주소 </td>
				<td> <input type="text" name="addressAddress" size = "50" value ="${content_view.addressAddress}"> </td>
			</tr>
			<tr>
				<td> 전자우편 </td>
				<td> <input type="text" name="addressEmail" size = "50" value ="${content_view.addressEmail}"> </td>
			</tr>
			<tr>
				<td> 관계 </td>
				<td> <input type="text" name="addressRelation" size = "50" value ="${content_view.addressRelation}"> </td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; <a href="delete?addressId=${content_view.addressId}">삭제</a> &nbsp;&nbsp; </td>
			</tr>
		</form>
	</table>


</body>
</html>