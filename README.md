# sri-clj

[![Build Status](https://travis-ci.org/datil/sri-clj.svg?branch=master)](https://travis-ci.org/datil/sri-clj)
[![License](https://img.shields.io/badge/licence-Eclipse%20Public%20License-blue.svg)](https://github.com/datil/sri-clj/blob/master/LICENSE)

`sri-clj` es una librería de funciones escritas en [Clojure](http://www.clojure.org) para la emisión de comprobantes electrónicos en modo `off-line` cumpliendo con el [estándar del Servicio de Rentas Internas de Ecuador](http://www.sri.gob.ec/web/guest/10116).

## Funciones
El proceso de emisión de comprobantes electrónicos (facturas, retenciones, guías de remisión, notas de crédito y notas de débito) consiste en tres pasos principales:

1. Firmado de comprobantes
2. Validación de comprobantes
3. Autorización de comprobantes

## Cómo usarlo
Revisa la [documentación](http://datil.github.com/sri-clj).

## Uso avanzado
### Ejecuta las pruebas

``` shell
$ lein test
```

### Genera la documentación

``` shell
$ lein codox
```

## Colaboradores

* Eduardo Raad (@eraad)

## Licencia

© 2016 Datilmedia S.A.

Distribuido bajo licencia Eclipse Public License versión 1.0 o superior.
