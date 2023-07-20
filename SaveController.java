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
public class SaveController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Part filePart;
		try {
			String directoryPath = getServletContext().getRealPath("/Images/");
			PrintWriter out = response.getWriter();
			filePart = request.getPart("photo");
			if (Service.get("file_name", filePart.getSubmittedFileName()) == null) {
				if (Service.getGeneratedKey(Service.storeUploadedPhotoInAlbum(filePart, directoryPath)) > 0) {
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
