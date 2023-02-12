(ns calc.algo)

;; Source: http://fogus.me/fun/unfix/infix-src.html
;;
;; I believe there is no shame in borrowing code
;; as long as we understand what the code does.
;; Plus, why re-invent the wheel! :)

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
