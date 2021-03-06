package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;

/**
 * Servlet implementation class findAll
 */

public class init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userservice = new UserService();
//		try {
//			request.setAttribute("UserList", userservice.init());
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		try {
			userservice.init();
//			for(int i = 0; i < li.size();i++){
//				System.out.println(li.get(i).toString());
//			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("msg", "Initialized Database");
		request.getRequestDispatcher("/jsps/CRUDinstructor/instructor_read_output.jsp").forward(request, response);
	}

}
