package ec.gob.sri.firmaxades.test;

import ec.gob.sri.firmaxades.util.FirmaGenerica;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.javasign.EnumFormatoFirma;
import es.mityc.javasign.xml.refs.InternObjectToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class FirmasGenericasXAdES extends FirmaGenerica {
    private String archivoAFirmar;
    private String archivoFirmado;

    public FirmasGenericasXAdES() {
    }

    public FirmasGenericasXAdES(String directorioSalidaFirma, Provider provider, X509Certificate certificado, PrivateKey privateKey, String archivoAFirmar, String archivoFirmado) {
        super(directorioSalidaFirma, provider, certificado, privateKey);
        this.archivoAFirmar = archivoAFirmar;
        this.archivoFirmado = archivoFirmado;
    }

    public void ejecutarFirmaXades(String pathArchivoXMLFirmar, String pathDirectorioSalida, String nombreArchivoFirmado, Provider provider, X509Certificate certificado, PrivateKey privateKey)
        throws ParserConfigurationException, SAXException, IOException {
        FirmasGenericasXAdES signature = new FirmasGenericasXAdES(pathDirectorioSalida, provider, certificado, privateKey, pathArchivoXMLFirmar, nombreArchivoFirmado);

        signature.execute();
    }

    protected DataToSign createDataToSign() throws ParserConfigurationException, SAXException, IOException {
        DataToSign datosAFirmar = new DataToSign();
        datosAFirmar.setXadesFormat(EnumFormatoFirma.XAdES_BES);
        datosAFirmar.setEsquema(XAdESSchemas.XAdES_132);
        datosAFirmar.setXMLEncoding("UTF-8");
        datosAFirmar.setEnveloped(true);
        datosAFirmar.addObject(new ObjectToSign(new InternObjectToSign("comprobante"), "contenido comprobante", null, "text/xml", null));
        datosAFirmar.setParentSignNode("comprobante");

        Document docToSign = getDocument(this.archivoAFirmar);
        datosAFirmar.setDocument(docToSign);
        return datosAFirmar;
    }

    protected String getSignatureFileName() {
        return this.archivoFirmado;
    }

    public String getArchivoAFirmar() {
        return this.archivoAFirmar;
    }

    public void setArchivoAFirmar(String archivoAFirmar) {
        this.archivoAFirmar = archivoAFirmar;
    }

    public String getArchivoFirmado() {
        return this.archivoFirmado;
    }

    public void setArchivoFirmado(String archivoFirmado) {
        this.archivoFirmado = archivoFirmado;
    }
}
