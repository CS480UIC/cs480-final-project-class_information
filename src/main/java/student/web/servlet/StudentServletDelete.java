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

public class StudentServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletDelete() {
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
		StudentDao entity1Dao = new StudentDao();
		Student entity1 = null;
		if(method.equals("search"))
		{
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
						request.getRequestDispatcher("/jsps/CRUDstudent/studentdelete.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Student not found");
				request.getRequestDispatcher("/jsps/CRUDstudent/studentread.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				entity1Dao.delete(Integer.parseInt(request.getParameter("UID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Student Deleted");
			request.getRequestDispatcher("/jsps/CRUDstudent/studentread.jsp").forward(request, response);
		}
	}
}



