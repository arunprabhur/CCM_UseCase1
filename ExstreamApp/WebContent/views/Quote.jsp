<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quote Details:</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>

	<form action="Details.jsp" method="post">
	<img src= "../images/ins.png" width=400/>		
		
		<!-- ============================== Fieldset 1 ============================== -->
		<fieldset>
			<legend>Name</legend>
				<label for="input-one" class="float" ><strong>First Name:</strong></label><br />
				<input class="inp-text" name="input-firstName" id="input-firstName" value="Test Name" type="text" size="30" /><br />

				<label for="input-two" class="float"><strong>Middle Name:</strong></label><br />
				<input class="inp-text" name="input-middleName"  id="input-middleName" value="Test Name"  type="text" size="30" />
				
				<label for="input-two" class="float"><strong>Last Name:</strong></label><br />
				<input class="inp-text" name="input-lastName"  id="input-lastName" value="Test Name"  type="text" size="30" />
			
		</fieldset>
		
		<fieldset>
			<legend>Address</legend>
				<label for="input-one" class="float"><strong>Address Line 1</strong></label><br />
				<input class="inp-text" name="input-addressLine1" id="input-addressLine1" value="Test Name"  type="text" size="30" /><br />

				<label for="input-two" class="float"><strong>Address Line 2</strong></label><br />
				<input class="inp-text" name="input-addressLine2"  id="input-addressLine2" value="Test Name"  type="text" size="30" />
				
				<label for="input-two" class="float"><strong>City</strong></label><br />
				<input class="inp-text" name="input-city"  id="input-city" value="Test Name"  type="text" size="30" />
				
				<label for="input-two" class="float"><strong>State</strong></label><br />
				  <select name="input-state" align=left>
      				<option value=" " >Please select your state</option>
      				<option>Tamil Nadu</option>
      				<option>Karnataka</option>
      			 </select>			
			
		</fieldset>
		
		<fieldset>
			<legend>Contact Details</legend>
				<label for="input-one" class="float"><strong>Mobile Phone:</strong></label><br />
				<input class="inp-text" name="input-mobile" id="input-mobile" value="Test Name"  type="text" size="30" /><br />

				<label for="input-two" class="float"><strong>Residence:</strong></label><br />
				<input class="inp-text" name="input-residence" value="Test Name"  id="input-residence" type="text" size="30" />
				
				<label for="input-two" class="float"><strong>Office:</strong></label><br />
				<input class="inp-text" name="input-office" value="Test Name"  id="input-office" type="text" size="30" />			
			
		</fieldset>
	
		<input class="submit-button" type="submit" alt="Next" name="Submit" value="Next" />							
		
	</form>


</body>
</html>