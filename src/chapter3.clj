(ns ch3)

(defn ex1 [] (for [x (range 2) y (range 2)] (bit-xor x y)))


(defn xors [maxX maxY] (for [x (range maxX) y (range maxY)] [x y (rem (bit-xor x y) 256)]))


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


(.setSize frame (java.awt.Dimension. 500 500))
(.setVisible frame true)

(def gfx (.getGraphics frame))

(doseq [[x y xor] (xors 500 500)]
  (.setColor gfx (java.awt.Color. xor xor xor))
  (.fillRect gfx x y 1 1))

(defn f-values [f xs ys]
  (for [x (range xs) y (range ys)]
    [x y (rem (f x y) 256)]))

(defn clear [g xs ys] (.clearRect g 0 0 xs ys))

(defn draw-values [f xs ys]
  (clear gfx xs ys)
  (.setSize frame (java.awt.Dimension. xs ys))
  (doseq [[x y v] (f-values f xs ys)]
    (.setColor gfx (java.awt.Color. v v v))
    (.fillRect gfx x y 1 1)))




