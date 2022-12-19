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
					class="breadcrumb-item active">Shopping Cart</span>
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
						<th>Products</th>
						<th>Store</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody class="align-middle">
					<c:forEach items="${cartList}" var="cart" >
						<c:forEach items="${cart.cartItems}" var="cartItems">
							<tr>
								<td class="align-middle">${cartItems.product.name }</td>
								<td class="align-middle">${cart.store.name }</td>
								<td class="align-middle">${cartItems.product.promotionalPrice }</td>
								<td class="align-middle">${cartItems.count }</td>
								<td class="align-middle">${cartItems.product.promotionalPrice * cartItems.count }</td>
								<td class="align-middle"><button
										class="btn btn-sm btn-danger">
										<i class="fa fa-times"></i>
									</button></td>
								<c:set var="cartTotal"
							value="${cartTotal+cartItems.product.promotionalPrice*cartItems.count}" />
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4">
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Cart Summary</span>
			</h5>

			<div class="bg-light p-30 mb-5">
				<div class="pt-2">
					<div class="d-flex justify-content-between mt-2">
						<h5>Total</h5>
						<h4>${cartTotal }</h4>
					</div>
					<button
						class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed
						To Checkout</button>
				</div>
			</div>

		</div>
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
