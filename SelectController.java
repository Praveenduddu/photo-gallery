package de.zeroco.album;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("photoAlbum", Service.get(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("/Update.jsp").forward(request, response);
	}
}
