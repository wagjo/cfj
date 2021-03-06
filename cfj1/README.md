# Clojure from Java 1

Example on how to run clojure functions from Java.

## Design

Code in Java wants to access a clojure functions.

Design decisions for this example:
* Java and Clojure code in same project
    * AOTed classes can also be put into .jar file and used in non-clojure java project as any other java library
* Using gen-class to generate java class from clojure
    * compile clojure function into a static method

## Usage

`lein run`

or `lein uberjar` and then `java -jar cfj1-0.1.0-SNAPSHOT-standalone.jar`

## How it is done

* Clojure code is in `cfj/uppercaser.clj`
* Java code is in `uppercaser/Main.java`

Clojure code is AOTed (compiled ahead of time) in order to generate java classes. These classes are then used from java code. As calling clojure code from java is nonstandard for leiningen, we have to reverse the compilation in leiningen, so that clojure code is AOTed before java class is compiled.

In `project.clj`
* Specify paths for java and clojure code
* reverse compilation in :prep-tasks
* specify what to AOT in :aot

## License

Copyright © 2014 Jozef Wagner

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
