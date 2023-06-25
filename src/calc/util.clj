(ns calc.util
  "Utility functions for the calc API."
  (:require [clojure.edn :as edn]
            [clojure.string :as str]))

(import 'java.security.MessageDigest
        'java.math.BigInteger)

(defn parse [xs]
  (try (edn/read-string
        (str/replace (str "(" xs ")") #"\(|\)" {"(" "[" ")" "]"}))
       (catch Exception e (Throwable->map e))))

(defn md5 [^String s]
  (let [algorithm (MessageDigest/getInstance "MD5")
        raw (.digest algorithm (.getBytes s))]
    (format "%032x" (BigInteger. 1 raw))))
