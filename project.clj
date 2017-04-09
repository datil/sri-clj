(defproject co.datil/sri-clj "0.2.0"
  :description "Librería Clojure para emisión de comprobantes electrónicos en Ecuador."
  :url "https://github.com/datil/sri-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths ["config", "resources"]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :dependencies [[org.clojure/clojure "1.8.0"]

                 ;; Utilities
                 [environ "1.1.0"]
                 [selmer "1.10.2"]

                 ;; SOAP web services
                 [org.apache.axis/axis "1.4"]
                 [javax.xml/jaxrpc-api "1.1"]
                 [commons-logging/commons-logging "1.2"]
                 [commons-discovery/commons-discovery "0.5"]
                 [wsdl4j/wsdl4j "1.6.2"]

                 ;; XML signing
                 [org.jsoup/jsoup "1.8.2"]
                 [commons-lang/commons-lang "2.4"]
                 [eu.vitaliy/xades4j "1.2.0"]
                 [local/MITyCLibAPI "1.1.7"]
                 [local/MITyCLibCert "1.1.7"]
                 [local/MITyCLibCrypt "1.1.7"]
                 [local/MITyCLibOCSP "1.1.7"]
                 [local/MITyCLibPolicy "1.1.7"]
                 [local/MITyCLibTrust "1.1.7"]
                 [local/MITyCLibTSA "1.1.7"]
                 [local/MITyCLibXADES "1.1.7"]
                 [local/xmlsec "1.4.2-ADSI-1.1"]
                 [org.bouncycastle/bcpkix-jdk15on "1.52"]
                 [org.bouncycastle/bcprov-jdk15on "1.52"]
                 [org.bouncycastle/bcmail-jdk16 "1.46"]
                 [org.bouncycastle/bctsp-jdk16 "1.46"]]
  :profiles {:dev {:dependencies [[co.datil/xml-validation "0.1.0"]
                                 [com.github.kyleburton/clj-xpath "1.4.9"]
                                 [org.clojure/core.async "0.2.395"]]}}
  :plugins [[lein-codox "0.10.1"]
            [lein-localrepo "0.5.3"]]
  :codox {:metadata {:doc/format :markdown}})
