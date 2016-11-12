(ns sri-clj.validation.service
  (:import [recepcion.ws.sri.gob.ec RecepcionComprobantesOfflineServiceLocator]))

(defn service
  [url]
  (.getRecepcionComprobantesOfflinePort
   (RecepcionComprobantesOfflineServiceLocator.)
   url))
