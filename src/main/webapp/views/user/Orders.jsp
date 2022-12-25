<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="#">Home</a>
                    <span class="breadcrumb-item active">Orders</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Cart Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-light table-borderless table-hover text-center mb-0">
                    <thead class="thead-dark">
                        <tr>
                       		<th>Time</th>
                            <th>Store Name</th>
                            <th>Total</th>
                            <th>Quantity</th>
                            <th>Status</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody  class="align-middle">
                    	<c:forEach items="${ordersList}" var="orders">
	                        <tr >
	                        	<td class="align-middle">${orders.createAt}</td>
	                            <td class="align-middle">${orders.store.name}</td>
	                            <td class="align-middle">${orders.amountFromUser}</td>
	                            <td class="align-middle">${orders.ordersItem.size()}</td>
	                            <td class="align-middle">${orders.status}</td>
	                        </tr>
                        </c:forEach>
                        </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Cart End -->