<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="#">Vendor</a>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->
<!-- Shop Product Start -->
<c:if test="${empty sessionScope.User}">
	<div class="sign-info text-center">
		<span class="text-dark d-inline-block line-height-2">You did
			not <a href="<c:url value ="/home/signin"/>"><u>Sign In</u></a> ?
		</span>
	</div>
</c:if>

<div class="col-lg-9 col-md-8">
	<div class="row pb-3">
		<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
			<c:if test="${not empty sessionScope.User}">
				<div class="product-item bg-light mb-4">
					<div class="text-center py-4">
						<a class="h6 text-decoration-none text-truncate"
							href="<c:url value ="/vendor/store"/>">Store</a>
					</div>
				</div>


				<c:if test="${empty sessionScope.User.store}">
					<div class="product-item bg-light mb-4">
						<div class="text-center py-4">
							<a class="h6 text-decoration-none text-truncate"
								href="<c:url value ="/vendor/store/add"/>">Add store</a>
						</div>
					</div>
				</c:if>
				<div class="product-item bg-light mb-4">
					<div class="text-center py-4">
						<a class="h6 text-decoration-none text-truncate" href="">Statistical</a>
					</div>
				</div>
			</c:if>
			<div class="product-item bg-light mb-4">
				<div class="text-center py-4">
					<a class="h6 text-decoration-none text-truncate"
						href="<c:url value ="/vendor/instruction"/>">Instructions for
						booth registration</a>
				</div>
			</div>

		</div>

	</div>
</div>


<!-- Shop Product End -->
<!-- Shop End -->
<a href="#" class="btn btn-primary back-to-top"><i
	class="fa fa-angle-double-up"></i></a>


