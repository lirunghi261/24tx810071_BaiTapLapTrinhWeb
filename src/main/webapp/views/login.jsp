<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="jakarta.tags.core"%>

<form action="login" method="post">
	<h2>Đăng nhập</h2>
	<core:if test="${alert !=null}">
		<h3 class="alert alertdanger">${alert}</h3>
	</core:if>
	<section>
		<label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span> 
				<input type="text" placeholder="Tài khoản" name="username">
			</div>
		</label>
	</section>
	<section>
		<label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span> 
				<input type="password" placeholder="Mật khẩu" name="password">
			</div>
		</label>
	</section>
	<section>
		<label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span> 
				<input type="submit" value="Login">
			</div>
		</label>
	</section>
</form>