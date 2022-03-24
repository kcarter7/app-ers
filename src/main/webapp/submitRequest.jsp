<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="reimbursement.css">
<title>Reimbursement</title>
</head>
<script type="text/javascript">
	
</script>
<body>
	<div class="reimbursement-container">
		<h1 class="title">Expense Reimbursement System</h1>
		<form>
			<div class="form-group row">
				<div>
					<label for="inputFirstName" class="col-sm-2 col-form-label">Employee
						ID</label>
				</div>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="employeeId"
						placeholder="How much?">
				</div>
			</div>
			<div class="form-group row">
				<div>
					<label for="inputLastName" class="col-sm-2 col-form-label">Amount:</label>
				</div>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="amount"
						placeholder="Enter an amount..">
				</div>
			</div>
			<div class="form-group col-md-4">
				<div>
					<label for="inputState">Reimbursement Type:</label>
				</div>
				<select id="type" class="form-control">
					<option selected>Choose...</option>
					<option>Food</option>
					<option>Lodging</option>
					<option>Travel</option>
					<option>Other</option>
				</select>
			</div>
			<div>
				<div class="col-sm-10">
					<button type="button" class="btn btn-primary"
						onclick="submitReimbursement()">Submit</button>
				</div>
			</div>
		</form>
	</div>
	<%

	%>
</body>
</html>