package fr.esgi.rent.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ErrorServletTest {

    @Test
    void shouldDoGet() throws ServletException, IOException {
        String jspPath = "/error.jsp";

        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(httpServletRequest.getRequestDispatcher(jspPath)).thenReturn(requestDispatcher);

        ErrorServlet errorServlet = new ErrorServlet();

        errorServlet.doGet(httpServletRequest, httpServletResponse);

        verify(httpServletRequest).getRequestDispatcher(jspPath);
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);

        verifyNoMoreInteractions(httpServletRequest, httpServletResponse, requestDispatcher);
    }

}
