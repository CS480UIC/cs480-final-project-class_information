package student.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.domain.Student;

/**
 * Servlet implementation class UserServlet
 */

public class StudentServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServletUpdate() {
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
		StudentDao entity1dao = new StudentDao();
		Student entity1 = null;

		if(method.equals("search"))
		{
			try {
				entity1 = entity1dao.findByID(Integer.parseInt(request.getParameter("UID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(entity1.getUID()!=null){
				request.setAttribute("entity1", entity1);
				request.getRequestDispatcher("/jsps/CRUDstudent/studentupdate.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Student not found");
				request.getRequestDispatcher("/jsps/CRUDstudent/studentread.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Student form = new Student();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setClassID(Integer.parseInt(info.get(0)));
			form.setUID(Integer.parseInt(request.getParameter("UID")));
			form.setEnrolled(info.get(2));
			form.setDegreeType(info.get(3));	

			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Student Updated");
			request.getRequestDispatcher("/jsps/CRUDstudent/studentread.jsp").forward(request, response);
		}
	}
}



