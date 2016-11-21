(ns datil.sri-clj.validation
  (:require [datil.sri-clj.validation.service :as s]
            [datil.sri-clj.validation.transform :as t]
            [datil.sri-clj.config :as c]))

(defn validate-receipt
  "Envía el comprobante al SRI para su validación."
  [env xml]
  (->> (.getBytes xml)
       (.validarComprobante (s/service (c/get-url :sri-validation env)))
       (t/response)))
