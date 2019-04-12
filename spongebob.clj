(defn spongebob-text
  [s]
  (reduce #(if (and (letter? %2) (toggle-case? 0.5))
             (str %1 (toggle-case %2))
             (str %1 %2))
          ""
          s))

(defn letter?
  [char]
  (let [code-point (int char)]
    (and (> code-point 64) (< code-point 123))))

(defn toggle-case?
  [threshold]
  (>= threshold (rand 1)))

(defn toggle-case
  [c]
  (let [code-point (int c)]
    (if (< code-point 91)
      (char (+ code-point 32))
      (char (- code-point 32)))))

(spongebob-text "Java is so cool")
;; "jAVa Is sO COol"
