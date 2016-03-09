package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletA
 */
public class PortletA extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    
    @ProcessAction(name="enviarEventoB")
	public void enviarEvento(ActionRequest arg0, ActionResponse arg1) throws PortletException, IOException {
		
		
		//la logica propia de este process action y ademas, en este caso enviamos el evento
		
		String nombre = arg0.getParameter("nombre");
		String direccion= arg0.getParameter("direccion");
		String telefono = arg0.getParameter("telefono");
		
		Persona persona = new Persona (nombre, direccion, telefono);
		
		QName qname = new QName("http://ejemplo.eventos.com", "mensajeB", "x");
		//setevent como qname
		arg1.setEvent(qname, persona);
		
		//alternativa, que es pasarlo como string setevent como string, 
		//lo que pone dentro me lo he cogido del portlet de consumidor
		//arg1.setEvent("{http://ejemplo.eventos.com}mensaje", "Hola desde el productor");
	}
	
	@ProcessAction(name="enviarEventoC")
	public void alta(ActionRequest arg0, ActionResponse arg1) throws PortletException, IOException {
		
		
		String nombre = arg0.getParameter("nombre");
		String direccion= arg0.getParameter("direccion");
		String telefono = arg0.getParameter("telefono");
		
		Persona persona = new Persona (nombre, direccion, telefono);
		
		
		QName qname = new QName("http://ejemplo.eventos.com", "mensajeC", "x");
		//setevent como qname
		arg1.setEvent(qname, persona);
		
	}
    
	
	
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(PortletA.class);

}
