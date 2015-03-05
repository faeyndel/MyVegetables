package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.foed.bean.offre;
import com.model.DAOFactory;
import com.model.RestoDao;
import java.sql.*;
import java.util.*;
import java.util.regex.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;
//import org.apache.commons.io.*;


/**
 * AddImage est la classe représentant un controleur. Elle permet .
 * de transmettre les images uploader au modèle restodao.
 * Ce dernier se chargera de les insérer en base 
 * @author team MyVegetable
 * @version 1.0
 * 
 */

public class AddImage extends HttpServlet  {
	
	
private static final long serialVersionUID = 1L;
	
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String id = "message";
    public static final String VUE              = "/UpdateMessage.jsp";

    private RestoDao     restoDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Resto */
        this. restoDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getRestoDao();
    }

    public void doPost(   HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		String values[] = new String[2];
		String message="";

		int nextTab = 0;
		
		if (!isMultipart) {
			  message = "Veuillez fournir un fichier à uploader";
		}else {
			  FileItemFactory factory = new DiskFileItemFactory();
			  ServletFileUpload upload = new ServletFileUpload(factory);
			  List items = null; 
		 
			  try {
				  	items = upload.parseRequest(request);
				  }
			  catch (FileUploadException e) {
				  e.printStackTrace();
				  }
			  
			  Iterator itr = items.iterator();
			  while (itr.hasNext()) {
				  FileItem item = (FileItem) itr.next();
				  if (item.isFormField()){
					  String name = item.getFieldName();
					  String value = item.getString();
					  if (nextTab < 2){
						  values[nextTab] = value;
						  nextTab++;  
					  }
					  System.out.println("value: "+value);
				  } else {
					  try {
						  String itemName = item.getName();
						  Random generator = new Random();
						  int r = Math.abs(generator.nextInt());

						  String reg = "[.*]";
						  String replacingtext = "";
						  Pattern pattern = Pattern.compile(reg);
						  Matcher matcher = pattern.matcher(itemName);
						  StringBuffer buffer = new StringBuffer();
		
						  while (matcher.find()) {
							  matcher.appendReplacement(buffer, replacingtext);
						  }
						  
						  int IndexOf = itemName.indexOf("."); 
						  String domainName = itemName.substring(IndexOf);
		
						  String finalimage = buffer.toString()+"_"+r+domainName;

						  						  
						// String storePath = "G:\\apache-tomcat-6.0.35\\webapps\\MyVegetables\\WebContent\\res\\styles\\default\\img\\images\\";
						// String httpPath = "/MyVegetable/WebContent/res/styles/default/img/images/";
						  String current = new java.io.File( "." ).getCanonicalPath();

						  String currentDir = System.getProperty("user.dir");

					       
						  String storePath = "/var/lib/tomcat6/webapps/MyVegetables/res/styles/default/img/images/";
						  String httpPath = "http://delmasromain.com:1985/MyVegetables/res/styles/default/img/images/";
						  
						  File savedFile = new File(storePath+finalimage);
						  item.write(savedFile);


						  Connection conn = null;
						  String url = "jdbc:mysql://localhost/";
						  String dbName = "myvegetable";
						  String driver = "com.mysql.jdbc.Driver";
						  //String username = "root"; 
						  //String userPassword = "";
						  String username = "myvege"; 
						  String userPassword = "nBHR8be5YVc2xdwh";
						  String strQuery = null;
						  String strQuery1 = null;
						  String imgLen="";

						  try {

							  Class.forName(driver).newInstance();
							  conn = DriverManager.getConnection(url+dbName,username,
							  userPassword);

							  Statement st = conn.createStatement();
							  if (values[1].compareTo("0") == 0){
								  strQuery = "UPDATE mv_resto_photos SET photo_annuaire='"+httpPath+finalimage+"' WHERE id_resto='"+values[0]+"'"; 
							  }else if (values[1].compareTo("1") == 0){
								  strQuery = "UPDATE mv_resto_photos SET photo_slider='"+httpPath+finalimage+"' WHERE id_resto='"+values[0]+"'"; 
							  }else if (values[1].compareTo("2") == 0){
								  strQuery = "UPDATE mv_resto_photos SET photo_partenaire='"+httpPath+finalimage+"' WHERE id_resto='"+values[0]+"'"; 
							  }
							  int rs = st.executeUpdate(strQuery);

							  message="Votre photo a été uploader avec succès.";
						  }
						  catch (Exception e) {

						  }
						  finally {
							  conn.close();
						  }  
					  }
					  catch (Exception e) {
						  e.printStackTrace();
					  }
				  	}
				  }
				 }


		request.setAttribute( id, message );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    

}
