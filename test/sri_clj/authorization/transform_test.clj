(ns sri-clj.authorization.transform-test
  (:require [clojure.test :refer :all]
            [sri-clj.authorization.transform :refer :all])
  (:import [autorizacion.ws.sri.gob.ec Autorizacion]
           [autorizacion.ws.sri.gob.ec AutorizacionMensajes]
           [autorizacion.ws.sri.gob.ec Mensaje]
           [autorizacion.ws.sri.gob.ec RespuestaComprobante]
           [autorizacion.ws.sri.gob.ec RespuestaComprobanteAutorizaciones]
           [autorizacion.ws.sri.gob.ec RespuestaLote]
           [autorizacion.ws.sri.gob.ec RespuestaLoteAutorizaciones]))

(deftest transforms-response-test
  (let [stub-date (doto (java.util.Calendar/getInstance)
                    (.set 2016 11 12 13 14 15))
        message (Mensaje. "60" "PROCESO DE PRUEBAS" "Test" "ADVERTENCIA")
        messages (AutorizacionMensajes. (into-array [message]))
        authorization (Autorizacion. "AUTORIZADO"
                                     "123"
                                     stub-date
                                     "PRUEBAS"
                                     "<xml>stub</xml>"
                                     messages)
        authorizations (RespuestaComprobanteAutorizaciones.
                        (into-array [authorization]))
        response-pojo (RespuestaComprobante. "123"
                                             "1"
                                             authorizations)]
    (is (= (response response-pojo)
           {:access-code "123"
            :receipt-count "1"
            :authorizations [{:status "AUTORIZADO"
                              :authorization-number "123"
                              :authorization-date "2016-11-12T13:14:15"
                              :environment "PRUEBAS"
                              :receipt "<xml>stub</xml>"
                              :messages [{:identifier "60"
                                          :message "PROCESO DE PRUEBAS"
                                          :informacion-adicional "Test"
                                          :type "ADVERTENCIA"}]}]}))))
