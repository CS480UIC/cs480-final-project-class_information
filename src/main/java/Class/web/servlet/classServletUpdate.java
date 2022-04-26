package Class.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.dao.ClassDao;
import Class.domain.Class;


public class classServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public classServletUpdate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		ClassDao entity1dao = new ClassDao();
		Class entity1 = null;
		
		if(method.equals("search"))
		{
			try {
				entity1 = entity1dao.findByClassID(Integer.parseInt(request.getParameter("ClassID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			if(entity1 != null){
				request.getSession().setAttribute("entity1", entity1);
//				request.setAttribute("entity1", entity1);
				request.getRequestDispatcher("/jsps/CRUDclass/class_read_output.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "Class not found");
				request.getRequestDispatcher("/jsps/CRUDclass/class_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{

			try {
				
				entity1dao.update(
						Integer.parseInt(request.getParameter("ClassID")), 
						request.getParameter("ClassName"), 
						Integer.parseInt(request.getParameter("InstructorID")), 
						request.getParameter("Semester")
				);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "class Updated");
			request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
		}
	}
}



