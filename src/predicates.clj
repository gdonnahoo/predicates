(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a] (true? (contains? a-set a))))

(defn pred-and [pred1 pred2]
  (fn [an-elem]
    (cond
     (= (and (pred1 an-elem) (pred2 an-elem)) true) true
     :false false
     )))

(defn pred-or [pred1 pred2]
  (fn [an-elem]
    (cond
     (or (pred1 an-elem) (pred2 an-elem)) true
     :false false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string)
      (= string nil)
      (empty? string)))

(defn has-award? [book award]
  (cond
   (contains? (:awards book) award) true
   :false false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award]
    (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [elem] (= (mod n elem) 0))]
    (not (some pred (range 2 n)))))
;^^
