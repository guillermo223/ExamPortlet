<%@page import="com.test.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>Portlet B</h1>
 
 
<% Persona persona=(Persona)request.getAttribute("mensaje");
 
 
  if(persona!=null){
	 
	 %>
	 
	 
	
	 <div>Nombre <input type="text" value="<%= persona.getNombre()%>"/></div>
	 <div>Direccion <input type="text" value="<%= persona.getDireccion()%>"/></div>
	 <div>Telefono <input type="text" value="<%= persona.getTelefono()%>"/></div>
	 
	 
	 
	 
	 <% 
	 
 }else{
 %>
  <h2>introduce tus datos en portleta</h2>
 
 <% 
 
 }
 %>
 