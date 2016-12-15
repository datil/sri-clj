(ns datil.sri-clj.generation.transform
  (:require [selmer.parser :refer [render]]))

(selmer.parser/cache-off!)

(defn generate [doc-type data]
  (cond
    (= doc-type :invoice) (render (slurp "resources/factura_v1.1.0.xml") data)))
