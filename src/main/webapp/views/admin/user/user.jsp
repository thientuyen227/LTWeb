<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="<c:url value ="/admin"/>">Admin</a><span
					class="breadcrumb-item active">User</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Cart Start -->
<div class="container-fluid">
	<div class="row px-xl-5">

		<table
			class="table table-light table-borderless table-hover text-center">
			<thead class="thead-dark">
				<tr>
					<th>Avatar</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Profile</th>
					<th>Remove</th>
				</tr>
			</thead>
			<tbody class="align-middle">
				<c:forEach items="${userList}" var="user">
					<tr>
						<td class="align-middle">${user.avatar}</td>
						<td class="align-middle">${user.firstname}</td>
						<td class="align-middle">${user.lastname}</td>
						<td class="align-middle">${user.email}</td>
						<td class="align-middle">${user.phone}</td>
						<td class="align-middle"><a class="btn btn-sm"
							href="<c:url value ="/admin/user/edit?id=${user.id }"/>" id="edit"><i
								class="fa fa-search"></i></a></td>
						<td class="align-middle"><a class="btn btn-sm"
							href="<c:url value ="/admin/user/delete?id=${user.id }"/>" id="delete"><i
								class="fa fa-times"></i></a></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>
		<form action="" method="post">
			<div class="input-group">
				<div class="input-group-append">
					<button formaction="<c:url value ="/admin/user/add"/>"
						class="btn btn-primary">Add user</button>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- Cart End -->

<script
	href="<c:url value ="/https://code.jquery.com/jquery-3.4.1.min.js"/>"></script>
<script
	href="<c:url value ="/https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"/>"></script>
<script href="<c:url value ="/assets/lib/easing/easing.min.js"/>"></script>
<script
	href="<c:url value ="/assets/lib/owlcarousel/owl.carousel.min.js"/>"></script>

<!-- Contact Javascript File -->
<script
	href="<c:url value ="/assets/mail/jqBootstrapValidation.min.js"/>"></script>
<script href="<c:url value ="/assets/mail/contact.js"/>"></script>

<!-- Template Javascript -->
<script href="<c:url value ="/assets/js/main.js"/>"></script>
