package com.ignek.crud.servlet;

import com.ignek.crud.constants.CrudConstants;
import com.ignek.crud.user.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// int id = (int)request.getAttribute("ID");
				SelectServlet.id = Integer.parseInt(request.getParameter(CrudConstants.ID));

				InsertServlet.details.setId(SelectServlet.id);
				try {
					DeleteData.deleteData(InsertServlet.details);
				} catch (Exception e) {
					e.printStackTrace();
				}
				response.sendRedirect("index.jsp");
			}
}
