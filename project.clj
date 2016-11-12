(defproject sri-clj "0.1.0"
  :description "Librería Clojure para los servicios web del Servicio de Rentas Internas."
  :url "https://github.com/datil/sri-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths ["config", "resources"]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.2.395"]
                 [org.apache.axis/axis "1.4"]
                 [javax.xml/jaxrpc-api "1.1"]
                 [commons-logging/commons-logging "1.2"]
                 [commons-discovery/commons-discovery "0.5"]
                 [wsdl4j/wsdl4j "1.6.2"]
                 [environ "1.1.0"]])
