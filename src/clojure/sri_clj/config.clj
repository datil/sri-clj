(ns sri-clj.config
  (:require [environ.core :as env]))

(def local-conf (read-string (slurp "config/sri_envs.edn")))

(def envs {:sri-validation {:test (env/env :sri-validation-test
                                           (:sri-validation-test local-conf))
                            :prod (env/env :sri-validation-prod
                                           (:sri-validation-prod local-conf))}
           :sri-authorization {:test (env/env :sri-authorization-test
                                              (:sri-authorization-test local-conf))
                               :prod (env/env :sri-authorization-prod
                                              (:sri-authorization-prod local-conf))}})

(defn get-url
  [service env]
  (-> envs
      (get service)
      (get env)))
