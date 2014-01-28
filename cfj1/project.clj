(defproject cfj1 "0.1.0-SNAPSHOT"
  :description "Clojure from Java 1"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :prep-tasks ["compile" "javac"]
  :aot [cfj.uppercaser]
  :main uppercaser.Main)
