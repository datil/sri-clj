(ns datil.sri-clj.validation.service-test
  (:require [clojure.test :refer :all]
            [datil.sri-clj.validation.service :refer :all]
            [datil.sri-clj.config :as c])
  (:import [recepcion.ws.sri.gob.ec
            RecepcionComprobantesOfflineServiceSoapBindingStub]))

(deftest returns-service-class-test
  (is (= (class (service "http://stub-url.com/"))
         RecepcionComprobantesOfflineServiceSoapBindingStub)))

;; TO-DO
;; (deftest sets-service-url-test
;;   (with-redefs [coerce-url (constantly "http://stub-url.com")]
;;     (is (= ()))))
