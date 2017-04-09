(ns datil.sri-clj.signing.signer
  (:import [ec.facturar SignCLI]))

(defn sign
  [xml pfx-url passwd]
  (let [signature-map (SignCLI/signAction xml pfx-url passwd)]
    {:signed-xml (slurp (.get signature-map "signedXml"))}))
