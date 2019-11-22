<%!
public void jspInit()
{
System.out.println("This is init phase");
}
public void jspDestroy() {
	System.out.println("This is Destroy phase");
}
%>
<!DOCTYPE html>
<%@page import="java.util.Date"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!
protected void m1()
{
System.out.println("This is m1()");
}
%>
<%
	Date date = new Date();
   // m();
%>

<body>
	<h1 style="color: green;">
		Date and Time is
		<%=date%></h1>
		<%-- <h3><%=i%></h3> --%>
</body>
</html>
<%!
protected void m2()
{
System.out.println("This is m2()");
}
%>