(ns datil.sri-clj.authorization.service-test
  (:require [clojure.test :refer :all]
            [datil.sri-clj.authorization.service :refer :all]
            [datil.sri-clj.config :as c])
  (:import [autorizacion.ws.sri.gob.ec
            AutorizacionComprobantesOfflineServiceSoapBindingStub]))

(deftest returns-service-class-test
  (is (= (class (service "http://stub-url.com/"))
         AutorizacionComprobantesOfflineServiceSoapBindingStub)))

;; TO-DO
;; (deftest sets-service-url-test
;;   (with-redefs [coerce-url (constantly "http://stub-url.com")]
;;     (is (= ()))))
