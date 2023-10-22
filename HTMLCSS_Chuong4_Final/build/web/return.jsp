<%-- 
    Document   : return
    Created on : Oct 22, 2023, 2:31:59 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Murach's Java Servlet and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <img src="images/murach.png" alt="Murach Logo" width="100">
        <h1>Thank you for filling out our survey!</h1>
        
        <p>Here is the information you entered:</p>
        
        <label>First Name:</label>
        <span>${user.firstName}</span><br>
        <label>Last Name:</label>
        <span>${user.lastName}</span><br>
        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>Date of Birth:</label>
        <span>${user.birthday}</span><br>
        
        <h2>You hear about us by:</h2>
        <span>${radio.option}</span>
        
        <h3>Receiving announcements:</h3>
        <ul>
            <c:forEach var="check" items="${checkbox.options}">
                <span><li>${check}</li></span>
            </c:forEach>
        </ul>
        
        <h4>Contact via:</h4>
        <span>${dropdown.dropdown}</span>
        <br>
        <br>
        <form action="index.html" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return" class ="click-button">
        </form>
    </body>
</html>
