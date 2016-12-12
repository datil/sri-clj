(ns datil.sri-clj.generation.test-utils
  (:require [clj-xpath.core :refer [$x $x:text $x:attrs*]]))

(defn total-impuesto
  [invoice]
  (map
   (fn [i]
     {:codigo ($x:text "./codigo" i)
      :codigoPorcentaje ($x:text "./codigoPorcentaje" i)
      :baseImponible ($x:text "./baseImponible" i)
      :valor ($x:text "./valor" i)})
   ($x "/factura/infoFactura/totalConImpuestos/totalImpuesto" invoice)))

(defn impuestos-item
  [item]
  (map
   (fn [i]
     {:codigo ($x:text "./codigo" i)
      :codigoPorcentaje ($x:text "./codigoPorcentaje" i)
      :tarifa ($x:text "./tarifa" i)
      :baseImponible ($x:text "./baseImponible" i)
      :valor ($x:text "./valor" i)})
   ($x "./impuestos/impuesto" item)))

(defn detalles-adicionales
  [item]
  (map
   (fn [i]
     {:nombre (first ($x:attrs* "./detAdicional" i :nombre))
      :valor (first ($x:attrs* "./detAdicional" i :valor))})
   ($x "./detallesAdicionales" item)))

(defn items
  [factura]
  (map
   (fn [i]
     {:descripcion ($x:text "./descripcion" i)
      :unidadMedida ($x:text "./unidadMedida" i)
      :cantidad ($x:text "./cantidad" i)
      :precioUnitario ($x:text "./precioUnitario" i)
      :precioSinSubsidio ($x:text "./precioSinSubsidio" i)
      :descuento ($x:text "./descuento" i)
      :detallesAdicionales (detalles-adicionales i)
      :precioTotalSinImpuesto ($x:text "./precioTotalSinImpuesto" i)
      :impuestos (impuestos-item i)})
   ($x "/factura/detalles/detalle" factura)))

(defn info-adicional
  [factura]
  (map
   (fn [i]
     {:nombre (first ($x:attrs* "./campoAdicional" i :nombre))
      :valor ($x:text "./campoAdicional" i)})
   ($x "/factura/infoAdicional" factura)))

(defn pagos
  [factura]
  (map
   (fn [i]
     {:formaPago ($x:text "./formaPago" i)
      :total ($x:text "./total" i)
      :plazo ($x:text "./plazo" i)
      :unidadTiempo ($x:text "./unidadTiempo" i)})
   ($x "/factura/infoFactura/pagos/pago" factura)))

(defn compensaciones
  [factura]
  (map
   (fn [i]
     {:codigo ($x:text "./codigo" i)
      :tarifa ($x:text "./tarifa" i)
      :valor ($x:text "./valor" i)})
   ($x "/factura/infoFactura/compensaciones/compensacion" factura)))

(defn retenciones
  [factura]
  (map
   (fn [i]
     {:codigo ($x:text "./codigo" i)
      :codigoPorcentaje ($x:text "./codigoPorcentaje" i)
      :tarifa ($x:text "./tarifa" i)
      :valor ($x:text "./valor" i)})
   ($x "/factura/retenciones/retencion" factura)))
