(ns datil.sri-clj.validation.service
  (:import [recepcion.ws.sri.gob.ec RecepcionComprobantesOfflineServiceLocator]))

(defn service
  [url]
  (.getRecepcionComprobantesOfflinePort
   (RecepcionComprobantesOfflineServiceLocator.) (clojure.java.io/as-url url)))
