(ns sri-clj.core-test
  (:require [clojure.test :refer :all]
            [sri-clj.core :refer :all])
  (:import [recepcion.ws.sri.gob.ec Mensaje]
           [recepcion.ws.sri.gob.ec ComprobanteMensajes]
           [recepcion.ws.sri.gob.ec Comprobante]
           [recepcion.ws.sri.gob.ec RespuestaSolicitudComprobantes]
           [recepcion.ws.sri.gob.ec RespuestaSolicitud]))

(deftest transforms-response-with-no-receipts-test
  (let [receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante []))
        response (new RespuestaSolicitud "RECIBIDA" receipts)]
    (is (= (validation-response response)
           {:status "RECIBIDA"
            :receipts []}))))

(deftest transforms-single-receipt-and-no-messages-test
  (let [messages (new ComprobanteMensajes (into-array Mensaje []))
        receipt (new Comprobante "12345678910" messages)
        receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante [receipt]))
        response (new RespuestaSolicitud "RECHAZADA" receipts)]
    (is (= (validation-response response)
           {:status "RECHAZADA"
            :receipts [{:access-code "12345678910"
                        :messages []}]}))))

(deftest transforms-single-receipt-and-one-message-test
  (let [message (new Mensaje "35" "DOC INVALIDO" "DESC" "ERROR")
        messages (new ComprobanteMensajes (into-array Mensaje [message]))
        receipt (doto (new Comprobante)
                  (.setClaveAcceso "12345678910")
                  (.setMensajes messages))
        receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante [receipt]))
        response (new RespuestaSolicitud "RECHAZADA" receipts)]
    (is (= (validation-response response)
           {:status "RECHAZADA"
            :receipts [{:access-code "12345678910"
                        :messages [{:identifier "35"
                                    :message "DOC INVALIDO"
                                    :additional-information "DESC"
                                    :type "ERROR"}]}]}))))

(deftest transforms-single-receipt-with-multiple-messages-test
  (let [message-1 (new Mensaje "35" "DOC INVALIDO" "DESC" "ERROR")
        message-2 (new Mensaje "00" "DOC REPETIDO" "DESC" "ERROR")
        messages (new ComprobanteMensajes (into-array Mensaje [message-1
                                                               message-2]))
        receipt (new Comprobante "12345678910" messages)
        receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante [receipt]))
        response (new RespuestaSolicitud "DEVUELTA" receipts)]
    (is (= (validation-response response)
           {:status "DEVUELTA"
            :receipts [{:access-code "12345678910"
                        :messages [{:identifier "35"
                                    :message "DOC INVALIDO"
                                    :additional-information "DESC"
                                    :type "ERROR"}
                                   {:identifier "00"
                                    :message "DOC REPETIDO"
                                    :additional-information "DESC"
                                    :type "ERROR"}]}]}))))

(deftest transforms-multiple-receipts-with-no-messages-test
  (let [messages (new ComprobanteMensajes (into-array Mensaje []))
        receipt-1 (new Comprobante "12345678910" messages)
        receipt-2 (new Comprobante "12345678911" messages)
        receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante [receipt-1
                                               receipt-2]))
        response (new RespuestaSolicitud "RECHAZADA" receipts)]
    (is (= (validation-response response)
           {:status "RECHAZADA"
            :receipts [{:access-code "12345678910"
                        :messages []}
                       {:access-code "12345678911"
                        :messages []}]}))))

(deftest transforms-multiple-receipts-with-multiple-messages-test
  (let [message-1 (new Mensaje "35" "DOC INVALIDO" "DESC" "ERROR")
        message-2 (new Mensaje "00" "DOC REPETIDO" "DESC" "ERROR")
        messages (new ComprobanteMensajes (into-array Mensaje [message-1
                                                               message-2]))
        receipt-1 (new Comprobante "12345678910" messages)
        receipt-2 (new Comprobante "12345678911" messages)
        receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante [receipt-1
                                               receipt-2]))
        response (new RespuestaSolicitud "RECHAZADA" receipts)]
    (is (= (validation-response response)
           {:status "RECHAZADA"
            :receipts [{:access-code "12345678910"
                        :messages [{:identifier "35"
                                    :message "DOC INVALIDO"
                                    :additional-information "DESC"
                                    :type "ERROR"}
                                   {:identifier "00"
                                    :message "DOC REPETIDO"
                                    :additional-information "DESC"
                                    :type "ERROR"}]}
                       {:access-code "12345678911"
                        :messages [{:identifier "35"
                                    :message "DOC INVALIDO"
                                    :additional-information "DESC"
                                    :type "ERROR"}
                                   {:identifier "00"
                                    :message "DOC REPETIDO"
                                    :additional-information "DESC"
                                    :type "ERROR"}]}]}))))

(deftest transforms-receipts-with-messages-with-null-properties-test
  (let [message (new Mensaje)
        messages (new ComprobanteMensajes (into-array Mensaje [message]))
        receipt (new Comprobante "12345678910" messages)
        receipts (new RespuestaSolicitudComprobantes
                      (into-array Comprobante [receipt]))
        response (new RespuestaSolicitud "DEVUELTA" receipts)]
    (is (= (validation-response response)
           {:status "DEVUELTA"
            :receipts [{:access-code "12345678910"
                        :messages [{:identifier ""
                                    :message ""
                                    :additional-information ""
                                    :type ""}]}]}))))
