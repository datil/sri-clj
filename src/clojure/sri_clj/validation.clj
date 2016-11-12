(ns sri-clj.validation
  (:require [environ.core :as e]
            [sri-clj.validation.transform :as t]
            [sri-clj.validation.service :as s]
            [sri-clj.validation.config :as c]))

(defn validate-receipt
  [xml]
  (->> (.getBytes xml)
       (.validarComprobante (s/service c/url))
       (t/response)))
