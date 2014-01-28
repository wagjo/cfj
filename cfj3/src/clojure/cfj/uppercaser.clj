;; Copyright (C) 2014, Jozef Wagner. All rights reserved.
;;
;; The use and distribution terms for this software are covered by the
;; Eclipse Public License 1.0
;; (http://opensource.org/licenses/eclipse-1.0.php) which can be
;; found in the file epl-v10.html at the root of this distribution.
;;
;; By using this software in any fashion, you are agreeing to be bound
;; by the terms of this license.
;;
;; You must not remove this notice, or any other, from this software.

(ns cfj.uppercaser
  "Uppercaser."
  (:require [clojure.string :as cs]))

;;;; Implementation details

;;;; Public API

(defn uppercase-map
  "Returns a transformed map `m` with all string values uppercased.
   If `trim?` is true (defaults to false), trims string values too."
  ([m] (uppercase-map m false))
  ([m trim?]
     (let [upf (if trim? (comp cs/upper-case cs/trim) cs/upper-case)
           upval #(if (string? %) (upf %) %)
           upmap (fn [[k v]] [k (upval v)])]
       (->> m
            (map upmap)
            (into {})))))

;;;; Testing

(comment

  (uppercase-map {:foo :bar
                  :baz "asdf"
                  2 3
                  "keep me intact" " make me bigger "})
  
  (uppercase-map {:foo :bar
                  :baz "asdf"
                  2 3
                  "keep me intact" " make me bigger "}
                 true)
  
)
