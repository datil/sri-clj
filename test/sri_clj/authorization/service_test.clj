(ns sri-clj.authorization.service-test
  (:require [clojure.test :refer :all]
            [sri-clj.authorization.service :refer :all]
            [sri-clj.config :as c])
  (import [autorizacion.ws.sri.gob.ec
           AutorizacionComprobantesOfflineServiceSoapBindingStub]))

(deftest returns-service-class-test
  (is (= (class (service "http://stub-url.com/"))
         AutorizacionComprobantesOfflineServiceSoapBindingStub)))