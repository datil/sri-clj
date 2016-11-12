/**
 * Autorizacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package autorizacion.ws.sri.gob.ec;

public class Autorizacion  implements java.io.Serializable {
    private java.lang.String estado;
    private java.lang.String numeroAutorizacion;
    private java.util.Calendar fechaAutorizacion;
    private java.lang.String ambiente;
    private java.lang.String comprobante;
    private autorizacion.ws.sri.gob.ec.AutorizacionMensajes mensajes;

    public Autorizacion() {
    }

    public Autorizacion(
           java.lang.String estado,
           java.lang.String numeroAutorizacion,
           java.util.Calendar fechaAutorizacion,
           java.lang.String ambiente,
           java.lang.String comprobante,
           autorizacion.ws.sri.gob.ec.AutorizacionMensajes mensajes) {
           this.estado = estado;
           this.numeroAutorizacion = numeroAutorizacion;
           this.fechaAutorizacion = fechaAutorizacion;
           this.ambiente = ambiente;
           this.comprobante = comprobante;
           this.mensajes = mensajes;
    }


    /**
     * Gets the estado value for this Autorizacion.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this Autorizacion.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the numeroAutorizacion value for this Autorizacion.
     * 
     * @return numeroAutorizacion
     */
    public java.lang.String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }


    /**
     * Sets the numeroAutorizacion value for this Autorizacion.
     * 
     * @param numeroAutorizacion
     */
    public void setNumeroAutorizacion(java.lang.String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }


    /**
     * Gets the fechaAutorizacion value for this Autorizacion.
     * 
     * @return fechaAutorizacion
     */
    public java.util.Calendar getFechaAutorizacion() {
        return fechaAutorizacion;
    }


    /**
     * Sets the fechaAutorizacion value for this Autorizacion.
     * 
     * @param fechaAutorizacion
     */
    public void setFechaAutorizacion(java.util.Calendar fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }


    /**
     * Gets the ambiente value for this Autorizacion.
     * 
     * @return ambiente
     */
    public java.lang.String getAmbiente() {
        return ambiente;
    }


    /**
     * Sets the ambiente value for this Autorizacion.
     * 
     * @param ambiente
     */
    public void setAmbiente(java.lang.String ambiente) {
        this.ambiente = ambiente;
    }


    /**
     * Gets the comprobante value for this Autorizacion.
     * 
     * @return comprobante
     */
    public java.lang.String getComprobante() {
        return comprobante;
    }


    /**
     * Sets the comprobante value for this Autorizacion.
     * 
     * @param comprobante
     */
    public void setComprobante(java.lang.String comprobante) {
        this.comprobante = comprobante;
    }


    /**
     * Gets the mensajes value for this Autorizacion.
     * 
     * @return mensajes
     */
    public autorizacion.ws.sri.gob.ec.AutorizacionMensajes getMensajes() {
        return mensajes;
    }


    /**
     * Sets the mensajes value for this Autorizacion.
     * 
     * @param mensajes
     */
    public void setMensajes(autorizacion.ws.sri.gob.ec.AutorizacionMensajes mensajes) {
        this.mensajes = mensajes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Autorizacion)) return false;
        Autorizacion other = (Autorizacion) obj;
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
            ((this.numeroAutorizacion==null && other.getNumeroAutorizacion()==null) || 
             (this.numeroAutorizacion!=null &&
              this.numeroAutorizacion.equals(other.getNumeroAutorizacion()))) &&
            ((this.fechaAutorizacion==null && other.getFechaAutorizacion()==null) || 
             (this.fechaAutorizacion!=null &&
              this.fechaAutorizacion.equals(other.getFechaAutorizacion()))) &&
            ((this.ambiente==null && other.getAmbiente()==null) || 
             (this.ambiente!=null &&
              this.ambiente.equals(other.getAmbiente()))) &&
            ((this.comprobante==null && other.getComprobante()==null) || 
             (this.comprobante!=null &&
              this.comprobante.equals(other.getComprobante()))) &&
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
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getNumeroAutorizacion() != null) {
            _hashCode += getNumeroAutorizacion().hashCode();
        }
        if (getFechaAutorizacion() != null) {
            _hashCode += getFechaAutorizacion().hashCode();
        }
        if (getAmbiente() != null) {
            _hashCode += getAmbiente().hashCode();
        }
        if (getComprobante() != null) {
            _hashCode += getComprobante().hashCode();
        }
        if (getMensajes() != null) {
            _hashCode += getMensajes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Autorizacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", "autorizacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroAutorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroAutorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaAutorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaAutorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ambiente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ambiente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensajes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensajes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ec.gob.sri.ws.autorizacion", ">autorizacion>mensajes"));
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
