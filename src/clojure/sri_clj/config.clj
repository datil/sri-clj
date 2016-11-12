(ns sri-clj.config
  (:require [environ.core :as env]))

(def local-conf (read-string (slurp "config/sri_envs.edn")))

(def envs {:sri-validation-test (env/env :sri-validation-test
                                         (:sri-validation-test local-conf))
           :sri-validation-prod (env/env :sri-validation-prod
                                         (:sri-validation-prod local-conf))
           :sri-auhorization-test (env/env :sri-authorization-test
                                           (:sri-authorization-test local-conf))
           :sri-auhorization-prod (env/env :sri-authorization-prod
                                           (:sri-authorization-prod local-conf))})
