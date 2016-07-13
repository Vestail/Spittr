<%-- 
    Document   : spittles
    Created on : Jul 13, 2016, 3:18:30 PM
    Author     : Vitalii_Vitrenko
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spittles</title>
    </head>
    <body>
        <h1>Spittles</h1>
        <c:forEach items="${spittleList}" var="spittle"> 
            <a href="<c:url value="/spittles/${spittle.id}" />"> ${spittle.message} | ${spittle.date} </a> <br>
        </c:forEach>
        <c:forEach begin="1" end="${pageCount}" var="pageNumber">
            <c:choose>
                <c:when test="${param.currentPage != pageNumber}" > 
                    <a href="<c:url value="spittles?count=5&currentPage=${pageNumber}" />">${pageNumber}</a>
                </c:when>
                <c:otherwise>
                    ${pageNumber}
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </body>
</html>
