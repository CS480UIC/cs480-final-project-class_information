package student.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.domain.Student;


/**
 * Servlet implementation class UserServlet
 */

public class StudentServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletRead() {
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
		Student entity1 = null;
		StudentDao entity1Dao = new StudentDao();
		
		try {
			entity1 = entity1Dao.findByID(Integer.parseInt(request.getParameter("UID")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(entity1.getUID()!=null){
					System.out.println(entity1);
					request.setAttribute("entity1", entity1);
					request.getRequestDispatcher("/jsps/CRUDstudent/studentread.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Student not found");
			request.getRequestDispatcher("/jsps/CRUDstudent/studentread.jsp").forward(request, response);
		}
	}
}



