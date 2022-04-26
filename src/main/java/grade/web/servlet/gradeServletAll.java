package grade.web.servlet;

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
import Class.service.ClassService;
import grade.dao.gradeDao;
import grade.domain.grade;
import grade.service.gradeException;
import grade.service.gradeService;

/**
 * Servlet implementation class UserServlet
 */

public class gradeServletAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gradeServletAll() {
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
		
		gradeDao gradedao = new gradeDao();
		grade form = new grade();
		
		if(method.equals("create")) {
			gradeService entityservice = new gradeService(); 
			
			
			form.setStudentUID(Integer.parseInt(request.getParameter("StudentUID")));
			form.setAssignmentID(Integer.parseInt(request.getParameter("AssignmentID")));
			form.setTotalPoints(Integer.parseInt(request.getParameter("TotalPoints")));
			form.setPointsEarned(Integer.parseInt(request.getParameter("PointsEarned")));
			
			try {
				entityservice.create(form);
				response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");
				
			} catch (ClassNotFoundException | gradeException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
		}
		else if(method.equals("search")) {
			try {
				form = gradedao.findAssignment(
						Integer.parseInt(request.getParameter("StudentUID")), 
						Integer.parseInt(request.getParameter("AssignmentID")
				));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			if(form != null){
				request.getSession().setAttribute("entity1", form);
				request.getRequestDispatcher("/jsps/grade/grade_read_output.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "Class not found");
				request.getRequestDispatcher("/jsps/grade/garade_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update")) {

			try {
				
				gradedao.update(
						Integer.parseInt(request.getParameter("StudentUID")), 
						Integer.parseInt(request.getParameter("AssignmentID")), 
						Integer.parseInt(request.getParameter("PointsEarned")), 
						Integer.parseInt(request.getParameter("TotalPoints"))
				
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
		else if(method.equals("delete")) {
			try {
				gradedao.delete(
						Integer.parseInt(request.getParameter("StudentUID")),
						Integer.parseInt(request.getParameter("AssignmentID"))
				);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Grade Deleted");
			request.getRequestDispatcher("/jsps/grade/grade_read_output.jsp").forward(request, response);
		}
	}
}



