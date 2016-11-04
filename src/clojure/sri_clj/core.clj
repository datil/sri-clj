(ns sri-clj.core
  (:import [javax.xml.namespace QName]
           [recepcion.ws.sri.gob.ec RecepcionComprobantesOfflineServiceLocator]))

(def envs {:test (clojure.java.io/as-url "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl")})

(defn validation-service
  [env]
  (.getRecepcionComprobantesOfflinePort
   (RecepcionComprobantesOfflineServiceLocator.)
   (get envs env)))

(defn validate-receipt
  [service xml]
  (.validarComprobante service xml))

(defn- parse-messages
  [apojos]
  (into [] (map #(hash-map :identifier (.getIdentificador %)
                           :message (.getMensaje %)
                           :additional-information (.getInformacionAdicional %)
                           :type (.getTipo %)) apojos)))

(defn- parse-receipts
  [apojos]
  (into [] (map #(let [messages (.getMensaje (.getMensajes %))]
                   (hash-map :access-code (.getClaveAcceso %)
                             :messages (if messages (parse-messages messages) [])))
                apojos)))

(defn o->m
  [pojo]
  (let [receipts (.getComprobante (.getComprobantes pojo))]
    {:status (.getEstado pojo)
     :receipts (if receipts (parse-receipts receipts) [])}))
