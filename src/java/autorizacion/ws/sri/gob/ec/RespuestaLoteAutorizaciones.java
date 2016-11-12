/**
 * RespuestaLoteAutorizaciones.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package autorizacion.ws.sri.gob.ec;

public class RespuestaLoteAutorizaciones  implements java.io.Serializable {
    private autorizacion.ws.sri.gob.ec.Autorizacion[] autorizacion;

    public RespuestaLoteAutorizaciones() {
    }

    public RespuestaLoteAutorizaciones(
           autorizacion.ws.sri.gob.ec.Autorizacion[] autorizacion) {
           this.autorizacion = autorizacion;
    }


    /**
     * Gets the autorizacion value for this RespuestaLoteAutorizaciones.
     * 
     * @return autorizacion
     */
    public autorizacion.ws.sri.gob.ec.Autorizacion[] getAutorizacion() {
        return autorizacion;
    }


    /**
     * Sets the autorizacion value for this RespuestaLoteAutorizaciones.
     * 
     * @param autorizacion
     */
    public void setAutorizacion(autorizacion.ws.sri.gob.ec.Autorizacion[] autorizacion) {
        this.autorizacion = autorizacion;
    }

    public autorizacion.ws.sri.gob.ec.Autorizacion getAutorizacion(int i) {
        return this.autorizacion[i];
    }

    public void setAutorizacion(int i, autorizacion.ws.sri.gob.ec.Autorizacion _value) {
        this.autorizacion[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaLoteAutorizaciones)) return false;
        RespuestaLoteAutorizaciones other = (RespuestaLoteAutorizaciones) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.autorizacion==null && other.getAutorizacion()==null) || 
             (this.autorizacion!=null &&
              java.util.Arrays.equals(this.autorizacion, other.getAutorizacion())));
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
        if (getAutorizacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAutorizacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAutorizacion(), i);
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
        new org.apache.axis.description.TypeDesc(RespuestaLoteAutorizaciones.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", ">respuestaLote>autorizaciones"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "autorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "autorizacion"));
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
