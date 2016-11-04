/**
 * RespuestaSolicitud.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package recepcion.ws.sri.gob.ec;

public class RespuestaSolicitud  implements java.io.Serializable {
    private java.lang.String estado;
    private recepcion.ws.sri.gob.ec.RespuestaSolicitudComprobantes comprobantes;

    public RespuestaSolicitud() {
    }

    public RespuestaSolicitud(
           java.lang.String estado,
           recepcion.ws.sri.gob.ec.RespuestaSolicitudComprobantes comprobantes) {
           this.estado = estado;
           this.comprobantes = comprobantes;
    }


    /**
     * Gets the estado value for this RespuestaSolicitud.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this RespuestaSolicitud.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the comprobantes value for this RespuestaSolicitud.
     * 
     * @return comprobantes
     */
    public recepcion.ws.sri.gob.ec.RespuestaSolicitudComprobantes getComprobantes() {
        return comprobantes;
    }


    /**
     * Sets the comprobantes value for this RespuestaSolicitud.
     * 
     * @param comprobantes
     */
    public void setComprobantes(recepcion.ws.sri.gob.ec.RespuestaSolicitudComprobantes comprobantes) {
        this.comprobantes = comprobantes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaSolicitud)) return false;
        RespuestaSolicitud other = (RespuestaSolicitud) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.comprobantes==null && other.getComprobantes()==null) || 
             (this.comprobantes!=null &&
              this.comprobantes.equals(other.getComprobantes())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getComprobantes() != null) {
            _hashCode += getComprobantes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaSolicitud.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", "respuestaSolicitud"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comprobantes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comprobantes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", ">respuestaSolicitud>comprobantes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
