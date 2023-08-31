package com.ignek.crud.servlet;

import com.ignek.crud.constants.*;
import com.ignek.crud.user.bean.*;
import com.ignek.crud.user.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String[] checkboxvalue;
	public static UserBean details = new UserBean();
	
    public InsertServlet() {
        super();
    }


	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter(CrudConstants.NAME);
		String email = request.getParameter(CrudConstants.EMAIL);
		String phoneno = request.getParameter(CrudConstants.PHONENO);
		checkboxvalue = request.getParameterValues(CrudConstants.HOBBIES);
		String gender = request.getParameter(CrudConstants.GENDER);

		details.setName(name);
		details.setEmail(email);
		details.setPhoneno(phoneno);
		details.setHobby(checkboxvalue);
		details.setGender(gender);

		try {
			InsertData.insertData(details);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("index.jsp");
	}

}
