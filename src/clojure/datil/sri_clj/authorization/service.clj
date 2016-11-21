(ns datil.sri-clj.authorization.service
  (:import [autorizacion.ws.sri.gob.ec
            AutorizacionComprobantesOfflineServiceLocator]))

(defn service
  [url]
  (.getAutorizacionComprobantesOfflinePort
   (AutorizacionComprobantesOfflineServiceLocator.) (clojure.java.io/as-url url)))
