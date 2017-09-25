<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quote Screen</title>
</head>
<body>
<form action="../ExstreamGateway" method="post">
<%@page import="com.exstream.xmlobject.Customer"%>
<% String FirstName=request.getParameter("input-firstName");
String MiddleName=request.getParameter("input-middleName");
String LastName=request.getParameter("input-lastName");
String addressline1=request.getParameter("input-addressLine1");
String addressline2=request.getParameter("input-addressLine2");
String city=request.getParameter("input-city");
String state=request.getParameter("input-state");
String country="INDIA";
String Pin="560066";
String mobile =request.getParameter("input-mobile");
String residence=request.getParameter("input-residence");
String office=request.getParameter("input-office");

 Customer Qtn= new Customer(FirstName,MiddleName,LastName);
 String FullName= Qtn.getCustomerFirstName();
 Qtn.setraddressLine1(addressline1);
 Qtn.setraddressLine2(addressline2);
 Qtn.setCity(city);
 Qtn.setMobile(mobile);
 Qtn.setOffice(office);
 Qtn.setResidence(residence);
 getServletContext().setAttribute("Quote12",Qtn);
%>

	<img src="../images/ins.png" width=400 />
	
	<h3>Welcome Mr <%=FullName %> Please find your insurance details and documents.</h3> 
	<br/>	
	<table width=100% border=1>
		<tr>
			<td><strong>First Name:</strong><%=FirstName %></td>
			<td><strong>Middle Name:</strong><%=MiddleName %></td>
			<td><strong>Last Name:</strong><%=LastName %></td>
		</tr>
		<tr>
			<td><strong>Address Line 1:</strong><%=addressline1 %></td>
			<td><strong>Address Line 2:</strong><%=addressline2 %></td>
			<td><strong>City:</strong><%=city %></td>
		</tr>
		<tr>
			<td><strong>State:</strong><%=state %></td>
			<td><strong>Country:</strong><%=country %></td>
			<td><strong>PIN Code:</strong><%=Pin %></td>
		</tr>
		<tr>
			<td><strong>Mobile:</strong><%=mobile %></td>
			<td><strong>Residence:</strong><%=residence %></td>
			<td><strong>Office:</strong><%=office %></td>
		</tr>
		<tr>
			<td><strong>Principal Amount</strong>10000.00</td>
			<td><strong>Premium Per Month</strong>1000.00</td>
			<td><strong>Premium Per Year</strong>1000.00</td>
		</tr>		
	</table>
	<br/>
	<br/>
		<table align =center width=50% border=1>
		<tr>
		<td colspan = 4 ><center><strong>List of Insurance Documents</strong></center></td>
		</tr>
		<tr>
			<td>Cover Letter</td>
			<td><button type="submit" name="action" value="Cover_View" class="submit-button">View</button></td>	
			<td><button type="submit" name="action" value="Cover_Edit" class="submit-button">Edit</button></td>		
			<td><button type="submit" name="action" value="Cover_Sign" class="submit-button">Sign</button></td>
		</tr>	
		<tr>
			<td>Welcome Letter</td>
			<td><button type="submit" name="action" value="Welcome_View" class="submit-button">View</button></td>	
			<td><button type="submit" name="action" value="Welcome_Edit" class="submit-button">Edit</button></td>		
			<td><button type="submit" name="action" value="Welcome_Sign" class="submit-button">Sign</button></td>
		</tr>	
		<tr>
			<td>Policy Document</td>
			<td><button type="submit" name="action" value="Policy_View" class="submit-button">View</button></td>	
			<td><button type="submit" name="action" value="Policy_Edit" class="submit-button">Edit</button></td>		
			<td><button type="submit" name="action" value="Policy_Sign" class="submit-button">Sign</button></td>			
		</tr>	
		<tr>
			<td>Cancellation Letter</td>
			<td><button type="submit" name="action" value="Cancel_View" class="submit-button">View</button></td>	
			<td><button type="submit" name="action" value="Cancel_Edit" class="submit-button">Edit</button></td>		
			<td><button type="submit" name="action" value="Cancel_Sign" class="submit-button">Sign</button></td>			
		</tr>		
	</table>
	
	<br/>
	<br/>
	
	<center>
	<input class="submit-button" type="submit" alt="Next" name="Submit"	value="Exit" />
	</center>
	</form>



</body>
</html>