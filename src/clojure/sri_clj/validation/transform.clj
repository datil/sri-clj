(ns sri-clj.validation.transform)

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

(defn response
  [pojo]
  {:status (.getEstado pojo)
   :receipts (receipts (.getComprobante (.getComprobantes pojo)))})
