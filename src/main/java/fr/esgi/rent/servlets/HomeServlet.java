package fr.esgi.rent.servlets;

import fr.esgi.rent.beans.RentalProperty;
import fr.esgi.rent.service.RentalPropertiesFileParser;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Home", value = "/")
public class HomeServlet extends HttpServlet {

    private final RentalPropertiesFileParser rentalPropertiesFileParser;

    @Inject
    public HomeServlet(RentalPropertiesFileParser rentalPropertiesFileParser) {
        this.rentalPropertiesFileParser = rentalPropertiesFileParser;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentalProperty> rentalProperties = rentalPropertiesFileParser.parse("rentalProperties.csv");
        request.setAttribute("rentalProperties", rentalProperties);

        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

}
