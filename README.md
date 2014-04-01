# prime-numbers

A Clojure library designed to generate and test prime numbers.

## Usage

(ns example
  (:require [blackyblack.primes.core :as primes]))

(primes/prime? x) ;to test number for prime.
(take 1 primes/prime-numbers) ;to make first prime number.
(primes/divisible-by? x 2) ;like even?
(primes/factorize x) ;take a set of prime factors of x

## License

Copyright © 2014

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.