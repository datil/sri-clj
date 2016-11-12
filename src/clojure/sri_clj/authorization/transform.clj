(ns sri-clj.authorization.transform
  (:import [autorizacion.ws.sri.gob.ec Autorizacion]
           [autorizacion.ws.sri.gob.ec AutorizacionMensajes]
           [autorizacion.ws.sri.gob.ec Mensaje]
           [autorizacion.ws.sri.gob.ec RespuestaComprobante]
           [autorizacion.ws.sri.gob.ec RespuestaComprobanteAutorizaciones]
           [autorizacion.ws.sri.gob.ec RespuestaLote]
           [autorizacion.ws.sri.gob.ec RespuestaLoteAutorizaciones]))

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

(defn- authorizations
  [apojos]
  (if apojos
    (into [] (map #(hash-map
                    :status (or (.getEstado %) "")
                    :authorization-number (or (.getNumeroAutorizacion %) "")
                    :authorization-date (or (.getFechaAutorizacion %) "")
                    :environment (or (.getAmbiente %) "")
                    :receipt (or (.getComprobante %) "")
                    :messages (messages (.getMensaje (.getMensajes %))))
                  apojos))
    []))

(defn response
  [pojo]
  {:access-code (.getClaveAccesoConsultada pojo)
   :receipt-count (.getNumeroComprobantes pojo)
   :authorizations [{:status "AUTORIZADO"
                     :authorization-number "123"
                     :authorization-date "2016-11-12T13:14:15"
                     :environment "PRUEBAS"
                     :receipt "<xml>stub</xml>"
                     :messages [{:identifier "60"
                                 :message "PROCESO DE PRUEBAS"
                                 :informacion-adicional "Test"
                                 :type "ADVERTENCIA"}]}]})
