(ns sri-clj.config-test
  (:require [clojure.test :refer :all]
            [sri-clj.config :refer :all]))

(deftest returns-correct-env-test
  (with-redefs [envs {:sri-validation {:test "val-test"
                                       :prod "val-prod"}
                      :sri-authorization {:test "aut-test"
                                          :prod "aut-prod"}}]
    (is (= (get-url :sri-validation :test)
           "val-test"))
    (is (= (get-url :sri-authorization :prod)
           "aut-prod"))))
