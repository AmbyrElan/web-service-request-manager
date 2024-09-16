import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/RequestQuoteDAO")

public class RequestQuoteDAO {
    private static final long serialVersionUID = 1L;
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public RequestQuoteDAO(){}

    /** 
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        //uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false&user=root&password=root");
            System.out.println(connect);
        }
    }

    public boolean database_login(String email, String password) throws SQLException{
        try {
            connect_func("root","pass1234");
            String sql = "select * from Quotes where email = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        }
        catch(SQLException e) {
            System.out.println("failed login");
            return false;
        }
    }
    //connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/userdb?"
                        + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }

    public List<RequestQuote> listAllQuotes() throws SQLException {
        List<RequestQuote> listQuote = new ArrayList<RequestQuote>();        
        String sql = "SELECT * FROM Quotes";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String phoneNumber = resultSet.getString("phoneNumber");
            String address_street_num = resultSet.getString("address_street_num"); 
            String address_street = resultSet.getString("address_street"); 
            String address_city = resultSet.getString("address_city"); 
            String address_state = resultSet.getString("address_state"); 
            String address_zip_code = resultSet.getString("address_zip_code"); 

            RequestQuote quotes = new RequestQuote(email, firstName, lastName, phoneNumber, address_street_num,  address_street,  address_city, address_state, address_zip_code);
            listQuote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }

    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
            connect.close();
        }
    }

    public void insert(RequestQuote quotes) throws SQLException {
        connect_func("root","pass1234");         
        String sql = "insert into Quotes(email, firstName, lastName, phoneNumber, address_street_num, address_street, address_city, address_state, address_zip_code) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, quotes.getEmail());
        preparedStatement.setString(2, quotes.getFirstName());
        preparedStatement.setString(3, quotes.getLastName());
        preparedStatement.setString(4, quotes.getPhoneNumber());
        preparedStatement.setString(5, quotes.getAddress_street_num());		
        preparedStatement.setString(6, quotes.getAddress_street());		
        preparedStatement.setString(7, quotes.getAddress_city());		
        preparedStatement.setString(8, quotes.getAddress_state());		
        preparedStatement.setString(9, quotes.getAddress_zip_code());			

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
