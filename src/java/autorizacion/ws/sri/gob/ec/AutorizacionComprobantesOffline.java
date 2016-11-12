/**
 * AutorizacionComprobantesOffline.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package autorizacion.ws.sri.gob.ec;

public interface AutorizacionComprobantesOffline extends java.rmi.Remote {
    public autorizacion.ws.sri.gob.ec.RespuestaComprobante autorizacionComprobante(java.lang.String claveAccesoComprobante) throws java.rmi.RemoteException;
    public autorizacion.ws.sri.gob.ec.RespuestaLote autorizacionComprobanteLote(java.lang.String claveAccesoLote) throws java.rmi.RemoteException;
}
