<%-- 
    Document   : spittle
    Created on : Jul 13, 2016, 6:49:55 PM
    Author     : Vitalii_Vitrenko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spittle ${spittle.id}</title>
    </head>
    <body>
        <table> 
            <tbody>
                <tr>
                    <td>ID</td>
                    <td>${spittle.id}</td>
                </tr>
                <tr>
                    <td>Message</td>
                    <td>${spittle.message}</td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td>${spittle.date}</td>
                </tr>
                <tr>
                    <td>Latitude</td>
                    <td>${spittle.latitude}</td>
                </tr>
                <tr>
                    <td>Longitude</td>
                    <td>${spittle.longitude}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
