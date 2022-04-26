package instructor.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.service.ClassException;
import instructor.dao.instructorDao;
import instructor.domain.instructor;
import instructor.service.instructorException;
import instructor.service.instructorService;

/**
 * Servlet implementation class UserServlet
 */

public class instructorServletAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public instructorServletAll() {
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
		instructorDao instructordao = new instructorDao();
		instructor instructor = new instructor();

			
		if(method.equals("create")) {
			instructorService serv = new instructorService();
			
			instructor.setUid(Integer.parseInt(request.getParameter("UID")));
			instructor.setClassID(Integer.parseInt(request.getParameter("ClassID")));
			
			try {
				serv.create(instructor);
				response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");
				
			} catch (ClassNotFoundException | instructorException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
			
		} 
//		else if(method.equals("search")) {
//			try {
//				instructordao.findByclassID(Integer.parseInt(request.getParameter("ClassID")));
//			}
//		}
		
//		if(method.equals("search"))
//		{
//			try {
//				instructor = instructordao.findByUsername(request.getParameter("username"));
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			} catch (InstantiationException e1) {
//				e1.printStackTrace();
//			} catch (IllegalAccessException e1) {
//				e1.printStackTrace();
//			}
//
//			if(instructor.getUsername()!=null){
//				request.setAttribute("instructor", instructor);
//				request.getRequestDispatcher("/jsps/instructor/instructor_update_output.jsp").forward(request, response);
//
//			}
//			else{
//				request.setAttribute("msg", "Entity not found");
//				request.getRequestDispatcher("/jsps/instructor/instructor_read_output.jsp").forward(request, response);
//			}
//		}
//		else if(method.equals("update"))
//		{
//			Map<String,String[]> paramMap = request.getParameterMap();
//			instructor form = new instructor();
//			List<String> info = new ArrayList<String>();
//
//			for(String name : paramMap.keySet()) {
//				String[] values = paramMap.get(name);
//				info.add(values[0]);
//			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
//
//			try {
//				instructordao.update(form);
//
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			} catch (InstantiationException e1) {
//				e1.printStackTrace();
//			} catch (IllegalAccessException e1) {
//				e1.printStackTrace();
//			}
//			request.setAttribute("msg", "Entity Updated");
//			request.getRequestDispatcher("/jsps/instructor/instructor_read_output.jsp").forward(request, response);
//		}
	}
}



