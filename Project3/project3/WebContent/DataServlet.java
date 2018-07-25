// Nick Scoles
// Java O-O Project 3
package p3;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project2.*;


/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseLabelValue;
		String responseLabel;
		RequestDispatcher rd;
		// submit1 is not null when the user presses the "Login" button on the index.html page
		if(request.getParameter("submit1")!=null)
		{	
			String name = request.getParameter("username"); //submitted user name
			String psw = request.getParameter("uspass");	//submitted password
			String cname = "Nick";	// Correct user name
			String cpsw = "psw";	// Correct password
			if(name.equals(cname) && psw.equals(cpsw)) {
					Data dat = new Data();
					responseLabel="servletResponse";
					// Writing code to responseLabelValue to pass to secondPage.jsp to pass information about Data
					// 	from the server to secondPage.jsp in the form of a drop down list
					responseLabelValue = "<select name=\"dropDown1\" id =\"dropDown1\">\r\n";
					for(int i = 0; i < dat.getStockCount(); i++){
						responseLabelValue += "<option value="+i+">"+dat.getStockName(i)+"</option>\r\n";
					}
					responseLabelValue += "</select><br>";
					
					responseLabelValue += "<select name=\"dropDown2\">\r\n";
					for(int k = 0; k < dat.getWeekCount(); k++){
						responseLabelValue += "<option value="+k+">"+dat.getWeekDate(k)+"</option>\r\n";
					}
					responseLabelValue += "</select><br>";
					request.setAttribute(responseLabel,responseLabelValue);
					
					rd=request.getRequestDispatcher("/secondPage.jsp");
					rd.forward(request,response); 
			}
			// If the user name and password combination is incorrect, redisplay index.html
			else {
				rd = request.getRequestDispatcher("/index.html");
				rd.forward(request, response);
			}
		}
		// submit2 is not null when the user clicks the "Submit" button on the secondPage.jsp page
		else if(request.getParameter("submit2")!=null) {
			Data dat = new Data();
			responseLabel="servletResponse";
			
			// Using parameters from secondPage.jsp to assign an index for the week and company
			//	to look at from Data
			Integer compIndex = Integer.parseInt(request.getParameter("dropDown1"));
			Integer dateIndex = Integer.parseInt(request.getParameter("dropDown2"));
			Week current= dat.getStocksWeek(compIndex, dateIndex);
			
			// Writing information from DataADT to responseLabelValue to pass to thirdPage.jsp
			responseLabelValue = "Company selected was: " + dat.getStockName(compIndex);
			responseLabelValue +="<br> At opening date: "+dat.getWeekDate(dateIndex)+"<br>";
			responseLabelValue += "<br><b>This weeks info: </b>"+ current.toString();
			
			request.setAttribute(responseLabel,responseLabelValue);
			rd=request.getRequestDispatcher("/thirdPage.jsp");
			rd.forward(request,response);
		}
		// submit3 is not null when the user clicks the "Return to Selection" button on the thirdPage.jsp page
		//	this asks the server to supply the same code to secondPage.jsp and call it again.
		else if(request.getParameter("submit3")!=null) {
			Data dat = new Data();
			responseLabel="servletResponse";
			// Writing code to responseLabelValue to pass to secondPage.jsp to pass information about Data
			// 	from the server to secondPage.jsp in the form of a drop down list
			responseLabelValue = "<select name=\"dropDown1\" id =\"dropDown1\">\r\n";
			for(int i = 0; i < dat.getStockCount(); i++){
				responseLabelValue += "<option value="+i+">"+dat.getStockName(i)+"</option>\r\n";
			}
			responseLabelValue += "</select><br>";
			
			responseLabelValue += "<select name=\"dropDown2\">\r\n";
			for(int k = 0; k < dat.getWeekCount(); k++){
				responseLabelValue += "<option value="+k+">"+dat.getWeekDate(k)+"</option>\r\n";
			}
			responseLabelValue += "</select><br>";
			request.setAttribute(responseLabel,responseLabelValue);
			
			rd=request.getRequestDispatcher("/secondPage.jsp");
			rd.forward(request,response); 			
		}
		// If nothing has been submitted, then start with the login page
		else {
			rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
