package controlador;

import java.io.BufferedReader;
import java.io.IOException;

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
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	   
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    
		daoUser = new DaoUserMySQL();
		
		boolean validado;
		System.out.println(request.getParameter("nombre")+request.getParameter("password"));
		User aux = new User(-1,request.getParameter("nombre"),request.getParameter("password"));
	
		validado=daoUser.validar(aux);
		System.out.println(validado);
		JSONObject json =new JSONObject();
		
		json.put("validado", validado);
		response.getWriter().write(json.toString());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		
		String str = readPostBody(request);
		
		//Las tres lineas siguientes evitn un error de JSONObject
		int i = str.indexOf("{");
		str = str.substring(i);
		JSONObject json = new JSONObject(str.trim()); 
	
		daoUser = new DaoUserMySQL();
		
		boolean validado;
		System.out.println(json.getString("usuario")+json.getString("contrasenia"));
		User aux = new User(-1,json.getString("usuario"),json.getString("contrasenia"));
	
		validado=daoUser.validar(aux);
		
		json =new JSONObject();
		
		json.put("validado", validado);
		response.getWriter().write(json.toString());
	}
	
	
	private static String readPostBody(HttpServletRequest request) {
		  try {
		    StringBuilder sb = new StringBuilder();
		    BufferedReader reader = request.getReader();
		    int c;
		    while ((c = reader.read()) != -1) {
		      sb.append((char) c);
		    }
	
		    return sb.toString();
		  } catch (IOException e) {
		    throw new RuntimeException(e);
		  }
		}
	
	

}
