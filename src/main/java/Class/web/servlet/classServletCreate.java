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

import Class.domain.Class;
import Class.service.ClassException;
import Class.service.ClassService;
import student.domain.Student;


/**
 * Servlet implementation class UserServlet
 */

public class classServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classServletCreate() {
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
		ClassService entity1service = new ClassService();
		Class form = new Class();
		
		form.setClassID(Integer.parseInt(request.getParameter("ClassID")));
		form.setInstructorID(Integer.parseInt(request.getParameter("InstructorID")));
		form.setClassName(request.getParameter("ClassName"));
		form.setSemester(request.getParameter("Semester"));
		
		try {
			entity1service.create(form);
			response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | ClassException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
