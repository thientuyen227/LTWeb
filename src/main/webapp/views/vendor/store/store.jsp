<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark"
					href="<c:url value ="/vendor"/>">Vendor</a> <span
					class="breadcrumb-item active">Store</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->

<form action="" method="post">
	<!-- Cart Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-8 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">
					<thead class="thead-dark">
						<tr>
							<th>Avatar</th>
							<th>Name</th>
							<th>Rating</th>
							<th>Owner Id</th>
							<th>Created at</th>
							<th>Edit</th>
							<th>Detail</th>
						</tr>
					</thead>
					<tbody class="align-middle">
						
							<c:forEach items="${storeList}" var="store">
								<tr>
									<td class="align-middle">${store.avatar}</td>
									<td class="align-middle">${store.name}</td>
									<td class="align-middle">${store.rating}</td>
									<td class="align-middle">${store.ownerID}</td>
									<td class="align-middle">${store.createAt}</td>
									<td class="align-middle"><a class="btn btn-sm"
										href="<c:url value ="/vendor/store/edit?id=${store.id }"/>"><i
											class="fa fa-edit"></i></a></td>
									<td class="align-middle"><a class="btn btn-sm"
										href="<c:url value ="/vendor/storedetail?id=${store.id}"/>"><i
											class="fa fa-search"></i></a></td>
								</tr>
							</c:forEach>
					</tbody>
				</table>
				<div class="sign-info text-center">
					<span class="text-dark d-inline-block line-height-2">You
						don't have store? <a href="<c:url value ="/vendor/store/add"/>">Add
							store</a>
					</span>
				</div>
			</div>
		</div>
	</div>
</form>
<!-- Cart End -->