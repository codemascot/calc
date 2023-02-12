(ns calc.core
  (:require [ring.adapter.jetty :as rj]
            [reitit.ring :as r]
            [muuntaja.core :as m]
            [reitit.ring.middleware.muuntaja :as mu]
            [calc.util :as util])
  (:gen-class))

(def history (atom {}))

(defn add-to-history [key exp value]
  (swap! history update-in [key] assoc :expression exp :result value))

(defn get-result
  [exp]
  (let [h (keyword (str (util/md5 exp)))]
    (if (contains? @history h)
      (:result (h @history))
      (let [result (eval (util/parse exp))]
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

(def app
  (r/ring-handler
   (r/router
    ["/"
     ["calc" {:get get-history
              :post eval-exp}]
     ["" (fn [_] {:status 200
                  :body "Nothing Here"})]]
    {:data {:muuntaja m/instance
            :middleware [mu/format-middleware]}})))

(defn start []
  (rj/run-jetty app {:port 3000
                     :join? false}))

(defn -main
  [& args]
  (start))
