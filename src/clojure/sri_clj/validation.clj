(ns sri-clj.validation
  (:require [sri-clj.validation.service :as s]
            [sri-clj.validation.transform :as t]
            [sri-clj.config :as c]))

(defn validate-receipt
  "Envía el comprobante al SRI para su validación."
  [env xml]
  (->> (.getBytes xml)
       (.validarComprobante (s/service (c/get-url :sri-validation env)))
       (t/response)))
