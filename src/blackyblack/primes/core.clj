(ns blackyblack.primes.core)

(defn divisible-by? 
  "This returns true if 'x' is divisible by 'y', returns false otherwise"
  [x y]
  (zero? (rem x y)))

(declare prime-numbers)
(defn prime?
  "Test for prime number"
  [x]
  (not-any?
    #(divisible-by? x %)
    (take-while #(<= (* % %) x) prime-numbers)))

(defn- prime-helper
  "Helper to get lazy list of prime numbers."
  [x]
  (if (prime? x)
    (cons x (lazy-seq (prime-helper (inc x))))
    (recur (inc x))))

(def prime-numbers
  "Lazy list of prime numbers. Mention forward declaration in 'prime?' function."
  (cons 2 (lazy-seq (prime-helper 3))))

(defn- factorize-helper
  "Factorize integer 'x' by looking first available divisor prime. If such prime found
  add it into list 'y' and try again with x / prime. Search stops when divisor is greater than x."
  [x y]
  (let [res (first (drop-while
    #(not-any? true? [(divisible-by? x %) (> % x)])
    prime-numbers))]
      (if (> res x)
        (set y)
        (recur (/ x res) (cons res y)))))

(defn factorize
  "Get prime factors of integer. Returns set."
  [x]
  (factorize-helper x []))