package assignment.web.servlet;

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
import assignment.dao.assignmentDao;
import assignment.domain.assignment;
import assignment.service.assignmentException;
import assignment.service.assignmentService;

/**
 * Servlet implementation class UserServlet
 */

public class assignmentServletAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public assignmentServletAll() {
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
		
		assignmentDao assignmentdao = new assignmentDao();
		assignment form = new assignment();
		
		if(method.equals("create")) {
			assignmentService entityservice = new assignmentService(); 
			
			
			form.setClassID(Integer.parseInt(request.getParameter("ClassID")));
			form.setAssignmentID(Integer.parseInt(request.getParameter("AssignmentID")));
			form.setTitle(request.getParameter("Title"));
			form.setDescription(request.getParameter("Description"));
			
			try {
				entityservice.create(form);
				response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");
				
			} catch (ClassNotFoundException | assignmentException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
		}
		else if(method.equals("search")) {
			try {
				form = assignmentdao.findAssignment(
						Integer.parseInt(request.getParameter("ClassID")), 
						Integer.parseInt(request.getParameter("AssignmentID")
						
								));
				System.out.println(form.getDescription());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			if(form != null){
				request.getSession().setAttribute("entity1", form);
				request.getRequestDispatcher("/jsps/CRUDassignment/assignment_read_output.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "Class not found");
				request.getRequestDispatcher("/jsps/CRUDassignment/assignment_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update")) {

			try {
				
				assignmentdao.update(
						Integer.parseInt(request.getParameter("ClassID")), 
						Integer.parseInt(request.getParameter("AssignmentID")), 
						request.getParameter("Title"), 
						request.getParameter("Description")
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
				assignmentdao.delete(
						Integer.parseInt(request.getParameter("ClassID")),
						Integer.parseInt(request.getParameter("AssignmentID"))
				);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "assignment Deleted");
			request.getRequestDispatcher("/jsps/CRUDassignment/assignment_read_output.jsp").forward(request, response);
		}
	}
}



