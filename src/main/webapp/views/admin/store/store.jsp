<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="<c:url value ="/admin"/>">Admin</a>
                    <span class="breadcrumb-item active">Store</span>
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
                <table class="table table-light table-borderless table-hover text-center mb-0">
                    <thead class="thead-dark">
                        <tr>
                       		<th>Avatar</th>
                            <th>Name</th>
                            <th>Rating</th>
                            <th>Owner Id</th>
                            <th>Created at</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody  class="align-middle">
                    	<c:forEach items="${storeList}" var="store">
	                        <tr >
	                        	<td class="align-middle">${store.avatar}</td>
	                            <td class="align-middle">${store.name}</td>
	                            <td class="align-middle">${store.rating}</td>
	                            <td class="align-middle">${store.ownerID}</td>
	                            <td class="align-middle">${store.createAt}</td>
	                            <td class="align-middle"><a class="btn btn-sm" href="<c:url value ="/admin/storedetail?id=${store.id}"/>"><i
											class="fa fa-search"></i></a></td>
	                        </tr>
                        </c:forEach>
                        </tbody>
                </table>
            </div>
        </div>
    </div>
 </form>
    <!-- Cart End -->
    
	<script href="<c:url value ="/https://code.jquery.com/jquery-3.4.1.min.js"/>"></script>
	<script
		href="<c:url value ="/https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"/>"></script>
	<script href="<c:url value ="/assets/lib/easing/easing.min.js"/>"></script>
	<script href="<c:url value ="/assets/lib/owlcarousel/owl.carousel.min.js"/>"></script>

	<!-- Contact Javascript File -->
	<script href="<c:url value ="/assets/mail/jqBootstrapValidation.min.js"/>"></script>
	<script href="<c:url value ="/assets/mail/contact.js"/>"></script>

	<!-- Template Javascript -->
	<script href="<c:url value ="/assets/js/main.js"/>"></script>
