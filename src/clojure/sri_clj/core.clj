(ns sri-clj.core
  (:import [recepcion.ws.sri.gob.ec RecepcionComprobantesOfflineServiceLocator]))

(def envs {:test (clojure.java.io/as-url "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl")})

(defn validation-service
  [env]
  (.getRecepcionComprobantesOfflinePort
   (RecepcionComprobantesOfflineServiceLocator.)
   (get envs env)))

(defn validate-receipt
  [service xml]
  (.validarComprobante service xml))

(defn- messages
  [apojos]
  (if apojos
    (into [] (map
              #(hash-map :identifier (or (.getIdentificador %) "")
                         :message (or (.getMensaje %) "")
                         :additional-information (or (.getInformacionAdicional %) "")
                         :type (or (.getTipo %) ""))
              apojos))
    []))

(defn- receipts
  [apojos]
  (if apojos
    (into [] (map
              #(hash-map :access-code (or (.getClaveAcceso %) "")
                         :messages (messages (.getMensaje (.getMensajes %))))
              apojos))
    []))

(defn validation-response
  [pojo]
  {:status (.getEstado pojo)
   :receipts (receipts (.getComprobante (.getComprobantes pojo)))})
