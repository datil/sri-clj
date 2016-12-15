(ns datil.sri-clj.generation.transform
  (:require [selmer.parser :refer [render]]))

(selmer.parser/cache-off!)

(defn render-tpl
  [tmpl data]
  (render (slurp tmpl) data))

(defn generate [doc-type data]
  (cond
    (= doc-type :invoice) (render-tpl "resources/factura_v1.1.0.xml" data)
    (= doc-type :credit-note) (render-tpl "resources/notacredito_v1.1.0.xml" data)))
