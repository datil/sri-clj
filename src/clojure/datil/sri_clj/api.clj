(ns datil.sri-clj.api
  "API para emisión de comprobantes electrónicos en Ecuador en modo 'off-line'."
  (:require [datil.sri-clj.validation.service :as vs]
            [datil.sri-clj.validation.transform :as vt]
            [datil.sri-clj.authorization.service :as as]
            [datil.sri-clj.authorization.transform :as at]
            [datil.sri-clj.config :as c]))

;;; TO-DO
;;; (defn sign-receipt
;;; [])

(defn validate-receipt
  "`env` corresponde al ambiente a utilizar: `:test` (ambiente de pruebas) o
  `:prod` (ambiente de producción)

  `xml` es una cadena de texto que contiene la representación XML a validar.

  Envía un comprobante al Servicio de Rentas Internas para su validación.

  Retorna un mapa con todos los campos de la respuesta XML del servicio web del SRI."
  [env xml]
  (->> (.getBytes xml)
       (.validarComprobante (vs/service (c/get-url :sri-validation env)))
       (vt/response)))

(defn authorize-receipt
  "`env` corresponde al ambiente a utilizar: `:test` (ambiente de pruebas) o
  `:prod` (ambiente de producción)

  `access-code` es la clave de acceso correspondiente al comprobante a consultar.

  Consulta la autorización de un comprobante en el Servicio de Renta Internas.

  Retorna un mapa con todos los campos de la respuesta XML del servicio web del SRI."
  [env access-code]
  (->> access-code
       (.autorizacionComprobante (as/service (c/get-url :sri-authorization env)))
       (at/response)))
