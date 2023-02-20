<%@ page import="fr.esgi.rent.beans.RentalProperty" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Accueil</title>
</head>
<body>
<h1>Accueil</h1>
<p>
<%
    List<RentalProperty> rentalProperties = (List<RentalProperty>) request.getAttribute("rentalProperties");

    for (RentalProperty rentalProperty : rentalProperties) {
%>
<ul>
    <li><% out.println(String.format("%s à louer", rentalProperty.propertyType().getDesignation())); %></li>
    <li><% out.println(String.format("Loyer mensuel : %s €", rentalProperty.rentAmount())); %></li>
    <li><% out.println(String.format("Surface : %s m²", rentalProperty.area())); %></li>
    <li><% out.println(String.format("Nombre de chambres : %s", rentalProperty.bedroomsCount())); %></li>
</ul>
<%
    }
%>
</p>
</body>
</html>
