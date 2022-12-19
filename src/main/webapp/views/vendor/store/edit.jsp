<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="<c:url value ="/vendor"/>">Home</a>
                    <a class="breadcrumb-item text-dark" href="<c:url value ="/vendor/store"/>">Store</a>
                    <span class="breadcrumb-item active">Edit</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Cart Start -->	
<div class="pagination justify-content-center">

	<form action="" method="post">
		<div class="input-group">
		</div>
		
		<div class="input-group">
			<input name="avatar" type="text" class="form-control" placeholder="Avart store">
			<input name="storename" type="text" class="form-control" placeholder="Store Name">
			<input name="bio" type="text" class="form-control" placeholder="Bio	">
			
			<div class="input-group-append">
				<button formaction="<c:url value ="/vendor/store/edit?id=${store.id }"/>" class="btn btn-primary">Edit</button>
			</div>
		</div>
	</form>
	</div>
    
