(ns datil.sri-clj.generation.credit-note-test
  (:require [clojure.test :refer :all]
            [datil.sri-clj.generation.transform :refer [generate]]
            [clj-xpath.core :refer [$x $x:text $x:attrs*]]))

(deftest generates-basic-tax-header
  (let [credit-note (generate
                     :credit-note
                     {:infoTributaria {:ambiente "1"
                                       :tipoEmision "1"
                                       :nombreComercial "nombreComercial0"
                                       :razonSocial "razonSocial0"
                                       :ruc "0000000000001"
                                       :claveAcceso "0000000000000000000000000000000000000000000000000"
                                       :codDoc "01"
                                       :estab "001"
                                       :ptoEmi "001"
                                       :secuencial "000000001"
                                       :dirMatriz "dirMatriz0"}})]
    (are [x y] (= x y)
      ($x:text "/notaCredito/infoTributaria/razonSocial" credit-note) "razonSocial0"
      ($x:text "/notaCredito/infoTributaria/ambiente" credit-note) "1"
      ($x:text "/notaCredito/infoTributaria/tipoEmision" credit-note) "1"
      ($x:text "/notaCredito/infoTributaria/ruc" credit-note) "0000000000001"
      ($x:text "/notaCredito/infoTributaria/claveAcceso" credit-note) "0000000000000000000000000000000000000000000000000"
      ($x:text "/notaCredito/infoTributaria/codDoc" credit-note) "01"
      ($x:text "/notaCredito/infoTributaria/estab" credit-note) "001"
      ($x:text "/notaCredito/infoTributaria/ptoEmi" credit-note) "001"
      ($x:text "/notaCredito/infoTributaria/secuencial" credit-note) "000000001"
      ($x:text "/notaCredito/infoTributaria/dirMatriz" credit-note) "dirMatriz0")))
