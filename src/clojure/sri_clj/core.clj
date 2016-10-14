(ns sri-clj.core
  (:import [ec.gob.sri.recepcion RecepcionComprobantesOfflineService]
           [ec.gob.sri.autorizacion AutorizacionComprobantesOfflineService]
           [javax.xml.namespace QName]))

(defn reception-service
  [url]
  (.getRecepcionComprobantesOfflinePort (RecepcionComprobantesOfflineService.)))

(defn send-receipt
  [service xml]
  (.validarComprobante service xml))
