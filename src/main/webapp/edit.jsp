
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
		<h1 class="text-center my-5">Welcome to Employee Management</h1>

		<c:set var="errMsg" value="<%=request.getAttribute(\"errMsg\")%>" />

		<c:if test="${not empty errMsg}">

			<div class="alert alert-danger text-center w-50 mx-auto" role="alert">
				${errMsg }</div>

		</c:if>
		<c:remove var="errMsg" />
		
		<c:set var="employee" value="<%=request.getAttribute(\"employee\")%>"/>
		<div class="w-75 mx-auto">
			<form action="<%=request.getContextPath()%>/employee/update" method="post">
				<input type="hidden" name="empId" value="${employee.empId }">
				<div class="mb-3">
					<label for="name" class="form-label">Name</label> <input
						type="text" class="form-control" id="name" name="name" value="${employee.name}">
				</div>

				<div class="mb-3">
					<label for="gender" class="form-label">Gender</label><br>
					<div>
						<input type="radio" id="male" name="gender" value="Male" <c:if test="${employee.gender == 'Male'}">checked</c:if> >
						<label for="male">Male</label>
					</div>
					<div>
						<input type="radio" id="female" name="gender" value="Female"
							<c:if test="${employee.gender == 'Female'}">checked</c:if>
							> <label for="female">Female</label>
					</div>
					<div>
						<input type="radio" id="other" name="gender" value="Other"
							<c:if test="${employee.gender == 'Other'}">checked</c:if>
							> <label for="other">Other</label>
					</div>
				</div>

				<div class="mb-3">
					<label for="salary" class="form-label">Salary</label> <input
						type="number" class="form-control" id="salary" name="salary"
						value="${employee.salary}">
				</div>

				<div class="mb-3">
					<label for="joiningDate" class="form-label">Date of Joining</label>
					<input type="date" class="form-control" id="joiningDate"
						name="joiningDate" value="${employee.joiningDate}" >
				</div>

				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Email
						Address</label> <input type="email" class="form-control"
						id="exampleInputEmail1" name="email" value="${employee.email}">
					<div id="emailHelp" class="form-text">We'll never share your
						email with anyone else.</div>
				</div>


				<button type="submit" class="btn btn-primary">Update</button>
			</form>
		</div>
	</div>
</body>
</html>
