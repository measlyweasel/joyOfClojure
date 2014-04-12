(ns ch3)

(defn ex1 [] (for [x (range 2) y (range 2)] (bit-xor x y)))


(defn xors [maxX maxY] (for [x (range maxX) y (range maxY)] [x y (bit-xor x y)]))


(def frame (java.awt.Frame.))

(defn print-methods [c]
  (for [method (seq (.getMethods c))
        :let [method-name (.getName method)]]
    method-name))

(defn findVisMethod []
  (for [method (seq (.getMethods java.awt.Frame))
        :let [method-name (.getName method)]
        :when (re-find #"Vis" method-name)]
    method-name))


(.setSize frame (java.awt.Dimension. 200 200))
(.setVisible frame true)