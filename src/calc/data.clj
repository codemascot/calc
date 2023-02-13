(ns calc.data
  (:require [calc.util :as util]
            [calc.algo :as algo]))

(def history (atom {}))

(defn add-to-history [key exp value]
  (swap! history update-in [key] assoc :expression exp :result value :timestamp (quot (System/currentTimeMillis) 1000)))

(defn get-result
  [exp]
  (let [h (keyword (str (util/md5 exp)))]
    (if (contains? @history h)
      (:result (h @history))
      (let [result (eval (algo/infix-to-prefix (util/parse exp)))]
        (add-to-history h exp result)
        result))))

(defn eval-exp [{payload :body-params}]
  (let [p (:expression payload)
        result (get-result p)]
    {:status 200
     :body {:result result}}))

(defn get-history
  [_]
  {:status 200
   :body @history})
