/**
 * AutorizacionComprobantesOfflineServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package autorizacion.ws.sri.gob.ec;

public class AutorizacionComprobantesOfflineServiceLocator extends org.apache.axis.client.Service implements autorizacion.ws.sri.gob.ec.AutorizacionComprobantesOfflineService {

    public AutorizacionComprobantesOfflineServiceLocator() {
    }


    public AutorizacionComprobantesOfflineServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AutorizacionComprobantesOfflineServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AutorizacionComprobantesOfflinePort
    private java.lang.String AutorizacionComprobantesOfflinePort_address = "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline";

    public java.lang.String getAutorizacionComprobantesOfflinePortAddress() {
        return AutorizacionComprobantesOfflinePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AutorizacionComprobantesOfflinePortWSDDServiceName = "AutorizacionComprobantesOfflinePort";

    public java.lang.String getAutorizacionComprobantesOfflinePortWSDDServiceName() {
        return AutorizacionComprobantesOfflinePortWSDDServiceName;
    }

    public void setAutorizacionComprobantesOfflinePortWSDDServiceName(java.lang.String name) {
        AutorizacionComprobantesOfflinePortWSDDServiceName = name;
    }

    public autorizacion.ws.sri.gob.ec.AutorizacionComprobantesOffline getAutorizacionComprobantesOfflinePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AutorizacionComprobantesOfflinePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAutorizacionComprobantesOfflinePort(endpoint);
    }

    public autorizacion.ws.sri.gob.ec.AutorizacionComprobantesOffline getAutorizacionComprobantesOfflinePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            autorizacion.ws.sri.gob.ec.AutorizacionComprobantesOfflineServiceSoapBindingStub _stub = new autorizacion.ws.sri.gob.ec.AutorizacionComprobantesOfflineServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAutorizacionComprobantesOfflinePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAutorizacionComprobantesOfflinePortEndpointAddress(java.lang.String address) {
        AutorizacionComprobantesOfflinePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (autorizacion.ws.sri.gob.ec.AutorizacionComprobantesOffline.class.isAssignableFrom(serviceEndpointInterface)) {
                autorizacion.ws.sri.gob.ec.AutorizacionComprobantesOfflineServiceSoapBindingStub _stub = new autorizacion.ws.sri.gob.ec.AutorizacionComprobantesOfflineServiceSoapBindingStub(new java.net.URL(AutorizacionComprobantesOfflinePort_address), this);
                _stub.setPortName(getAutorizacionComprobantesOfflinePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AutorizacionComprobantesOfflinePort".equals(inputPortName)) {
            return getAutorizacionComprobantesOfflinePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesOfflineService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesOfflinePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AutorizacionComprobantesOfflinePort".equals(portName)) {
            setAutorizacionComprobantesOfflinePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
