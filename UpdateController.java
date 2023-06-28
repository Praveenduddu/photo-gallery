package de.zeroco.album;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class UpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Part filePart;
		try {
			filePart = request.getPart("file");
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			if (Service.get("file_name", filePart.getSubmittedFileName()).isEmpty()) {
				if (Service.update(filePart, id) > 0) {
					request.getRequestDispatcher("listcontrol").forward(request, response);
				}
			} else {
				out.println("This File Already Exist");
			}
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}
}
