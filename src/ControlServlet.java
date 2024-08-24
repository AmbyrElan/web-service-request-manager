import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private String currentUser;
	    private String selectUser;
	    //private String selectedUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	currentUser= "";
	    	selectUser="";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       this.doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
		    try {
	        	switch(action) {  
		        	case "/login":
		        		login(request,response);
		        		break;
		        	case "/register":
		        		register(request, response);
		        		break;
		        	case "/initialize":
		        		userDAO.init();
		        		System.out.println("Database successfully initialized!");
		        		rootPage(request,response,"");
		        		break;
		        	case "/root":
		        		rootPage(request,response, "");
		        		break;
		        	case "/logout":
		        		logout(request,response);
		        		break;
		        	case "/list": 
		        		System.out.println("The action is: list");
		        		listUser(request, response);           	
		        		break;
		        	case "/new":
		        		showEditForm(request, response);
		        		break;
		        	case "/delete":
		        		System.out.println("The action is: delete a user");
		        		delete(request, response);
		        		break;
		        	case "/edit":
		        		try {
		        			showEditForm(request,response);
		        		} catch (SQLException e) {
		        			e.printStackTrace();
		        		}
		        		break;
		        	case "/update":
		        		System.out.println("The action is: update a user");
		        		try {
		        			updateUser(request, response);
		        		} catch (SQLException e) {
		        			e.printStackTrace();
		        		}
				 	 	break;
		        	case "/updateClientBal":
		        		System.out.println("Update Clients cash balance in account.");
		        		addToMyBalance(request, response);
		        		break;
		        	case "/insert":
		        		System.out.println("The action is: insert a user");
				 	 	insert(request, response);	  
				 	 	break;
				 	 
		        	case "/my-profile":
		        		System.out.println("This action is: going into my settings");
		        		checkMyProfile(request, response);
		        		break;
		        		
		        	case "/add-to-balance":
		        		System.out.println("This action is: going into my add balance page");
		        		addingMoneyForm(request, response);
		        		System.out.println("This action had sent a balance amount off");
		        		break;
		    	}
		    }
		    catch(Exception ex) {
	        	System.out.println(ex.getMessage());
	    	}
	    }
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("rootView.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    private void clientPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	request.setAttribute("user", userDAO.getUser(session.getId()));
	    	request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	    }
	    
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (email.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 rootPage(request, response, "root");
	    	 }
	    	 else if(userDAO.isValid(email, password)) 
	    	 {
	    		 session = request.getSession();
	    		 user loginUser = userDAO.getUser(email);
			 	 session.setAttribute("user", loginUser);
	    		 
				 System.out.println("Login Successful! Redirecting");
				 clientPage(request, response);
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String email = request.getParameter("email");
	   	 	String firstName = request.getParameter("firstName");
	   	 	String lastName = request.getParameter("lastName");
	   	 	String password = request.getParameter("password");
	   	 	String birthday = request.getParameter("birthday");
			String address_street_num = request.getParameter("street number"); 
	   	 	String address_street = request.getParameter("street name"); 
	   	 	String address_city = request.getParameter("city"); 
	   	 	String address_state = request.getParameter("state"); 	
	   	 	String address_zip_code = request.getParameter("zip code"); 
	   	 	String confirm = request.getParameter("confirmation");
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkEmail(email)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(email,firstName, lastName, password, birthday, address_street_num,  address_street,  address_city,  address_state,  address_zip_code, 1000,0);
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        	response.sendRedirect("login.jsp");
        	}

	    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

	    	String email = request.getParameter("email");
	    	System.out.println(email);
			userDAO.delete(email);
			System.out.println("User deleted successfully!");
			rootPage(request, response, "");
	    }
	    
	    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {	    	
	    	String email = request.getParameter("email");
	    	String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");
			String birthday = request.getParameter("birthday");
			String address_street_num = request.getParameter("street number"); 
	   	 	String address_street = request.getParameter("street name"); 
	   	 	String address_city = request.getParameter("city"); 
	   	 	String address_state = request.getParameter("state"); 
	   	 	String address_zip_code = request.getParameter("zip code"); 
			int cash_bal = Integer.parseInt(request.getParameter("cash_bal"));
			int PPS_bal = Integer.parseInt(request.getParameter("PPS_bal"));
			
			user updateUser = new user(email, firstName, lastName, password, 
										birthday, address_street_num,address_street,
										address_city, address_state, address_zip_code,
										cash_bal, PPS_bal);
			
			userDAO.update(updateUser);
			
			request.setAttribute("message", "User updated successfully!");
			
			RequestDispatcher view = request.getRequestDispatcher("list");
			view.forward(request,  response);;
	
		}	    
	    
	    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String email = request.getParameter("email");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");
			String birthday = request.getParameter("birthday");
			String address_street_num = request.getParameter("street number"); 
	   	 	String address_street = request.getParameter("street name"); 
	   	 	String address_city = request.getParameter("city"); 
	   	 	String address_state = request.getParameter("state"); 
	   	 	String address_zip_code = request.getParameter("zip code"); 
			int cash_bal = Integer.parseInt(request.getParameter("cash_bal"));
			int PPS_bal = Integer.parseInt(request.getParameter("PPS_bal"));

			user newUser = new user(email, firstName, lastName, password, birthday, address_street_num, address_street, address_city, address_state, address_zip_code, cash_bal, PPS_bal);
			userDAO.insert(newUser);

			request.setAttribute("message", "User inserted successfully!");
			//response.sendRedirect("rootView.jsp");
			RequestDispatcher view = request.getRequestDispatcher("list");
			view.forward(request,  response);;
	    }
	    
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String uName = request.getParameter("email");
			System.out.println(uName);
			
			user existingUser = userDAO.getUser(uName);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Update.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
		}
	    
	    /****************************************************************
	    * Start of ClientServlet Contracted Methods - 
	    * 
	    * Here we will add logic for actions Clients can take
	     * @throws IOException 
	     * @throws ServletException 
	     * @throws SQLException 
	    *******************************************************************/
	    
	    // Clients can check their profiles
	    
	    private void checkMyProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	//Logic for Clients to view everything in their profile
	    	//Should be directed to User.jsp with session of user still running
	    	
	    	String uName = request.getParameter("email");
			System.out.println(uName);
			
			user existingUser = userDAO.getUser(uName);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("User.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);

	    	
	    }
	    
	    // Setting a method to redirect to form that will add to your balance
	    private void addingMoneyForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String uName = request.getParameter("email");
			
			
			user existingUser = userDAO.getUser(uName);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("addToBalanceForm.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
	    }
	    
	    private void addToMyBalance(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	    	// Add to the users balance with the incoming amount from passed in value
	    	String uName = request.getParameter("email");
	    	System.out.println(uName);
	    	
	    	user existingUser = userDAO.getUser(uName);
	    	System.out.println(existingUser);
	    	
	    	int cash_bal = existingUser.getCash_bal();
	    	int add_amount = Integer.parseInt(request.getParameter("added_val"));
	    	
	    	int new_cash_bal = cash_bal + add_amount;
	    	existingUser.setCash_bal(new_cash_bal);
	    	
	    	userDAO.update(existingUser);
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("User.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
	    }
	    
	    private void balance_updated(HttpServletRequest request, HttpServletResponse response) {
	    	
	    }
	    
	    private void saveClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	
	    
	    };
	  
}
	        
	        
	    
	        
	        
	        
	    


