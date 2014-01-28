# Clojure from Java 3

Example on how to run clojure functions from Java.

## Design

Code in Java wants to access a clojure functions.

Design decisions for this example:
* Java and Clojure code in same project
* Using clojure.lang.RT to dynamically load clojure code and invoke clojure function

## Usage

`lein run`

or `lein uberjar` and then `java -jar cfj3-0.1.0-SNAPSHOT-standalone.jar`

## How it is done

* Clojure code is in `cfj/uppercaser.clj`
* Java code is in `uppercaser/Main.java`

Clojure code is normal clojure, without any interop stuff. There is also no need to AOT any clojure code, so project.clj is simpler.

Java code however must have some interop stuff. Many of it is same for any clojure interop, so it can be put into separate class or library.

This type of interop is slower than previous ones.

## License

Copyright © 2014 Jozef Wagner

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
