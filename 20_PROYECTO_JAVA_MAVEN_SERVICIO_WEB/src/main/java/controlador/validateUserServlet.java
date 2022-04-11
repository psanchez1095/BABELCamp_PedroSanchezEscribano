package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.entidad.User;
import modelo.persistencia.DaoUserMySQL;
import modelo.persistencia.interfaces.DaoUser;

//Ej: /usuarios/login?nombre=tony&password=1234
/**
 * Servlet implementation class validateUserServlet
 */
@WebServlet("/usuarios/login")
public class validateUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUser daoUser = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		daoUser = new DaoUserMySQL();
		
		boolean validado;
		
		User aux = new User(-1,request.getParameter("nombre"),request.getParameter("password"));
	
		validado=daoUser.validar(aux);
		
		JSONObject json =new JSONObject();
		
		json.put("validado", validado);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		daoUser = new DaoUserMySQL();
		
		boolean validado;
		
		User aux = new User(-1,request.getParameter("nombre").toString(),request.getParameter("password").toString());
		
		validado=daoUser.validar(aux);
		
		JSONObject json =new JSONObject();
		
		json.put("validado", validado);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json.toString());
	}

}
