(ns datil.sri-clj.generation.invoice-test
  (:require [clojure.test :refer :all]
            [datil.sri-clj.generation.transform :refer [generate]]
            [clj-xpath.core :refer [$x $x:text $x:attrs*]]))

;;   (let [valid-xml? (xml-val/create-validation-fn
;;                     "resources/Factura_V_1_1_0.xsd")]
;;     (is (= (valid-xml? (receipt :v1.1.0 basic-v110))
;;            true))))

(deftest generates-basic-tax-header
  (let [invoice (generate
                 :invoice
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
      ($x:text "/factura/infoTributaria/razonSocial" invoice) "razonSocial0"
      ($x:text "/factura/infoTributaria/ambiente" invoice) "1"
      ($x:text "/factura/infoTributaria/tipoEmision" invoice) "1"
      ($x:text "/factura/infoTributaria/ruc" invoice) "0000000000001"
      ($x:text "/factura/infoTributaria/claveAcceso" invoice) "0000000000000000000000000000000000000000000000000"
      ($x:text "/factura/infoTributaria/codDoc" invoice) "01"
      ($x:text "/factura/infoTributaria/estab" invoice) "001"
      ($x:text "/factura/infoTributaria/ptoEmi" invoice) "001"
      ($x:text "/factura/infoTributaria/secuencial" invoice) "000000001"
      ($x:text "/factura/infoTributaria/dirMatriz" invoice) "dirMatriz0")))

(deftest generates-basic-invoice-headers-test
  (let [invoice (generate
                 :invoice
                 {:infoFactura
                  {:fechaEmision "01/01/2000"
                   :tipoIdentificacionComprador "04"
                   :razonSocialComprador "razonSocialComprador0"
                   :identificacionComprador "identificacionCompra"
                   :totalSinImpuestos "50.00"
                   :totalDescuento "0.00"
                   :totalConImpuestos [{:codigo "2"
                                        :codigoPorcentaje "0"
                                        :baseImponible "50.00"
                                        :valor "50.00"}
                                       {:codigo "2"
                                        :codigoPorcentaje "0"
                                        :baseImponible "50.00"
                                        :valor "50.00"}]
                   :importeTotal "50.00"}})]
    (are [x y] (= x y)
      ($x:text "/factura/infoFactura/fechaEmision" invoice) "01/01/2000"
      ($x:text "/factura/infoFactura/tipoIdentificacionComprador" invoice) "04"
      ($x:text "/factura/infoFactura/razonSocialComprador" invoice) "razonSocialComprador0"
      ($x:text "/factura/infoFactura/identificacionComprador" invoice) "identificacionCompra"
      ($x:text "/factura/infoFactura/totalSinImpuestos" invoice) "50.00"
      ($x:text "/factura/infoFactura/totalDescuento" invoice) "0.00"
      (map
       (fn [i]
         {:codigo ($x:text "./codigo" i)
          :codigoPorcentaje ($x:text "./codigoPorcentaje" i)
          :baseImponible ($x:text "./baseImponible" i)
          :valor ($x:text "./valor" i)})
       ($x "/factura/infoFactura/totalConImpuestos/totalImpuesto" invoice)) '({:codigo "2"
                                                                               :codigoPorcentaje "0"
                                                                               :baseImponible "50.00"
                                                                               :valor "50.00"}
                                                                              {:codigo "2"
                                                                               :codigoPorcentaje "0"
                                                                               :baseImponible "50.00"
                                                                               :valor "50.00"})
      ($x:text "/factura/infoFactura/importeTotal" invoice) "50.00")))

(deftest generates-extended-invoice-headers-test
  (let [invoice (generate
                 :invoice
                 {:infoFactura
                  {:dirEstablecimiento "dirEstablecimiento0"
                   :contribuyenteEspecial "0000"
                   :obligadoContabilidad "SI"
                   :guiaRemision "001-001-000000000"
                   :direccionComprador "direccionComprador0"
                   :propina "10.00"
                   :moneda "DOLAR"}})]
    (are [x y] (= x y)
      ($x:text "/factura/infoFactura/dirEstablecimiento" invoice) "dirEstablecimiento0"
      ($x:text "/factura/infoFactura/contribuyenteEspecial" invoice) "0000"
      ($x:text "/factura/infoFactura/obligadoContabilidad" invoice) "SI"
      ($x:text "/factura/infoFactura/guiaRemision" invoice) "001-001-000000000"
      ($x:text "/factura/infoFactura/direccionComprador" invoice) "direccionComprador0"
      ($x:text "/factura/infoFactura/propina" invoice) "10.00"
      ($x:text "/factura/infoFactura/moneda" invoice) "DOLAR")))

(deftest generates-export-invoice-fields-test
  (let [invoice (generate
                 :invoice
                 {:infoFactura
                  {:comercioExterior "EXPORTADOR"
                   :incoTermFactura "CIF"
                   :lugarIncoTerm "GUAYAQUIL"
                   :paisOrigen "593"
                   :puertoEmbarque "GUAYAQUIL"
                   :puertoDestino "CHINA"
                   :paisDestino "593"
                   :paisAdquisicion "593"
                   :fleteInternacional "1000.00"
                   :seguroInternacional "200.00"
                   :gastosAduaneros "800.00"
                   :gastosTransporteOtros "350.00"}
                  :detalles [{:unidadMedida "Kilos"}]})]
    (are [x y] (= x y)
      ($x:text "/factura/infoFactura/comercioExterior" invoice) "EXPORTADOR"
      ($x:text "/factura/infoFactura/incoTermFactura" invoice) "CIF"
      ($x:text "/factura/infoFactura/lugarIncoTerm" invoice) "GUAYAQUIL"
      ($x:text "/factura/infoFactura/paisOrigen" invoice) "593"
      ($x:text "/factura/infoFactura/puertoEmbarque" invoice) "GUAYAQUIL"
      ($x:text "/factura/infoFactura/puertoDestino" invoice) "CHINA"
      ($x:text "/factura/infoFactura/paisDestino" invoice) "593"
      ($x:text "/factura/infoFactura/paisAdquisicion" invoice) "593"
      (map
       (fn [i] {:unidadMedida ($x:text "./unidadMedida" i)})
       ($x "/factura/detalles/detalle" invoice)) '({:unidadMedida "Kilos"}))))

(deftest generates-subsidy-fields-test
  (let [invoice (generate
                 :invoice
                 {:infoFactura {:totalSubsidio "0.00"}
                  :detalles [{:precioSinSubsidio "2.00"}]})]
    ($x:text "/factura/infoFactura/totalSubsidio" invoice) "0.00"
    (map
     (fn [i]
       {:precioSinSubsidio ($x:text "./precioSinSubsidio" i)})
     ($x "/factura/detalles/detalle" invoice)) '({:precioSinSubsidio "2.00"})))

(deftest generates-payment-fields-test
  (let [invoice (generate
                 :invoice
                 {:infoFactura
                  {:pagos [{:formaPago "01"
                            :total "10.00"
                            :plazo "2"
                            :unidadTiempo "10"}]
                   :valorRetIva "0.00"
                   :valorRetRenta "0.00"}})]
    (are [x y] (= x y)
      ($x:text "/factura/infoFactura/valorRetIva" invoice) "0.00"
      ($x:text "/factura/infoFactura/valorRetRenta" invoice) "0.00"
      (map
       (fn [i]
         {:formaPago ($x:text "./formaPago" i)
          :total ($x:text "./total" i)
          :plazo ($x:text "./plazo" i)
          :unidadTiempo ($x:text "./unidadTiempo" i)})
       ($x "/factura/infoFactura/pagos/pago" invoice)) '({:formaPago "01"
                                                          :total "10.00"
                                                          :plazo "2"
                                                          :unidadTiempo "10"}))))

(deftest generates-compensation-fields-test
  (let [invoice (generate
                 :invoice
                 {:infoFactura
                  {:compensaciones [{:codigo "0"
                                     :tarifa "0.12"
                                     :valor "10.00"}]}})]
    (are [x y] (= x y)
      (map
       (fn [i]
         {:codigo ($x:text "./codigo" i)
          :tarifa ($x:text "./tarifa" i)
          :valor ($x:text "./valor" i)})
       ($x "/factura/infoFactura/compensaciones/compensacion" invoice))  '({:codigo "0"
                                                                            :tarifa "0.12"
                                                                            :valor "10.00"}))))

(deftest generates-items-test
  (let [invoice (generate
                 :invoice
                 {:detalles [{:descripcion "Prueba"
                              :cantidad "10.00"
                              :precioUnitario "1.00"
                              :unidadMedida "Kilos"
                              :precioSinSubsidio "2.00"
                              :descuento "5.00"
                              :precioTotalSinImpuesto "150000"
                              :detallesAdicionales [{:nombre "nombre"
                                                     :valor "valor"}]
                              :impuestos [{:codigo "2"
                                           :codigoPorcentaje "3"
                                           :tarifa "5"
                                           :baseImponible "212322"
                                           :valor "123456"}]}]})]
    (are [x y] (= x y)
      (map
       (fn [item]
         {:descripcion ($x:text "./descripcion" item)
          :unidadMedida ($x:text "./unidadMedida" item)
          :cantidad ($x:text "./cantidad" item)
          :precioUnitario ($x:text "./precioUnitario" item)
          :precioSinSubsidio ($x:text "./precioSinSubsidio" item)
          :descuento ($x:text "./descuento" item)
          :precioTotalSinImpuesto ($x:text "./precioTotalSinImpuesto" item)
          :impuestos (map
                      (fn [tax]
                        {:codigo ($x:text "./codigo" tax)
                         :codigoPorcentaje ($x:text "./codigoPorcentaje" tax)
                         :tarifa ($x:text "./tarifa" tax)
                         :baseImponible ($x:text "./baseImponible" tax)
                         :valor ($x:text "./valor" tax)})
                      ($x "./impuestos/impuesto" item))})
       ($x "/factura/detalles/detalle" invoice)) '({:descripcion "Prueba"
                                                    :unidadMedida "Kilos"
                                                    :cantidad "10.00"
                                                    :precioUnitario "1.00"
                                                    :precioSinSubsidio "2.00"
                                                    :descuento "5.00"
                                                    :precioTotalSinImpuesto "150000"
                                                    :impuestos [{:codigo "2"
                                                                 :codigoPorcentaje "3"
                                                                 :tarifa "5"
                                                                 :baseImponible "212322"
                                                                 :valor "123456"}]}))))

(deftest generates-additional-info-test
  (let [invoice (generate
                 :invoice {:infoAdicional [{:nombre "nombre"
                                            :valor "valor"}]})]
    (are [x y] (= x y)
      (map
       (fn [i]
         {:nombre (first ($x:attrs* "./campoAdicional" i :nombre))
          :valor ($x:text "./campoAdicional" i)})
       ($x "/factura/infoAdicional" invoice)) '({:nombre "nombre"
                                                 :valor "valor"}))))

(deftest generates-withholdings-test
  (let [invoice (generate
                 :invoice
                 {:retenciones [{:codigo "0"
                                 :codigoPorcentaje "0"
                                 :tarifa "0.01"
                                 :valor "0.10"}]})]
    (are [x y] (= x y)
      (map
       (fn [i]
         {:codigo ($x:text "./codigo" i)
          :codigoPorcentaje ($x:text "./codigoPorcentaje" i)
          :tarifa ($x:text "./tarifa" i)
          :valor ($x:text "./valor" i)})
       ($x "/factura/retenciones/retencion" invoice))  '({:codigo "0"
                                                          :codigoPorcentaje "0"
                                                          :tarifa "0.01"
                                                          :valor "0.10"}))))
