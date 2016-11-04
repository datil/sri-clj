(ns sri-clj.core-test
  (:require [clojure.test :refer :all]
            [sri-clj.core :refer :all])
  (:import [recepcion.ws.sri.gob.ec Mensaje]
           [recepcion.ws.sri.gob.ec ComprobanteMensajes]
           [recepcion.ws.sri.gob.ec Comprobante]
           [recepcion.ws.sri.gob.ec RespuestaSolicitudComprobantes]
           [recepcion.ws.sri.gob.ec RespuestaSolicitud]))

(defn stub-resp
  []
  (let [mensaje (new Mensaje "35" "DOC INVALIDO" "DESC" "ERROR")
        mensajes (new ComprobanteMensajes (into-array Mensaje [mensaje]))
        comprobante (new Comprobante "12345678910" mensajes)
        comprobantes (new RespuestaSolicitudComprobantes
                          (into-array Comprobante [comprobante]))]
    (new RespuestaSolicitud "DEVUELTA" comprobantes)))

(deftest includes-validation-status-test
  (testing "'status' key is included in the response map"
    (is (= (:status (o->m (stub-resp)))
           "DEVUELTA"))))

(deftest includes-receipts-list-test
  (testing "'receipts' key contains a list of receipts"
    (is (= (count (:receipts (o->m (stub-resp))))
           1))))

(deftest receipts-include-access-code-test
  (testing "each receipt includes an access code'"
    (is (= (:access-code (first (:receipts (o->m (stub-resp)))))
           "12345678910"))))

(deftest receipts-include-messages-test
  (testing "each receipt includes a list of messages"
    (is (= (count (:messages (first (:receipts (o->m (stub-resp))))))
           1))))

(deftest messages-include-identifier-test
  (testing "each message includes an 'identifier' key"
    (is (= (:identifier (first (:messages (first (:receipts (o->m (stub-resp)))))))
           "35"))))

(deftest messages-include-message-test
  (testing "each message includes a 'message' key"
    (is (= (:message (first (:messages (first (:receipts (o->m (stub-resp)))))))
           "DOC INVALIDO"))))

(deftest messages-include-additional-information-test
  (testing "each message includes an 'additional-information' key"
    (is (= (:additional-information (first (:messages (first (:receipts
                                                              (o->m (stub-resp)))))))
           "DESC"))))

(deftest messages-include-type-test
  (testing "each message includes a 'type' key"
    (is (= (:type (first (:messages (first (:receipts (o->m (stub-resp)))))))
           "ERROR"))))

(deftest multiple-messages-are-parsed-test
  (let [message-1 (new Mensaje "35" "DOC INVALIDO" "DESC" "ERROR")
        message-2 (new Mensaje "00" "DOC REPETIDO" "DESC" "ERROR")
        messages (new ComprobanteMensajes (into-array Mensaje [message-1
                                                               message-2]))
        receipt (new Comprobante "12345678910" messages)
        receipts (new RespuestaSolicitudComprobantes
                          (into-array Comprobante [receipt]))
        response (new RespuestaSolicitud "DEVUELTA" receipts)]
    (testing "multiple messages are parsed"
      (is (= (:messages (first (:receipts (o->m response))))
             [{:identifier "35"
               :message "DOC INVALIDO"
               :additional-information "DESC"
               :type "ERROR"}
              {:identifier "00"
               :message "DOC REPETIDO"
               :additional-information "DESC"
               :type "ERROR"}])))))

(deftest supports-empty-messages-test
  (let [messages (new ComprobanteMensajes (into-array Mensaje []))
        receipt (new Comprobante "12345678910" messages)
        receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante [receipt]))
        response (new RespuestaSolicitud "DEVUELTA" receipts)]
    (testing "supports an empty messages array"
      (is (= (o->m response)
             {:status "DEVUELTA"
              :receipts [{:access-code "12345678910"
                          :messages []}]})))))

(deftest supports-empty-receipts-test
  (let [receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante []))
        response (new RespuestaSolicitud "RECIBIDA" receipts)]
    (testing "support an empty receipts array"
      (is (= (o->m response)
             {:status "RECIBIDA" :receipts []})))))
