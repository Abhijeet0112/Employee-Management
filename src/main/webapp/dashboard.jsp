
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRK</title>

</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="container">



		<h1 class="text-center my-5">Welcome to employee management</h1>
		<c:set var="successMsg"
			value="<%=session.getAttribute(\"successMsg\")%>" />

		<c:if test="${not empty successMsg}">

			<div class="alert alert-success text-center w-50 mx-auto"
				role="alert">${successMsg}</div>

		</c:if>
		<c:remove var="successMsg"/>
		<c:set var="errMsg" value="<%=session.getAttribute(\"errMsg\")%>" />

		<c:if test="${not empty errMsg}">

			<div class="alert alert-danger text-center w-50 mx-auto" role="alert">${errMsg }</div>

		</c:if>
		<c:remove var="errMsg"/>
		<table class="table table-hover">
			<thead>
				<tr class="table-dark">
					<th scope="col">Emp id</th>
					<th scope="col">Name</th>
					<th scope="col">Gender</th>
					<th scope="col">Salary</th>
					<th scope="col">Joining Date</th>
					<th scope="col">Email</th>
					<th scope="col">Created At</th>
					<th scope="col">Last Update</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="employees"
					value="<%=request.getAttribute(\"employees\")%>" />

				<c:forEach var="tempEmployee" items="${employees}">

					<tr>
						<th scope="row">${tempEmployee.empId}</th>

						<td>${tempEmployee.name}</td>
						<td>${tempEmployee.gender}</td>
						<td>${tempEmployee.salary}</td>
						<td>${tempEmployee.joiningDate}</td>
						<td>${tempEmployee.email}</td>
						<td>${tempEmployee.createdAt}</td>
						<td>${tempEmployee.lastUpdate}</td>
						<td>
						<c:url var="deleteLink" value="employee/delete">
						<c:param name="empId" value="${tempEmployee.empId}"/>
						</c:url>
						<a class="btn btn-sm btn-danger" href="${deleteLink}"><i class="fa-solid fa-trash"></i> Delete</a>
						<c:url var="updateLink" value="employee/update">
						<c:param name="empId" value="${tempEmployee.empId}"/>
						</c:url>
						<a class="btn btn-sm btn-outline-dark" href="${updateLink}"><i class="fa-solid fa-pen-to-square"></i> Edit</a>
						
						</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>



</body>
</html>
