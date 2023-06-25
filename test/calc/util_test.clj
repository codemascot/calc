(ns calc.util-test
  (:require [clojure.test :as t]
            [calc.util :as u]))

(t/deftest parse-util-func-test
  (t/testing "Testing `parse` utility function"
    (t/is (= [1 '+ 2]
             (u/parse "1 + 2")))
    ;; TODO: Better to use `thrown?` or `:type` value
    (t/is (= "Invalid number: 1+"
             (:message (first (:via (u/parse "1+ 2"))))))))

(t/deftest md5-util-func-test
  (t/testing "Testing `md5` utility function"
    (t/is (= "536788f4dbdffeecfbb8f350a941eea3"
             (u/md5 "testString")))))
