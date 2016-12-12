(ns datil.sri-clj.generation.transform
  (:require [selmer.parser :refer [render]]))

(selmer.parser/cache-off!)

(defn receipt
  [data]
  (render (slurp "resources/factura_v1.1.0.xml") data))
