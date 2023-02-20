package fr.esgi.rent.servlets;

import fr.esgi.rent.beans.RentalProperty;
import fr.esgi.rent.service.RentalPropertiesFileParser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static fr.esgi.rent.samples.RentalPropertySample.rentalProperties;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HomeServletTest {

    @Mock
    private RentalPropertiesFileParser rentalPropertiesFileParser;

    @InjectMocks
    private HomeServlet homeServlet;

    @Test
    void shouldDoGet() throws ServletException, IOException {
        String jspPath = "/home.jsp";
        List<RentalProperty> rentalProperties = rentalProperties();

        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(rentalPropertiesFileParser.parse("rentalProperties.csv")).thenReturn(rentalProperties);
        when(httpServletRequest.getRequestDispatcher(jspPath)).thenReturn(requestDispatcher);

        homeServlet.doGet(httpServletRequest, httpServletResponse);

        verify(httpServletRequest).setAttribute("rentalProperties", rentalProperties);
        verify(httpServletRequest).getRequestDispatcher(jspPath);
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);

        verifyNoMoreInteractions(httpServletRequest, httpServletResponse, requestDispatcher);
    }

}
