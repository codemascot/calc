(ns calc.util
  "Utility functions for the calc API."
  (:require [clojure.edn :as edn]
            [clojure.string :as str]))

(def ops '[- + * /])
(def rank (zipmap ops (iterate inc 1)))
    
(defn infix-to-prefix
  [[a b & [c d & m]]]
  (cond
    (vector? a) (recur (list* (infix-to-prefix a) b c d m))
    (vector? c) (recur (list* a b (infix-to-prefix c) d m))
    (rank b) (if (and d (< (rank b 0) (rank d 0)))
               (recur (list a b (infix-to-prefix (list* c d m))))
               (recur (list* (list b a c) d m)))
    :else a))

(defn parse [xs]
  (infix-to-prefix 
   (edn/read-string
    (str/replace (str "(" xs ")") #"\(|\)" {"(" "[" ")" "]"}))))
