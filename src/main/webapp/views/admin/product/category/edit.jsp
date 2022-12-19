<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@include file="/common/taglib.jsp" %>

<div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="<c:url value ="/admin"/>">Admin</a>
                    <a class="breadcrumb-item text-dark" href="<c:url value ="/admin"/>">Product</a>
                    <a class="breadcrumb-item text-dark" href="<c:url value ="/admin/category"/>">Category</a>
                    <span class="breadcrumb-item active">Edit</span>
                </nav>
            </div>
        </div>
    </div>	
<div class="pagination justify-content-center">

	<form action="" method="post">
		<div class="input-group">
		</div>
		
		<div class="input-group">
			<input name="categoryName" type="text" class="form-control" placeholder="Category name">
			<div class="input-group-append">
				<button formaction="<c:url value ="/admin/category/edit?id=${category.id }"/>" class="btn btn-primary">Edit</button>
			</div>
		</div>
	</form>
	</div>