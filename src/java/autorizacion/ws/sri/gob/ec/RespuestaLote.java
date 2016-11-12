/**
 * RespuestaLote.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package autorizacion.ws.sri.gob.ec;

public class RespuestaLote  implements java.io.Serializable {
    private java.lang.String claveAccesoLoteConsultada;
    private java.lang.String numeroComprobantesLote;
    private autorizacion.ws.sri.gob.ec.RespuestaLoteAutorizaciones autorizaciones;

    public RespuestaLote() {
    }

    public RespuestaLote(
           java.lang.String claveAccesoLoteConsultada,
           java.lang.String numeroComprobantesLote,
           autorizacion.ws.sri.gob.ec.RespuestaLoteAutorizaciones autorizaciones) {
           this.claveAccesoLoteConsultada = claveAccesoLoteConsultada;
           this.numeroComprobantesLote = numeroComprobantesLote;
           this.autorizaciones = autorizaciones;
    }


    /**
     * Gets the claveAccesoLoteConsultada value for this RespuestaLote.
     * 
     * @return claveAccesoLoteConsultada
     */
    public java.lang.String getClaveAccesoLoteConsultada() {
        return claveAccesoLoteConsultada;
    }


    /**
     * Sets the claveAccesoLoteConsultada value for this RespuestaLote.
     * 
     * @param claveAccesoLoteConsultada
     */
    public void setClaveAccesoLoteConsultada(java.lang.String claveAccesoLoteConsultada) {
        this.claveAccesoLoteConsultada = claveAccesoLoteConsultada;
    }


    /**
     * Gets the numeroComprobantesLote value for this RespuestaLote.
     * 
     * @return numeroComprobantesLote
     */
    public java.lang.String getNumeroComprobantesLote() {
        return numeroComprobantesLote;
    }


    /**
     * Sets the numeroComprobantesLote value for this RespuestaLote.
     * 
     * @param numeroComprobantesLote
     */
    public void setNumeroComprobantesLote(java.lang.String numeroComprobantesLote) {
        this.numeroComprobantesLote = numeroComprobantesLote;
    }


    /**
     * Gets the autorizaciones value for this RespuestaLote.
     * 
     * @return autorizaciones
     */
    public autorizacion.ws.sri.gob.ec.RespuestaLoteAutorizaciones getAutorizaciones() {
        return autorizaciones;
    }


    /**
     * Sets the autorizaciones value for this RespuestaLote.
     * 
     * @param autorizaciones
     */
    public void setAutorizaciones(autorizacion.ws.sri.gob.ec.RespuestaLoteAutorizaciones autorizaciones) {
        this.autorizaciones = autorizaciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaLote)) return false;
        RespuestaLote other = (RespuestaLote) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claveAccesoLoteConsultada==null && other.getClaveAccesoLoteConsultada()==null) || 
             (this.claveAccesoLoteConsultada!=null &&
              this.claveAccesoLoteConsultada.equals(other.getClaveAccesoLoteConsultada()))) &&
            ((this.numeroComprobantesLote==null && other.getNumeroComprobantesLote()==null) || 
             (this.numeroComprobantesLote!=null &&
              this.numeroComprobantesLote.equals(other.getNumeroComprobantesLote()))) &&
            ((this.autorizaciones==null && other.getAutorizaciones()==null) || 
             (this.autorizaciones!=null &&
              this.autorizaciones.equals(other.getAutorizaciones())));
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
        if (getClaveAccesoLoteConsultada() != null) {
            _hashCode += getClaveAccesoLoteConsultada().hashCode();
        }
        if (getNumeroComprobantesLote() != null) {
            _hashCode += getNumeroComprobantesLote().hashCode();
        }
        if (getAutorizaciones() != null) {
            _hashCode += getAutorizaciones().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaLote.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "respuestaLote"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveAccesoLoteConsultada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claveAccesoLoteConsultada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroComprobantesLote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroComprobantesLote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autorizaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autorizaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", ">respuestaLote>autorizaciones"));
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
