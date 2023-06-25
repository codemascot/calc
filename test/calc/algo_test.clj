(ns calc.algo-test
  (:require [calc.algo :as a]
            [clojure.test :as t]))

(t/deftest rank-algo-test
  (t/testing "Testing `rank` from algo"
    (t/is (= 1
             (a/rank '-)))
    (t/is (= 2
             (a/rank '+)))
    (t/is (= 3
             (a/rank '*)))
    (t/is (= 4
             (a/rank '/)))))

(t/deftest infix-to-prefix-algo-func-test
  (t/testing "Testing `infix-to-prefix` algo function"
    (t/is (= '(+ 1 2)
             (a/infix-to-prefix [1 '+ 2])))
    (t/is (= '(* (* (* 1 2) (+ 3 (* 4 (- 5 7)))) (- 4 9.3))
             (a/infix-to-prefix [1 '* 2 '* [ 3 '+ 4 '* [ 5 '- 7 ] ] '* [ 4 '- 9.3 ]])))))
