<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
</head>
<body>

	<form action="register" method="post">
		<h2>Tạo tài khoản mới</h2>
		<c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>
		<section>
			<label>Tài khoản:</label> <input type="text" name="username"
				placeholder="Tài khoản" required>
		</section>
		<section>
			<label>Mật khẩu:</label> <input type="password" name="password"
				placeholder="Mật khẩu" required>
		</section>
		<section>
			<label>Email:</label> <input type="email" name="email"
				placeholder="Email" required>
		</section>
		<section>
			<label>Họ và tên:</label> <input type="text" name="fullname"
				placeholder="Họ và tên" required>
		</section>
		<section>
			<label>Điện thoại:</label> <input type="tel" name="phone"
				placeholder="Số điện thoại" required>
		</section>
		<section>
			<button type="submit">Đăng ký</button>
		</section>
	</form>

</body>
</html>
