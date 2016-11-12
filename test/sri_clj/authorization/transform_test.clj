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
