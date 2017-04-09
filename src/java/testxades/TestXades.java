package testxades;

import ec.facturar.CertAlias;
import ec.gob.sri.firmaxades.test.FirmasGenericasXAdES;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.MalformedURLException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.SAXException;

public class TestXades {
    public static PrivateKeyInfo getPkInfo(KeyStore tmpKs, CertAlias keyAlias, String pfxfile, String password)
        throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, ParserConfigurationException, SAXException,
        UnrecoverableKeyException {
        final PrivateKey tmpPk = (PrivateKey) tmpKs.getKey(keyAlias.getAlias(), password.toCharArray()); //options.getKeyPasswdX());
        final Certificate[] tmpChain = tmpKs.getCertificateChain(keyAlias.getAlias());
        PrivateKeyInfo tmpResult = new PrivateKeyInfo(tmpPk, tmpChain);
        return tmpResult;
    }

    public static CertAlias getKeyAliasInternal(final KeyStore aKs, CertAlias keyAlias) {
        if (aKs == null) {
            throw new NullPointerException("Keystore null");
        }
        CertAlias tmpResult = null;
        final List<CertAlias> tmpList = getAliasesList(aKs);
        final CertAlias tmpAlias = keyAlias;

        if (tmpAlias != null && tmpList.contains(tmpAlias)) {
            tmpResult = tmpAlias;
        } else if (tmpList.size() > 0) {
            tmpResult = tmpList.get(0);
        }
        return tmpResult;
    }

    public static List<CertAlias> getAliasesList(final KeyStore aKs) {

        if (aKs == null) {
            throw new NullPointerException("Keystore null");
        }
        final List<CertAlias> tmpResult = new ArrayList<CertAlias>();
        try {
            final Enumeration<String> tmpAliases = aKs.aliases();
            final boolean checkValidity = true;
            final boolean checkKeyUsage = true;
            final boolean checkCriticalExtensions = true;
            while (tmpAliases.hasMoreElements()) {
                String tmpAlias = tmpAliases.nextElement();
                if (aKs.isKeyEntry(tmpAlias)) {
                    final Certificate tmpCert = aKs.getCertificate(tmpAlias);
                    boolean tmpAddAlias = true;
                    if (tmpCert instanceof X509Certificate) {
                        final X509Certificate tmpX509 = (X509Certificate) tmpCert;
                        if (checkValidity) {
                            try {
                                tmpX509.checkValidity();
                            } catch (CertificateExpiredException e) {
                                tmpAddAlias = false;
                            } catch (CertificateNotYetValidException e) {
                                tmpAddAlias = false;
                            }
                        }
                        if (checkKeyUsage) {
                            final boolean keyUsage[] = tmpX509.getKeyUsage();
                            if (keyUsage != null && keyUsage.length > 0) {
                                if (!(keyUsage[0] || keyUsage[1])) {
                                    tmpAddAlias = false;
                                }
                            }
                        }
                        if (checkCriticalExtensions) {
                            final Set<String> criticalExtensionOIDs = tmpX509.getCriticalExtensionOIDs();
                            if (criticalExtensionOIDs != null) {
                                for (String oid : criticalExtensionOIDs) {
                                    if (!SUPPORTED_CRITICAL_EXTENSION_OIDS.contains(oid)) {
                                        tmpAddAlias = false;
                                    }
                                }
                            }
                        }
                    }
                    if (tmpAddAlias) {
                        tmpResult.add(new CertAlias(tmpAlias, getNombre((X509Certificate)tmpCert)));
                    }
                }
            }
        } catch (Exception e) {
            //
        }
        return tmpResult;
    }

    public static final Set<String> SUPPORTED_CRITICAL_EXTENSION_OIDS;

    static {
        final Set<String> oidSet = new HashSet<String>();
        oidSet.add("2.5.29.15"); // KeyUsage
        oidSet.add("2.5.29.17"); // Subject Alternative Name
        oidSet.add("2.5.29.19"); // Basic Constraints
        oidSet.add("2.5.29.29"); // Certificate Issuer
        oidSet.add("2.5.29.37"); // Extended Key Usage
        SUPPORTED_CRITICAL_EXTENSION_OIDS = Collections.unmodifiableSet(oidSet);
    }

    @SuppressWarnings("unchecked")
    public static void fixAliases(final KeyStore keyStore) {
        Field field;
        KeyStoreSpi keyStoreVeritable;
        final Set<String> tmpAliases = new HashSet<String>();
        try {
            field = keyStore.getClass().getDeclaredField("keyStoreSpi");
            field.setAccessible(true);
            keyStoreVeritable = (KeyStoreSpi) field.get(keyStore);

            if ("sun.security.mscapi.KeyStore$MY".equals(keyStoreVeritable.getClass().getName())) {
                Collection<Object> entries;
                String alias, hashCode;
                X509Certificate[] certificates;

                field = keyStoreVeritable.getClass().getEnclosingClass().getDeclaredField("entries");
                field.setAccessible(true);
                entries = (Collection<Object>) field.get(keyStoreVeritable);

                for (Object entry : entries) {
                    field = entry.getClass().getDeclaredField("certChain");
                    field.setAccessible(true);
                    certificates = (X509Certificate[]) field.get(entry);

                    hashCode = Integer.toString(certificates[0].hashCode());

                    field = entry.getClass().getDeclaredField("alias");
                    field.setAccessible(true);
                    alias = (String) field.get(entry);
                    String tmpAlias = alias;
                    int i = 0;
                    while (tmpAliases.contains(tmpAlias)) {
                        i++;
                        tmpAlias = alias + "-" + i;
                    }
                    tmpAliases.add(tmpAlias);
                    if (!alias.equals(hashCode)) {
                        field.set(entry, tmpAlias);
                    }
                }
            }
        } catch (Exception exception) {
        }
    }

    public static KeyStore getKeyStore(String pfxfile, String password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore ks = loadKS_PKCS12(pfxfile, password);
        return ks;
    }

    public static KeyStore loadKS_PKCS12(String pfxfile, String password) throws KeyStoreException, MalformedURLException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore tmpKs = null;
        InputStream tmpIS = null;

        tmpKs = KeyStore.getInstance("PKCS12");
        if (!StringUtils.isEmpty(pfxfile)) {
            tmpIS = new URL(pfxfile).openStream();
        }
        tmpKs.load(tmpIS, password.toCharArray());
        testxades.TestXades.fixAliases(tmpKs);

        return tmpKs;
    }

    private static String getNombre(X509Certificate tmpCert) {
        String dn = tmpCert.getSubjectX500Principal().getName();
        String[] parts = dn.split(",");
        for (int i=0; i<parts.length; i++) {
            String p = parts[i];
            if (p.startsWith("CN=")) {
                return p.substring(3);
            }
        }
        return dn;
    }
}
