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



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Map<String, String> users = new HashMap<String, String>();
		users.put("user1", "pswd1");
		users.put("user@gmail.com", "pswd2");
		users.put("usuario@gmail.com", "pswd3");
		
		if(users.containsKey(request.getParameter("email"))) {
			System.out.print("sad");
			System.out.print(request.getParameter("email"));
			System.out.print(users.get(request.getParameter("email")));
			System.out.print(request.getParameter("password"));
			if(users.get(request.getParameter("email")).equals(request.getParameter("password"))) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			
			
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			}
			
		
		
		
		
		
		
		//Si quieres guarda informacion para un usuario durante su vida en la app
		//Una sesion unica por usuario
		//request.getSession().setAttribute("nombre", nombre);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
