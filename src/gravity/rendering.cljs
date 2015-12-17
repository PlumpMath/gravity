(ns gravity.rendering
  (:require [monet.canvas :as canvas]
            [brute.entity :as e]))

;; (def canvas-dom (.getElementById js/document "canvas"))
;;
;; (def monet-canvas (canvas/init canvas-dom "2d"))
;;
;; (canvas/add-entity monet-canvas :background
;;                    (canvas/entity {:x 0 :y 0 :w 600 :h 600} ; val
;;                                   nil                       ; update function
;;                                   (fn [ctx val]             ; draw function
;;                                     (-> ctx
;;                                         (canvas/fill-style "#cecece")
;;                                         (canvas/fill-rect val)))))

;; (defn start
;;     "Start this system"
;;     [system]
;;     (as-> {:canvas (.getElementById js/document "canvas")}
;;           renderer
;;           (assoc system :renderer renderer)))
;;
;;
;; (defn- render-rectangles
;;     "Render all the rectangles"
;;     [system]
;;     (let [game-canvas (:canvas (:renderer system))]
;;         (.begin shape-renderer ShapeRenderer$ShapeType/Filled)
;;         (doseq [entity (e/get-all-entities-with-component system Rectangle)]
;;             (let [rect (e/get-component system entity Rectangle)
;;                   geom (:rect rect)]
;;                 (doto shape-renderer
;;                     (.setColor (:colour rect))
;;                     (.rect (rectangle! geom :get-x)
;;                            (rectangle! geom :get-y)
;;                            (rectangle! geom :get-width)
;;                            (rectangle! geom :get-height)))))
;;         (.end shape-renderer)))
;;
;; (defn process-one-game-tick
;;     "Render all the things"
;;     [system _]
;;     (render-rectangles system)
;;     system)
