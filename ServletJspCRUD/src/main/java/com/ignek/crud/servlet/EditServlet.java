package com.ignek.crud.servlet;

import com.ignek.crud.constants.CrudConstants;
import com.ignek.crud.user.dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SelectServlet.id = Integer.parseInt(request.getParameter(CrudConstants.ID));
		String name = request.getParameter(CrudConstants.NAME);
		String email = request.getParameter(CrudConstants.EMAIL);
		String phoneno = request.getParameter(CrudConstants.PHONENO);
		InsertServlet.checkboxvalue = request.getParameterValues(CrudConstants.HOBBIES);
		String gender = request.getParameter(CrudConstants.GENDER);

		InsertServlet.details.setId(SelectServlet.id);
		InsertServlet.details.setName(name);
		InsertServlet.details.setEmail(email);
		InsertServlet.details.setPhoneno(phoneno);
		InsertServlet.details.setHobby(InsertServlet.checkboxvalue);
		InsertServlet.details.setGender(gender);

		try {
			EditData.updateData(InsertServlet.details);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}

}
