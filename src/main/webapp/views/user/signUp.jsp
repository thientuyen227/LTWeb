<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="#">Home</a> <a
					class="breadcrumb-item text-dark" href="#">Shop</a> <span
					class="breadcrumb-item active">Sign Up</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Checkout Start -->
<form method="post">
<div class="pagination justify-content-center">
	<div class="row px-xl-5">
		<div class="col-lg-8">
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Sign Up</span>
			</h5>
			<div class="bg-light p-30 mb-5">
				<div class="row">
					<div class="col-md-6 form-group">
						<label>Avatar</label> <input class="form-control" type="text"
							placeholder="Avatar">
					</div>
					<div class="col-md-6 form-group">
						<label>First Name</label> <input name="firstname" class="form-control" type="text"
							placeholder="John">
					</div>
					<div class="col-md-6 form-group">
						<label>Last Name</label> <input name="lastname" class="form-control" type="text"
							placeholder="Doe">
					</div>
					<div class="col-md-6 form-group">
						<label>E-mail</label> <input name="email" class="form-control" type="text"
							placeholder="example@email.com">
					</div>
					<div class="col-md-6 form-group">
						<label>id card</label> <input name="id_card" class="form-control" type="text"
							placeholder="251******">
					</div>

					<div class="col-md-6 form-group">
						<label>Mobile No</label> <input name="phone" class="form-control" type="text"
							placeholder="+123 456 789">
					</div>

					<div class="col-md-6 form-group">
						<label>Password</label> <input name="password" class="form-control"
							type="password">
					</div>
					<div class="col-md-6 form-group">
						<label>Enter again password</label> <input name="againpassword" class="form-control"
							type="password">
					</div>
					<div class="col-md-12 form-group">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="newaccount"> <label class="custom-control-label"
								for="newaccount">I agree to the Terms</label>
						</div>
					</div>
					<div class="col-md-12 form-group">
						<div class="custom-control custom-checkbox">
							<button type="submit"
								formaction="<c:url value ="/home/signup"/>"
								id="newaccount">Create new account</button>
						</div>
					</div>
					<div class="sign-info text-center">
						<span class="text-dark d-inline-block line-height-2">If you have an account, <a href="<c:url value ="/home/signin"/>">Sign In</a>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</form>