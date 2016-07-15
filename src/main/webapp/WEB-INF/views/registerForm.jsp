<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Spitter</title>
    </head>
    <body>
        <sf:form method="POST" commandName="spitter">
            <sf:errors path="*" cssClass="error-message" element="div"/>
            <sf:label path="login" cssErrorClass="input-error">Login</sf:label>
            <sf:input path="login" /> <br>
            <sf:label path="email" cssErrorClass="input-error" type="email">Email</sf:label>
            <sf:input path="email" /> <br>
            <sf:label path="password" cssErrorClass="input-error" >Password</sf:label>
            <sf:password path="password" /> <br>
            <sf:label path="firstName" cssErrorClass="input-error">First Name</sf:label>
            <sf:input path="firstName" /> <br>
            <sf:label path="lastName" cssErrorClass="input-error">Last Name</sf:label>
            <sf:input path="lastName" /> <br>
            <input type="submit" value="Register">
        </sf:form>
    </body>
</html>
