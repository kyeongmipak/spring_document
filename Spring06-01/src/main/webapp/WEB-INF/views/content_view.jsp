<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="update?bId=${content.bId}" method="post">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="50" value ="${content.bName}"> </td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50" value ="${content.bTitle}"> </td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bContent" rows ="10">${content.bContent}</textarea> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;<a href="delete?bId=${content.bId}">삭제</a>&nbsp;&nbsp;<a href="list">목록보기</a> </td>
			</tr>
		</form>
	</table>
</body>
</html>