/**
 * Comprobante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package recepcion.ws.sri.gob.ec;

public class Comprobante  implements java.io.Serializable {
    private java.lang.String claveAcceso;
    private recepcion.ws.sri.gob.ec.ComprobanteMensajes mensajes;

    public Comprobante() {
    }

    public Comprobante(
           java.lang.String claveAcceso,
           recepcion.ws.sri.gob.ec.ComprobanteMensajes mensajes) {
           this.claveAcceso = claveAcceso;
           this.mensajes = mensajes;
    }


    /**
     * Gets the claveAcceso value for this Comprobante.
     * 
     * @return claveAcceso
     */
    public java.lang.String getClaveAcceso() {
        return claveAcceso;
    }


    /**
     * Sets the claveAcceso value for this Comprobante.
     * 
     * @param claveAcceso
     */
    public void setClaveAcceso(java.lang.String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }


    /**
     * Gets the mensajes value for this Comprobante.
     * 
     * @return mensajes
     */
    public recepcion.ws.sri.gob.ec.ComprobanteMensajes getMensajes() {
        return mensajes;
    }


    /**
     * Sets the mensajes value for this Comprobante.
     * 
     * @param mensajes
     */
    public void setMensajes(recepcion.ws.sri.gob.ec.ComprobanteMensajes mensajes) {
        this.mensajes = mensajes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Comprobante)) return false;
        Comprobante other = (Comprobante) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claveAcceso==null && other.getClaveAcceso()==null) || 
             (this.claveAcceso!=null &&
              this.claveAcceso.equals(other.getClaveAcceso()))) &&
            ((this.mensajes==null && other.getMensajes()==null) || 
             (this.mensajes!=null &&
              this.mensajes.equals(other.getMensajes())));
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
        if (getClaveAcceso() != null) {
            _hashCode += getClaveAcceso().hashCode();
        }
        if (getMensajes() != null) {
            _hashCode += getMensajes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Comprobante.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", "comprobante"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveAcceso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claveAcceso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensajes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensajes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", ">comprobante>mensajes"));
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
