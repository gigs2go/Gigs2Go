<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Gigs2Go - a Spring sample</title>
<link href="resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<table id="table">
		<thead>
			<tr>
				<th>Artist Name</th>
				<th>E-Mail</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Test 1</td>
				<td>test1@fred.com</td>
			</tr>
			<tr>
				<td>Test 2</td>
				<td>test2@fred.com</td>
			</tr>
			<tr>
				<td>Test 3</td>
				<td>test3@fred.com</td>
			</tr>
			<tr>
				<td>Test 4</td>
				<td>test4@fred.com</td>
			</tr>
			<tr>
				<td>Test 5</td>
				<td>test5@fred.com</td>
			</tr>
			<tr>
				<td>Test 6</td>
				<td>test6@fred.com</td>
			</tr>
			<tr>
				<td>Test 7</td>
				<td>test7@fred.com</td>
			</tr>
			<tr>
				<td>Test 8</td>
				<td>test8@fred.com</td>
			</tr>
			<tr>
				<td>Test 9</td>
				<td>test4@fred.com</td>
			</tr>
			<tr>
				<td>Test 9</td>
				<td>test4@fred.com</td>
			</tr>
			<tr>
				<td>Test 10</td>
				<td>test10@fred.com</td>
			</tr>
			<tr>
				<td>Test 11</td>
				<td>test11@fred.com</td>
			</tr>
		</tbody>
	</table>

	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.9.1.js"></script>
	<script
		src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.2/jquery-ui.js"></script>
	<script
		src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.js"></script>
	<script charset="utf-8">
		$(document).ready(function() {
			$('#table').dataTable( {
	            "sPaginationType": "full_numbers"
	        } );
		});
	</script>
</body>
</html>