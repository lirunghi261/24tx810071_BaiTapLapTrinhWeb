<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${cateList}" var="cate" varStatus="STT">
		<tr class="odd gradeX">
			<td>${STT.index+1 }</td>
			<c:url value="/image?fname=${cate.icon }" var="imgUrl"></c:url>
			<td><img height="150" width="200" src="${imgUrl}" /></td>
			<td>${cate.catename }</td>
			<td><a
				href="<c:url value='/admin/category/edit?id=${cate.cateid }'/>"
				class="center">Sửa</a> | <a
				href="<c:url value='/admin/category/delete?id=${cate.cateid }'/>"
				class="center">Xóa</a></td>
		</tr>
	</c:forEach>

</body>
</html>