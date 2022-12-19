<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="<c:url value ="/admin"/>">Admin</a> <span
					class="breadcrumb-item active">Product</span> <span
					class="breadcrumb-item active">Category</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Cart Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
			<div class="col-lg-8 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">

					<thead class="thead-dark">
						<tr>
							<th>STT</th>
							<th>Name</th>
							<th>Edit</th>
							<th>Remove</th>
						</tr>
					</thead>

					<tbody class="align-middle">
						<c:forEach items="${categoryList}" var="category" varStatus="STT">
							<tr>
								<td class="align-middle">${STT.index +1}</td>
								<td class="align-middle">${category.categoryName }</td>
								<td class="align-middle"><a class="btn btn-sm"
									href="<c:url value ="/admin/category/edit?id=${category.id }"/>" id="edit"><i class="fa fa-edit"></i></a></td>
								<td class="align-middle"><a class="btn btn-sm" href="<c:url value ="/admin/category/delete?id=${category.id }"/>" id="delete"><i
										class="fa fa-times"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form action="" method="post">
					<div class="input-group">
						<input name="categoryName" type="text" class="form-control"
							placeholder="Category name">
						<div class="input-group-append">
							<button formaction="<c:url value ="/admin/category/add"/>"
								class="btn btn-primary">Add</button>
						</div>
					</div>
				</form>
			</div>
	</div>
</div>
