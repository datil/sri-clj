(ns sri-clj.validation.config
  (:require [environ.core :as env]))

(def url (clojure.java.io/as-url
          (env/env :sri_validation_url "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl")))
