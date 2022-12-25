<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="#">Home</a> <span
					class="breadcrumb-item active">Store</span>
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
						<th>Avatar</th>
						<th>Name</th>
						<th>Rating</th>
						<th>Owner Id</th>
						<th>Detail</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody class="align-middle">
					<c:if test="${not empty sessionScope.User}">
						<c:forEach items="${userFollowStoreList}" var="userFollowStore">
							<tr>
								<td class="align-middle">${userFollowStore.store.avatar}</td>
								<td class="align-middle">${userFollowStore.store.name}</td>
								<td class="align-middle">${userFollowStore.store.rating}</td>
								<td class="align-middle">${userFollowStore.store.ownerID}</td>
								<td class="align-middle"><a class="btn btn-sm"
									href="<c:url value ="/home/storedetail?id=${userFollowStore.store.id}"/>"><i
										class="fa fa-search"></i></a></td>
								<td class="align-middle"><a class="btn btn-sm" id="delete"
									href="<c:url value ="/home/followingstore/delete?id=${userFollowStore.id }"/>"><i
										class="fa fa-times"></i></a></td>
							</tr>
						</c:forEach>
					</c:if>

				</tbody>

			</table>

		</div>
		<c:if test="${empty sessionScope.User}">
			<div class="sign-info text-center">
				<span class="text-dark d-inline-block line-height-2">You did
					not <a href="<c:url value ="/home/signin"/>">Sign In</a> ?
				</span>
			</div>
		</c:if>
	</div>
</div>
<!-- Cart End -->

