/**
 * RespuestaSolicitudComprobantes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package recepcion.ws.sri.gob.ec;

public class RespuestaSolicitudComprobantes  implements java.io.Serializable {
    private recepcion.ws.sri.gob.ec.Comprobante[] comprobante;

    public RespuestaSolicitudComprobantes() {
    }

    public RespuestaSolicitudComprobantes(
           recepcion.ws.sri.gob.ec.Comprobante[] comprobante) {
           this.comprobante = comprobante;
    }


    /**
     * Gets the comprobante value for this RespuestaSolicitudComprobantes.
     * 
     * @return comprobante
     */
    public recepcion.ws.sri.gob.ec.Comprobante[] getComprobante() {
        return comprobante;
    }


    /**
     * Sets the comprobante value for this RespuestaSolicitudComprobantes.
     * 
     * @param comprobante
     */
    public void setComprobante(recepcion.ws.sri.gob.ec.Comprobante[] comprobante) {
        this.comprobante = comprobante;
    }

    public recepcion.ws.sri.gob.ec.Comprobante getComprobante(int i) {
        return this.comprobante[i];
    }

    public void setComprobante(int i, recepcion.ws.sri.gob.ec.Comprobante _value) {
        this.comprobante[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaSolicitudComprobantes)) return false;
        RespuestaSolicitudComprobantes other = (RespuestaSolicitudComprobantes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.comprobante==null && other.getComprobante()==null) || 
             (this.comprobante!=null &&
              java.util.Arrays.equals(this.comprobante, other.getComprobante())));
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
        if (getComprobante() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComprobante());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComprobante(), i);
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
        new org.apache.axis.description.TypeDesc(RespuestaSolicitudComprobantes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", ">respuestaSolicitud>comprobantes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", "comprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.recepcion", "comprobante"));
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
