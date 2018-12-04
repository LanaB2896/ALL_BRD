package MakerPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Newuser")
public class Newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CustomerCode= request.getParameter("Customer Code");
		String CustomerName= request.getParameter("Customer Name");
		String CustomerAddress1= request.getParameter("Customer Address 1");
		String CustomerAddress2= request.getParameter("Customer Address 2");
		String CustomerPinCode= request.getParameter("Customer Pin Code");
		String Emailaddress= request.getParameter("E-mail address");
		String ContactNumber= request.getParameter("Contact Number");
		String PrimaryContactPerson= request.getParameter("Primary Contact Person");
		String RecordStatus= request.getParameter("Record Status");
		String Active_InactiveFlag= request.getParameter("Active/Inactive Flag");
		String CreateDate= request.getParameter("Create Date");
		String CreatedBy= request.getParameter("Created By");
		String ModifiedDate= request.getParameter("Modified Date");
		String ModifiedBy= request.getParameter("Modified by");
		String AuthorizedDate= request.getParameter("Authorized Date");
		String AuthorizedBy= request.getParameter("Authorized by");
	System.out.println(CustomerCode);
	}
}
