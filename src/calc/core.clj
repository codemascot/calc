(ns calc.core
  (:require [ring.adapter.jetty :as rj]
            [reitit.ring :as r]
            [muuntaja.core :as m]
            [reitit.ring.middleware.muuntaja :as mu]
            [calc.data :as d])
  (:gen-class))

(def app
  (r/ring-handler
   (r/router
    ["/"
     ["calc" {:get d/get-history
              :post d/eval-exp}]
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
