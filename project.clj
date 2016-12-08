(defproject co.datil/sri-clj "0.1.1"
  :description "Librería Clojure para emisión de comprobantes electrónicos en Ecuador."
  :url "https://github.com/datil/sri-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths ["config", "resources"]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.apache.axis/axis "1.4"]
                 [javax.xml/jaxrpc-api "1.1"]
                 [commons-logging/commons-logging "1.2"]
                 [commons-discovery/commons-discovery "0.5"]
                 [wsdl4j/wsdl4j "1.6.2"]
                 [environ "1.1.0"]
                 [selmer "1.10.2"]]
  :profiles{:dev {:dependencies [[co.datil/xml-validation "0.1.0"]]}}
  :plugins [[lein-codox "0.10.1"]]
  :codox {:metadata {:doc/format :markdown}})
