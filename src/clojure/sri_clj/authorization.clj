(ns sri-clj.authorization
  (require [sri-clj.authorization.service :as s]
           [sri-clj.authorization.transform :as t]
           [sri-clj.config :as c]))

(defn authorize-receipt
  "Consulta la autorización de un comprobante en el SRI."
  [env access-code]
  (->> access-code
       (.autorizacionComprobante (s/service (c/get-url :sri-authorization env)))
       (t/response)))
