(ns datil.sri-clj.authorization.transform-test
  (:require [clojure.test :refer :all]
            [datil.sri-clj.authorization.transform :refer :all]
            [clojure.instant :as i])
  (:import [autorizacion.ws.sri.gob.ec Autorizacion]
           [autorizacion.ws.sri.gob.ec AutorizacionMensajes]
           [autorizacion.ws.sri.gob.ec Mensaje]
           [autorizacion.ws.sri.gob.ec RespuestaComprobante]
           [autorizacion.ws.sri.gob.ec RespuestaComprobanteAutorizaciones]
           [autorizacion.ws.sri.gob.ec RespuestaLote]
           [autorizacion.ws.sri.gob.ec RespuestaLoteAutorizaciones]))

(deftest transforms-response-with-no-authorizations-test
  (let [authorizations (RespuestaComprobanteAutorizaciones.
                        (into-array Autorizacion []))
        response-pojo (RespuestaComprobante. "123"
                                             "0"
                                             authorizations)]
    (is (= (response response-pojo)
           {:access-code "123"
            :receipt-count "0"
            :authorizations []}))))

(deftest transforms-single-authorization-with-single-message-test
  (let [stub-date (i/read-instant-calendar "2016-11-12T10:00:00-05:00")
        message (Mensaje. "60" "PROCESO DE PRUEBAS" "Test" "ADVERTENCIA")
        messages (AutorizacionMensajes. (into-array Mensaje [message]))
        authorization (Autorizacion. "AUTORIZADO"
                                     "123"
                                     stub-date
                                     "PRUEBAS"
                                     "<xml>stub</xml>"
                                     messages)
        authorizations (RespuestaComprobanteAutorizaciones.
                        (into-array Autorizacion [authorization]))
        response-pojo (RespuestaComprobante. "123" "1" authorizations)]
    (is (= (response response-pojo)
           {:access-code "123"
            :receipt-count "1"
            :authorizations
            [{:status "AUTORIZADO"
              :authorization-number "123"
              :authorization-date (i/read-instant-calendar
                                   "2016-11-12T10:00:00-05:00")
              :environment "PRUEBAS"
              :receipt "<xml>stub</xml>"
              :messages [{:identifier "60"
                          :message "PROCESO DE PRUEBAS"
                          :additional-information "Test"
                          :type "ADVERTENCIA"}]}]}))))

(deftest transforms-multiple-authorization-with-multiple-messages-test
  (let [stub-date (i/read-instant-calendar "2016-11-12T10:00:00-05:00")
        message-1 (Mensaje. "60" "PROCESO DE PRUEBAS" "Test" "ADVERTENCIA")
        message-2 (Mensaje. "70" "PROCESO DE TEST" "Testito" "SALUDO")
        messages (AutorizacionMensajes. (into-array Mensaje [message-1
                                                             message-2]))
        authorization-1 (Autorizacion. "AUTORIZADO"
                                       "123"
                                       stub-date
                                       "PRUEBAS"
                                       "<xml>stub</xml>"
                                       messages)
        authorization-2 (Autorizacion. "NO AUTORIZADO"
                                       "456"
                                       stub-date
                                       "TEST"
                                       "<xml>other stub</xml>"
                                       messages)
        authorizations (RespuestaComprobanteAutorizaciones.
                        (into-array Autorizacion [authorization-1
                                                  authorization-2]))
        response-pojo (RespuestaComprobante. "123" "1" authorizations)]
    (is (= (response response-pojo)
           {:access-code "123"
            :receipt-count "1"
            :authorizations
            [{:status "AUTORIZADO"
              :authorization-number "123"
              :authorization-date (i/read-instant-calendar
                                   "2016-11-12T10:00:00-05:00")
              :environment "PRUEBAS"
              :receipt "<xml>stub</xml>"
              :messages [{:identifier "60"
                          :message "PROCESO DE PRUEBAS"
                          :additional-information "Test"
                          :type "ADVERTENCIA"}
                         {:identifier "70"
                          :message "PROCESO DE TEST"
                          :additional-information "Testito"
                          :type "SALUDO"}]}
             {:status "NO AUTORIZADO"
              :authorization-number "456"
              :authorization-date (i/read-instant-calendar
                                   "2016-11-12T10:00:00-05:00")
              :environment "TEST"
              :receipt "<xml>other stub</xml>"
              :messages [{:identifier "60"
                          :message "PROCESO DE PRUEBAS"
                          :additional-information "Test"
                          :type "ADVERTENCIA"}
                         {:identifier "70"
                          :message "PROCESO DE TEST"
                          :additional-information "Testito"
                          :type "SALUDO"}]}]}))))

(deftest transforms-multiple-receipts-with-no-messages-test
  (let [stub-date (i/read-instant-calendar "2016-11-12T10:00:00-05:00")
        messages (AutorizacionMensajes. (into-array Mensaje []))
        authorization-1 (Autorizacion. "AUTORIZADO"
                                       "123"
                                       stub-date
                                       "PRUEBAS"
                                       "<xml>stub</xml>"
                                       messages)
        authorization-2 (Autorizacion. "NO AUTORIZADO"
                                       "456"
                                       stub-date
                                       "TEST"
                                       "<xml>other stub</xml>"
                                       messages)
        authorizations (RespuestaComprobanteAutorizaciones.
                        (into-array Autorizacion [authorization-1
                                                  authorization-2]))
        response-pojo (RespuestaComprobante. "123" "1" authorizations)]
    (is (= (response response-pojo)
           {:access-code "123"
            :receipt-count "1"
            :authorizations
            [{:status "AUTORIZADO"
              :authorization-number "123"
              :authorization-date (i/read-instant-calendar
                                   "2016-11-12T10:00:00-05:00")
              :environment "PRUEBAS"
              :receipt "<xml>stub</xml>"
              :messages []}
             {:status "NO AUTORIZADO"
              :authorization-number "456"
              :authorization-date (i/read-instant-calendar
                                   "2016-11-12T10:00:00-05:00")
              :environment "TEST"
              :receipt "<xml>other stub</xml>"
              :messages []}]}))))

(deftest transforms-authorizations-with-null-properties-test
  (let [stub-date (i/read-instant-calendar "2016-11-12T10:00:00-05:00")
        message (new Mensaje)
        messages (AutorizacionMensajes. (into-array Mensaje [message]))
        authorization (Autorizacion. "AUTORIZADO"
                                       "123"
                                       stub-date
                                       "PRUEBAS"
                                       "<xml>stub</xml>"
                                       messages)
        authorizations (RespuestaComprobanteAutorizaciones.
                        (into-array Autorizacion [authorization]))
        response-pojo (RespuestaComprobante. "123" "1" authorizations)]
    (is (= (response response-pojo)
           {:access-code "123"
            :receipt-count "1"
            :authorizations [{:status "AUTORIZADO"
                              :authorization-number "123"
                              :authorization-date (i/read-instant-calendar
                                                   "2016-11-12T10:00:00-05:00")
                              :environment "PRUEBAS"
                              :receipt "<xml>stub</xml>"
                              :messages [{:identifier ""
                                          :message ""
                                          :additional-information ""
                                          :type ""}]}]}))))
