<%@page import="java.util.ArrayList"%>
<%@page import="bean.demoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
 
 		ArrayList<demoBean> list = null;
 		if(request.getAttribute("listSession")!=null){
 			list = (ArrayList<demoBean>) request.getAttribute("listSession");
 			
 			
 		}
 %>
<h1>List of students</h1>
</br>

<table>
	<tr>
			<th>No</th>
			<th>Nane</th>
			<th>Add</th>
	</tr>
	
	<%for(demoBean bean : list){ %>
	
			<tr>
				<td><%=bean.getNo() %></td>
				<td><%=bean.getName() %></td>
				<td><%=bean.getAdd() %></td>
			</tr>
	<%} %>
	

</table>

</body>
</html>