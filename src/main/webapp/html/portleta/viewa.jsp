<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />



<portlet:actionURL name="enviarEventoB" var="EnviarEventoURLB"/>
<portlet:actionURL name="enviarEventoC" var="EnviarEventoURLC"/>


	<h1>Portlet A</h1>
	
	
<form method="post">
	Nombre<input type="text" name="nombre"/>
	Direccion<input type="text" name="direccion"/>
	Teléfono<input type="text" name="telefono"/>
	
	<input type="submit" value="PortletB" formaction="<%=EnviarEventoURLB%>"/>
	<input type="submit" value="PortletC" formaction="<%=EnviarEventoURLC%>"/>
</form>



