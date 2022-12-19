<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="<c:url value ="/admin"/>">Admin</a> <a
					class="breadcrumb-item text-dark" href="<c:url value ="/admin/user"/>">User</a> <span
					class="breadcrumb-item active">Profile user</span>
			</nav>
		</div>
	</div>

	<!-- Breadcrumb End -->


	<!-- Checkout Start -->
	<form method="post">
		<div class="container-fluid">
			<div class="row px-xl-5">
				<div class="col-lg-8">
					<h5 class="section-title position-relative text-uppercase mb-3">
						<span class="bg-secondary pr-3">Profile User</span>
					</h5>
					<div class="bg-light p-30 mb-5">
						<div class="row">
							<div class="col-md-6 form-group">
								<label>Avatar</label> <input name="avatar" class="form-control"
									type="text" placeholder="Avatar">
							</div>
							<div class="col-md-6 form-group">
								<label>First Name</label> <input name="firstname"
									value="${user.firstname}" class="form-control"
									type="text" placeholder="John">
							</div>
							<div class="col-md-6 form-group">
								<label>Last Name</label> <input name="lastname"
									value="${user.lastname}" class="form-control"
									type="text" placeholder="Doe">
							</div>
							<div class="col-md-6 form-group">
								<label>E-mail</label> <input name="email"
									value="${user.email}" class="form-control"
									type="text" placeholder="example@email.com">
							</div>
							<div class="col-md-6 form-group">
								<label>Mobile No</label> <input name="phone"
									value="${user.phone}" class="form-control"
									type="text" placeholder="+123 456 789">
							</div>
							<div class="col-md-6 form-group">
								<label>Id Card</label> <input name="id_card"
									value="${user.id_card}" class="form-control"
									type="text" placeholder="123 Street">
							</div>
							<div class="col-md-6 form-group">
								<label>Role</label> <input name="role"
									value="${user.role}" class="form-control">
							</div>
							<div class="col-md-12 form-group">
								<div class="custom-control custom-checkbox">
									<button type="submit"
										formaction="<c:url value ="/admin/user/edit?id=${user.id }"/>">Update profile</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>