(ns datil.sri-clj.authorization
  (require [datil.sri-clj.authorization.service :as s]
           [datil.sri-clj.authorization.transform :as t]
           [datil.sri-clj.config :as c]))

(defn authorize-receipt
  [env access-code]
  (->> access-code
       (.autorizacionComprobante (s/service (c/get-url :sri-authorization env)))
       (t/response)))
