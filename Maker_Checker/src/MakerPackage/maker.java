package MakerPackage;

import brd.filehandling.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/NewFileUpload")
@MultipartConfig
public class maker extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// Retrieves <input type="text" name="description">
		String description = request.getParameter("description");
//		System.out.println(description);
		// Retrieves <input type="file" name="file">
		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		InputStream fileContent = filePart.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
//		System.out.println(reader.readLine());
try {
			ReadFromFile.mains(fileContent, fileName);
	} catch (Exception e) {
		
		System.out.println(e);
	}
	}
}