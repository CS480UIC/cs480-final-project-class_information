package content.web.servlet;

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
import content.dao.contentDao;
import content.domain.content;
import content.service.contentException;
import content.service.contentService;

/**
 * Servlet implementation class UserServlet
 */

public class contentServletAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public contentServletAll() {
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
		
		contentDao contentdao = new contentDao();
		content form = new content();
		
		if(method.equals("create")) {
			contentService entityservice = new contentService(); 
			
			form.setFileID(Integer.parseInt(request.getParameter("FileID")));
			form.setFile((request.getParameter("File")));
			form.setDescription((request.getParameter("Description")));
			form.setLectureDate((request.getParameter("LectureDate")));
			form.setLectureID(Integer.parseInt(request.getParameter("LectureID")));
			form.setContentType((request.getParameter("ContentType")));
			form.setClassID(Integer.parseInt(request.getParameter("ClassID")));
			
			
			try {
				entityservice.create(form);
				response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");
				
			} catch (ClassNotFoundException | contentException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
		}
		else if(method.equals("search")) {
			try {
				form = contentdao.findAssignment(
						Integer.parseInt(request.getParameter("FileID")), 
						Integer.parseInt(request.getParameter("ClassID")
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
				request.getRequestDispatcher("/jsps/CRUDCourseContent/content_read_output.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "Class not found");
				request.getRequestDispatcher("/jsps/CRUDCourseContent/content_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update")) {

			try {
				
				contentdao.update(
						Integer.parseInt(request.getParameter("FileID")), 
						(request.getParameter("File")), 
						(request.getParameter("Description")), 
						(request.getParameter("LectureDate")), 
						Integer.parseInt(request.getParameter("LectureID")),
						request.getParameter("ContentType"),
						Integer.parseInt(request.getParameter("ClassID"))
		
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
				contentdao.delete(
						Integer.parseInt(request.getParameter("FileID"))
				);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "content Deleted");
			request.getRequestDispatcher("/jsps/CRUDCourseContent/content_read_output.jsp").forward(request, response);
		}
	}
}



