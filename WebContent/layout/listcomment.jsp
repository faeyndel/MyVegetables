<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<%@page import="com.object.Commentaire"%>
<%@ page import="java.util.List"  %>



<%

if  (request.getAttribute("commentaires")!=null) 
  {
	//out.print(request.getAttribute("commentaires"));
	
	
	  List <com.object.Commentaire> commentaires = (List <com.object.Commentaire>) request.getAttribute("commentaires");
      
      com.object.Commentaire tempcommentaire;
      com.object.Commentaire tempnote;
      
      /*NumberFormat f = NumberFormat.getInstance(loc);
      if (f instanceof DecimalFormat) {
    	  ((DecimalFormat) f).setMaximumFractionDigits(1);
          ((DecimalFormat) f).setDecimalSeparatorAlwaysShown(true);
      }
      
      DecimalFormat df = new DecimalFormat ( ) ; */
      
      
      
      float average = 0;
      
      for(int i=0;i<commentaires.size();i++)
      {
    	  tempnote = commentaires.get(i);
    	  average = average + tempnote.getNote();
      }
      
      
      
      average = average / (commentaires.size() + 1);
      out.print("<div id=\"avis\">");
  	out.print(" <h3>Les commentaires ");
      
  	java.text.DecimalFormat df = new java.text.DecimalFormat("#.#");
    df.setMaximumFractionDigits ( 1 ) ;
  	
  	
      out.print("<div id=\"markSlot\">Note moyenne : "+df.format(average)+" / 5</div></h3>");
      out.print("<div id=\"clear\"></div>");
      
      
      
      out.print("<table id=\"comments\">");
      for(int i=0;i<commentaires.size();i++)
      {
    	  tempcommentaire=commentaires.get(i); 
    	  if (i < (commentaires.size() - 1)){
    	    out.print("<tr class=\"com-line com-line-border\">");
    	  }else{
    		  out.print("<tr class=\"com-line\">");
    	  }
    	    out.print("<td valign=\"top\" class=\"com-line-pseudo\">");
    	    out.print("<table class=\"unstyle\">");
    	    out.print("<tr>");
    	    out.print("<td>Pseudonyme </td><td> "+tempcommentaire.getNickname()+"</td>");
    	    out.print("</tr>");
    	    out.print("<tr>");
    	    out.print("<td>Note </td><td> "+tempcommentaire.getNote()+"/5</td>");
    	    out.print("</tr>");
    	    out.print("</table>");
    	    
    	    out.print("</td>");
    	    out.print("<td valign=\"top\">"+tempcommentaire.getCommentaire()+"</td>");
    	    out.print("</tr>");		
    	  
    		  
    	 
      }
      out.print("</table>");
        	
      out.print("</div>");
 }

else{
	
	out.print("<div id=\"formavis\">");
    out.print(" <h3>Les commentaires </h3>");
    out.print("<table>");
    out.print("<tr>");			
    out.print("<td valign=\"top\">Aucun commentaire</td>");
    out.print("</tr>");	
    out.print("</table>");
    out.print("</div>");
	
	
}


%>
