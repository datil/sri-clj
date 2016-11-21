(ns datil.sri-clj.api
  (:require [datil.sri-clj.validation.service :as vs]
            [datil.sri-clj.validation.transform :as vt]
            [datil.sri-clj.authorization.service :as as]
            [datil.sri-clj.authorization.transform :as at]
            [datil.sri-clj.config :as c]))

;;; TO-DO
;;; (defn sign-receipt
;;; [])

(defn validate-receipt
  "Envía un comprobante al SRI para su validación."
  [env xml]
  (->> (.getBytes xml)
       (.validarComprobante (vs/service (c/get-url :sri-validation env)))
       (vt/response)))

(defn authorize-receipt
  "Consulta la autorización de un comprobante en el SRI."
  [env access-code]
  (->> access-code
       (.autorizacionComprobante (as/service (c/get-url :sri-authorization env)))
       (at/response)))
