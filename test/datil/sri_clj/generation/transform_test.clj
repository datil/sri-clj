(ns datil.sri-clj.generation.transform-test
  (:require [clojure.test :refer :all]
            [datil.xml-validation :as xml-val]
            [datil.sri-clj.generation.transform :refer [receipt]]
            [datil.sri-clj.generation.test-utils :as u]
            [clj-xpath.core :refer [$x $x:text]]))

;;   (let [valid-xml? (xml-val/create-validation-fn
;;                     "resources/Factura_V_1_1_0.xsd")]
;;     (is (= (valid-xml? (receipt :v1.1.0 basic-v110))
;;            true))))

(deftest generates-invoice-test
  (let [invoice (receipt
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
                                   :dirMatriz "dirMatriz0"}
                  :infoFactura {:fechaEmision "01/01/2000"
                                :dirEstablecimiento "dirEstablecimiento0"
                                :contribuyenteEspecial "0000"
                                :obligadoContabilidad "SI"
                                :comercioExterior "EXPORTADOR"
                                :incoTermFactura "CIF"
                                :lugarIncoTerm "GUAYAQUIL"
                                :paisOrigen "593"
                                :puertoEmbarque "GUAYAQUIL"
                                :puertoDestino "CHINA"
                                :paisDestino "593"
                                :paisAdquisicion "593"
                                :tipoIdentificacionComprador "04"
                                :guiaRemision "001-001-000000000"
                                :razonSocialComprador "razonSocialComprador0"
                                :identificacionComprador "identificacionCompra"
                                :direccionComprador "direccionComprador0"
                                :totalSinImpuestos "50.00"
                                :totalSubsidio "0.00"
                                :totalDescuento "0.00"
                                :totalConImpuestos [{:codigo "2"
                                                     :codigoPorcentaje "0"
                                                     :baseImponible "50.00"
                                                     :valor "50.00"}
                                                    {:codigo "2"
                                                     :codigoPorcentaje "0"
                                                     :baseImponible "50.00"
                                                     :valor "50.00"}]
                                :propina "10.00"
                                :compensaciones [{:codigo "0"
                                                  :tarifa "0.12"
                                                  :valor "10.00"}]
                                :fleteInternacional "1000.00"
                                :seguroInternacional "200.00"
                                :gastosAduaneros "800.00"
                                :gastosTransporteOtros "350.00"
                                :importeTotal "50.00"
                                :moneda "DOLAR"
                                :pagos [{:formaPago "01"
                                         :total "10.00"
                                         :plazo "2"
                                         :unidadTiempo "10"}]
                                :valorRetIva "0.00"
                                :valorRetRenta "0.00"}
                  :detalles [{:descripcion "Prueba"
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
                                           :valor "123456"}]}]
                  :retenciones [{:codigo "0"
                                 :codigoPorcentaje "0"
                                 :tarifa "0.01"
                                 :valor "0.10"}]
                  :infoAdicional [{:nombre "nombre"
                                   :valor "valor"}]})]
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
      ($x:text "/factura/infoTributaria/dirMatriz" invoice) "dirMatriz0"
      ($x:text "/factura/infoFactura/fechaEmision" invoice) "01/01/2000"
      ($x:text "/factura/infoFactura/tipoIdentificacionComprador" invoice) "04"
      ($x:text "/factura/infoFactura/razonSocialComprador" invoice) "razonSocialComprador0"
      ($x:text "/factura/infoFactura/identificacionComprador" invoice) "identificacionCompra"
      ($x:text "/factura/infoFactura/totalSinImpuestos" invoice) "50.00"
      ($x:text "/factura/infoFactura/propina" invoice) "10.00"
      ($x:text "/factura/infoFactura/totalSubsidio" invoice) "0.00"
      ($x:text "/factura/infoFactura/totalDescuento" invoice) "0.00"
      (u/total-impuesto invoice) '({:codigo "2"
                                    :codigoPorcentaje "0"
                                    :baseImponible "50.00"
                                    :valor "50.00"}
                                   {:codigo "2"
                                    :codigoPorcentaje "0"
                                    :baseImponible "50.00"
                                    :valor "50.00"})
      (u/compensaciones invoice) '({:codigo "0"
                                    :tarifa "0.12"
                                    :valor "10.00"})
      ($x:text "/factura/infoFactura/fleteInternacional" invoice) "1000.00"
      ($x:text "/factura/infoFactura/seguroInternacional" invoice) "200.00"
      ($x:text "/factura/infoFactura/gastosAduaneros" invoice) "800.00"
      ($x:text "/factura/infoFactura/gastosTransporteOtros" invoice) "350.00"
      ($x:text "/factura/infoFactura/importeTotal" invoice) "50.00"
      ($x:text "/factura/infoFactura/moneda" invoice) "DOLAR"
      (u/pagos invoice) '({:formaPago "01"
                           :total "10.00"
                           :plazo "2"
                           :unidadTiempo "10"})
      ($x:text "/factura/infoFactura/valorRetIva" invoice) "0.00"
      ($x:text "/factura/infoFactura/valorRetRenta" invoice) "0.00"
      (u/items invoice) '({:descripcion "Prueba"
                           :unidadMedida "Kilos"
                           :cantidad "10.00"
                           :precioUnitario "1.00"
                           :precioSinSubsidio "2.00"
                           :descuento "5.00"
                           :precioTotalSinImpuesto "150000"
                           :detallesAdicionales [{:nombre "nombre"
                                                  :valor "valor"}]
                           :impuestos [{:codigo "2"
                                        :codigoPorcentaje "3"
                                        :tarifa "5"
                                        :baseImponible "212322"
                                        :valor "123456"}]})
      ($x:text "/factura/infoTributaria/nombreComercial" invoice) "nombreComercial0"
      ($x:text "/factura/infoFactura/dirEstablecimiento" invoice) "dirEstablecimiento0"
      ($x:text "/factura/infoFactura/contribuyenteEspecial" invoice) "0000"
      ($x:text "/factura/infoFactura/obligadoContabilidad" invoice) "SI"
      ($x:text "/factura/infoFactura/comercioExterior" invoice) "EXPORTADOR"
      ($x:text "/factura/infoFactura/incoTermFactura" invoice) "CIF"
      ($x:text "/factura/infoFactura/lugarIncoTerm" invoice) "GUAYAQUIL"
      ($x:text "/factura/infoFactura/paisOrigen" invoice) "593"
      ($x:text "/factura/infoFactura/puertoEmbarque" invoice) "GUAYAQUIL"
      ($x:text "/factura/infoFactura/puertoDestino" invoice) "CHINA"
      ($x:text "/factura/infoFactura/paisDestino" invoice) "593"
      ($x:text "/factura/infoFactura/paisAdquisicion" invoice) "593"
      ($x:text "/factura/infoFactura/guiaRemision" invoice) "001-001-000000000"
      ($x:text "/factura/infoFactura/direccionComprador" invoice) "direccionComprador0"
      (u/info-adicional invoice) '({:nombre "nombre"
                                    :valor "valor"})
      (u/retenciones invoice) '({:codigo "0"
                                 :codigoPorcentaje "0"
                                 :tarifa "0.01"
                                 :valor "0.10"}))))
