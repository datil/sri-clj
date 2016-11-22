# Introducción

## Configura la dependencia en tu proyecto

```clojure
[sri-clj "1.0.0"]
```

## Ambientes del SRI

`sri-clj` viene pre-configurada con los ambientes de pruebas y producción del SRI. Al llamar a cada función debes especificar el ambiente que quieres utilizar: `:test` (pruebas) o `:prod` (producción).

Si quieres usar tu propio servicio web de validación y autorización (por ejemplo en el caso de un _mock_), debes configurar las siguientes variables de ambiente:

| Variable  | Ejemplo  |
|---|---|
| SRI_VALIDATION_TEST  | http://mimock:8080/validate  |
| SRI_AUTHORIZATION_TEST  | http://mimock:8080/authorize  |
| SRI_VALIDATION_PROD  | http://mimock:8080/validate  |
| SRI_AUTHORIZATION_PROD  | http://mimock:8080/authorize  |

## Firmado electrónico
El primer paso de la emisión de un comprobante es el firmado electrónico.

``` clojure
;;; TO-DO
```

## Validación en el SRI
Envía el documento firmado al SRI para su validación.

``` clojure
(require '[sri-clj.validation :as val])
(val/validate-receipt :test (slurp ("resources/factura_firmada.xml")))
; -> {:status "DEVUELTA",
;     :receipts [{:access-code "1410201601099271255400110010020000000091994726610",
;     :messages [{:type "ERROR",
;                 :additional-information "",
;                 :identifier "43",
;                 :message "CLAVE ACCESO REGISTRADA"}]}]}
```

## Autorización de comprobantes
Consulta el estado de autorización del comprobante en el SRI.

``` clojure
(require '[sri-clj.authorization :as aut])
(aut/authorize-receipt :test (slurp ("resources/factura_recibida.xml")))
; -> {:access-code "0503201201176001321000110010030009900641234567814"
;     :receipt-count "1"
;     :authorizations [{:status "AUTORIZADO"
;                       :authorization-number "0503201201176001321000110010030009900641234567814"
;                       :authorization-date "2012-03-05T16:57:34.997-05:00"
;                       :environment "PRUEBAS"
;                       :receipt "<![CDATA[<?xml version="1.0" encoding="UTF-8"?> <factura id="comprobante" version="1.0.0">...</factura>]]>"
;                       :messages [{:identifier "60"
;                                   :message "PROCESO DE PRUEBAS"
;                                   :type "ADVERTENCIA"}]}]}
```
