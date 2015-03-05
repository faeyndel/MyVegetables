package com.config;
import java.sql.*;
public class SQLselect {
   public static void main(String[] args) throws SQLException, ClassNotFoundException {
      String base = "//localhost/test";  // Adresse de la Base : //localhost/bd
      String req = "Select * from poste";                    // Requête : "select * from table1"
      String user = "root_superviseur";                     // User
      String password = "admin"; // Password
      Class.forName("com.mysql.jdbc.Driver"); // Charge le pilote
      Connection con = DriverManager.getConnection("jdbc:mysql:" + base,user,password);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(req);
      int n = rs.getMetaData().getColumnCount();// Nombre de colonnes
      int i = 1;                                // Index de colonne
      String x="";
      while (rs.next()) {
         i=1;
         while (i<n) {
            x = rs.getString(i);
            System.out.print(x + ";");
            i++;
         }
         x = rs.getString(i);
         System.out.println(x);
      }
      rs.close();
      st.close();
      con.close();
   }
}