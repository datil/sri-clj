package ec.facturar;

import ec.gob.sri.firmaxades.test.FirmasGenericasXAdES;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import testxades.PrivateKeyInfo;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.apache.commons.lang.RandomStringUtils;

import java.util.*;

public class SignCLI {

    public static String generateUniqueFileName() {
        String filename="";
        long millis=System.currentTimeMillis();
        String datetime=new Date().toGMTString();
        datetime=datetime.replace(" ", "");
        datetime=datetime.replace(":", "");
        String rndchars=RandomStringUtils.randomAlphanumeric(16);
        filename=rndchars+"_"+datetime+"_"+millis;
        return filename;
    }

    public static HashMap signAction(String xmlsource, String pfxfile, String password) throws MalformedURLException,
        IOException,
        KeyStoreException,
        ParserConfigurationException,
        NoSuchAlgorithmException,
        UnrecoverableKeyException,
        SAXException,
        CertificateException {
        BufferedReader br = new BufferedReader(new StringReader(xmlsource));
        String token = generateUniqueFileName()+"."+"xml";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String leido = br.readLine();

        while (leido!=null) {
            baos.write(leido.getBytes());
            baos.write("\r\n".getBytes());
            leido = br.readLine();
        }
        br.close();

        File tmpXml = new File(System.getProperty("java.io.tmpdir"), token+".xml");

        File tmpXmlFirmado = new File(System.getProperty("java.io.tmpdir"), token+"firmado.xml");

        FileOutputStream fout = new FileOutputStream(tmpXml);
        fout.write(baos.toByteArray());
        fout.close();

        HashMap<String, Serializable> result = new HashMap<String, Serializable>();

        KeyStore ks = testxades.TestXades.getKeyStore(pfxfile, password);

        Provider provider = ks.getProvider();
        List<CertAlias> aliases = testxades.TestXades.getAliasesList(ks);

        CertAlias alias = aliases.get(0);

        final PrivateKeyInfo pkInfo = testxades.TestXades.getPkInfo(ks, alias, pfxfile, password);

        final PrivateKey key = pkInfo.getKey();
        final Certificate[] chain = pkInfo.getChain();

        X509Certificate certificate = (X509Certificate)chain[0];

        FirmasGenericasXAdES firmar = new FirmasGenericasXAdES();

        String folder = tmpXml.getParent();

        firmar.ejecutarFirmaXades(tmpXml.getAbsolutePath(), folder, tmpXmlFirmado.getAbsolutePath(), provider, certificate, key);

        FileInputStream fin = new FileInputStream(tmpXmlFirmado);
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int leido2 = fin.read(buffer);
        while (leido2>=0) {
            baos2.write(buffer,0,leido2);
            leido2 = fin.read(buffer);
        }
        fin.close();

        byte[] firmado = baos2.toByteArray();

        result.put("signedXml", tmpXmlFirmado);
        result.put("token", token);

        return result;
    }
}
