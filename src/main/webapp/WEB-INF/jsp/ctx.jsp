<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (null==application.getAttribute("ctx")){
        String ctx = request.getContextPath();
        application.setAttribute("ctx",ctx);
    }
%>

