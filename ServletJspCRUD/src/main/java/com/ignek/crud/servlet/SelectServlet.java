package com.ignek.crud.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.crud.constants.CrudConstants;
import com.ignek.crud.user.bean.UserBean;
import com.ignek.crud.user.dao.SelectData;


@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static int id;
    public SelectServlet() {
        super();
    }


	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter(CrudConstants.ID));
		
		InsertServlet.details.setId(id);
		UserBean bean = new UserBean();
		try {
			SelectData.fetchData(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*
		 * List<UserBean> userBeans = new ArrayList<>(); request.setAttribute("bean",
		 * bean); request.getRequestDispatcher("EditDataAction.jsp").forward(request,
		 * response);
		 */
     	response.sendRedirect("EditDataAction.jsp");
	}

}
