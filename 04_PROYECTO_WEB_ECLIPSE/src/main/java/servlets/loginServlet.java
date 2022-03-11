package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Map para guardar los usuarios < correo/nombre,contraseña >
		Map<String, String> users = new HashMap<String, String>();

		// Introduzco tres usuarios para hacer las pruebas
		users.put("user1", "pswd1");
		users.put("user@gmail.com", "pswd2");
		users.put("usuario@gmail.com", "pswd3");

		// Si el nombre de usuario coincide con alguno de los que forman el Map entra
		if (users.containsKey(request.getParameter("email"))) {

			// Si la contraseña para ese nombre de usuario coincide con alguna contraseña de
			// las que forman el Map entra
			// y se muestra la pantalla de inicio
			if (users.get(request.getParameter("email")).equals(request.getParameter("password"))) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			// Si no muestra la pantalla de error
			else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}

		}
		// Si no muestra la pantalla de error
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
