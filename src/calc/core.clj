(ns calc.core
  (:require [ring.adapter.jetty :as rj]
            [reitit.ring :as r]
            [muuntaja.core :as m]
            [reitit.ring.middleware.muuntaja :as mu]
            [calc.util :as util]
            )
  (:gen-class))

(defn eval-exp [{payload :body-params}]
  (let [p (:expression payload)
        result (eval (util/parse p))]
    {:status 200
     :body {:result result}}))

(def app
  (r/ring-handler
   (r/router
    ["/"
     ["calc" {:post eval-exp}]
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
