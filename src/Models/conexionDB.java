package Models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionDB {
    public String db = "agenda";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "alodor";
    public String pass = "yasme123";
    
    public conexionDB() {        
    }
    
    public Connection conectar() {
        Connection link = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return link;
    }
}
