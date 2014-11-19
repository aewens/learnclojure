; zero

(println "Hello, World!")

(+ 1 2 3) ; 6

(if true
    "Yes"
    "No")
(if false
    (do (+ 1 2)
        "True")
    (do (- 2 1)
        "False"))
; 1
; "False"
        
; when = if + do
(when true
    (* 1 0)
    "As well as this")
; 0
; "As well as this"

(def one 1)
(def intensity :mild)
(if (= intensity :mild)
    "Oh no!"
    "Holy cow Batman!") ; "Oh no!"
    

(= one 1) ; true
(nil? 1) ; false
(nil? nil) ; true
(and true false) ; false
(or true false) ; true
(not true) ; false

(def number 42)
(def decimal 3.14) ; float
(def ratio 1/2)
(def string "aewens")

(str string ", aka Austin Ewens") ; "aewens, aka Austin Ewens"

; maps
(def mapp {:a 1
           :b "bee"
           :c []
           :d {:e + :f false}})
(get mapp :a) ; 1
(get-in mapp [:d :f]) ; false
(mapp :b) ; "bee"
(:b mapp) ; "bee"
(((mapp :d) :e) 1 2) ; (+ 1 2) => 3
(:g mapp "nope") ; "nope"
(def b-map (hash-map :one 1 :two 2))
(= b-map {:one 1 :two 2}) ; true

; vectors
(def vect [1 "2" {:null nil}])
(get vect 0) ; 1
(= (vector 1 2 3) [1 2 3]) ; true
(conj [1 2 3] 4) ; [1 2 3 4]

; lists
(def listy '(1 2 3)) ; (1 2 3)
(get listy 0) ; nil, doesn't work
(= (list 1 2 3) listy) ; true
(conj listy 4) ; (4 1 2 3)

; sets
(def sett #{"aewens" "Austin Ewens" -1 :a})
(= sett (conj sett :a)) ; true
(get sett -1) ; -1
(:a sett) ; :a
(get sett 2) ; nil
(= #{1 "b" true} (set [1 "b" true])) ; true
(= #{1 "b" true} (hash-set 1 "b" true)) ; true
(sorted-set 2 3 1) ; #{1 2 3}

; quotes
(identity 'value) ; value
(def three [1 2 3])
(def qthree 'three)
(first three) ; 1
(eval qthree) ; [1 2 3]
(second (eval qthree)) ; 2

; random stuff
(or true (/ 1 0)) ; lazy eval!!!
(inc 1.5) ; 2.5
(map inc [1 2 3 4]) ; (2 3 4 5)

; functions
(defn sqre
    "this a square function for x" ; docstring
    [x] ; args
    (* x x)) ; expression
        
(sqre 5) ; 25
    
(defn multi-arity
    ([a b c]
        (map inc (vector a b c)))
    ([a b]
        (map inc (vector a b)))
    ([a]
        (inc a)))
        
(multi-arity 1 2 3) ; (2 3 4)

(defn var-arity
    [& xs]
    (map sqre xs))
    
(var-arity 1 2 3 4) ; (1 4 9 16)

(defn var-arity2
    [x & xs]
    (conj (map inc xs) (/ x 2)))

(var-arity2 1 2 3 4) ; (1/2 3 4 5)

(defn my-first
    [[xs]]
    xs)
    
(my-first [1 2 3 4]) ; 1

(defn vec-mod
    [[a b & c]]
    (vector
        (inc a)
        (dec b)
        (/ a b)))
        
(vec-mod [1 2 3 4 5]) ; [2 1 1/2]

(defn map-access
    [{x :x y :y}]
    (* x y))
    
(map-access {:x 5 :y 7}) ; 35

(defn as-alias
    [{:keys [x y] :as xy}]
    (+ (:x xy) (* x y)))
    
(as-alias {:x 3 :y 4}) ; 15
