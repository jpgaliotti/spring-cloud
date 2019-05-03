<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Customer Confirmation</title>
</head>
<body>
	
The Customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free Passes: ${customer.freePasses}

<br><br>

Postal Code: ${customer.postalCode}

<br><br>

Course Code: ${customer.courseCode}

</body>

</html>