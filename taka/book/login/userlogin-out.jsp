<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- <% out.println(getAttribute("user"));%> --%>
<%@ page import = "tool.Page"%>
<%@ page import = "java.io.IOException"%>
<%@ page import = "java.io.PrintWriter"%>
<%@ page import = "javax.servlet.ServletException"%>
<%@ page import = "javax.servlet.http.Cookie"%>
<%@ page import = "javax.servlet.http.*"%>

<%
Cookie[] cookies=request.getCookies();

if (cookies!=null) {
  for (Cookie cookie : cookies) {
    String name=cookie.getName();
    String value=cookie.getValue();
    if(name.equals("a")){
       out.println("<p>"+value+"</p>");
    }
  }
} else {
  out.println("クッキーは存在しません");
}
%>
<p>aa</p>s
<p><input type="button" onclick="location.href='http://localhost:8080/book/login/userlogin-out.jsp'" value="クッキーへ"></p>
<%@include file="../footer.html" %>
