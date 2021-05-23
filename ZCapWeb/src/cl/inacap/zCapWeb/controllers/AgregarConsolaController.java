package cl.inacap.zCapWeb.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarConsolaController
 */
@WebServlet("/AgregarConsolaController.do")
public class AgregarConsolaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarConsolaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/vistas/agregarConsola.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> errores= new ArrayList<>();
		
		String nombre = request.getParameter("nombre-txt").trim();
		if(nombre.isEmpty()) {
			errores.add("Debe ingresar un nombre");
		}
		String anioTxt = request.getParameter("anio-txt").trim();
		int anio=0;
		try {
			anio= Integer.parseInt(anioTxt);
		}catch(Exception ex) {
			errores.add("El año debe ser numerico");
		}
		String marca = request.getParameter("marca-select").trim();
		if(marca.isEmpty()) {
			errores.add("Debe seleccionar una marca");
		}
		if(errores.isEmpty()) {
			//Puedo ingresar la consola porque esta vacio
			request.setAttribute("mensaje", "Registrado Exitosamente");
		}else {
			//Mostrar los errores
			request.setAttribute("errores", errores);
		}
		
		doGet(request, response);
		
	}

}
