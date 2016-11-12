/**
 * AutorizacionMensajes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package autorizacion.ws.sri.gob.ec;

public class AutorizacionMensajes  implements java.io.Serializable {
    private autorizacion.ws.sri.gob.ec.Mensaje[] mensaje;

    public AutorizacionMensajes() {
    }

    public AutorizacionMensajes(
           autorizacion.ws.sri.gob.ec.Mensaje[] mensaje) {
           this.mensaje = mensaje;
    }


    /**
     * Gets the mensaje value for this AutorizacionMensajes.
     * 
     * @return mensaje
     */
    public autorizacion.ws.sri.gob.ec.Mensaje[] getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this AutorizacionMensajes.
     * 
     * @param mensaje
     */
    public void setMensaje(autorizacion.ws.sri.gob.ec.Mensaje[] mensaje) {
        this.mensaje = mensaje;
    }

    public autorizacion.ws.sri.gob.ec.Mensaje getMensaje(int i) {
        return this.mensaje[i];
    }

    public void setMensaje(int i, autorizacion.ws.sri.gob.ec.Mensaje _value) {
        this.mensaje[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutorizacionMensajes)) return false;
        AutorizacionMensajes other = (AutorizacionMensajes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              java.util.Arrays.equals(this.mensaje, other.getMensaje())));
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
        if (getMensaje() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMensaje());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMensaje(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutorizacionMensajes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", ">autorizacion>mensajes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "mensaje"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
