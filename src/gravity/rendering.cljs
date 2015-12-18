(ns gravity.rendering
  (:require [monet.canvas :as canvas]
            [brute.entity :as be]))

;; (defrecord Position [x y])
(defrecord Rectangle [x y w h color monet-entity])

(defn- create-monet-entity [canvas {:keys [x y w h color]} rect]
  (let [monet-entity (canvas/entity {:x x :y y :w w :h h} ; val
                                    nil                       ; update function
                                    (fn [ctx val]             ; draw function
                                      (-> ctx
                                          (canvas/fill-style color)
                                          (canvas/fill-rect val))))]
        (canvas/add-entity canvas :rectangle monet-entity)
        monet-entity))

(defn- render-rectangle [system
                         {monet-entity :monet-entity} rect]


(defn create-rect [system x y w h color]
  (let [entity (be/create-entity)
        monet-entity (create-monet-entity x y w h color)
        rect (->Rectangle x y w h color monit-entity)]
    (be/add-component system entity rect)))

(defn- create-canvas []
  (let [dom-element (.getElementById js/document "canvas")]
    (canvas/init dom-element "2d")))

(defn start [system]
  (update-in system [:systems-state :rendering :canvas] create-canvas))

(defn process-one-game-tick
  "Render all the things"
  [system frame]
  (do
    (doseq [entity (be/get-all-entities-with-component system Rectangle)
            rect (get-component system entity Rectangle)
      (render-rectangle system rect))
    system))





(comment
  (def monet-canvas (canvas/init canvas-dom "2d"))

  (canvas/add-entity monet-canvas :background
                    (canvas/entity {:x 0 :y 0 :w 600 :h 600} ; val
                                    nil                       ; update function
                                    (fn [ctx val]             ; draw function
                                      (-> ctx
                                          (canvas/fill-style "#cecece")
                                          (canvas/fill-rect val)))))

  (defn start
      "Start this system"
      [system]
      (as-> {:canvas (.getElementById js/document "canvas")}
            renderer
            (assoc system :renderer renderer)))


  (defn- render-rectangles
      "Render all the rectangles"
      [system]
      (let [game-canvas (:canvas (:renderer system))]
          (.begin shape-renderer ShapeRenderer$ShapeType/Filled)
          (doseq [entity (e/get-all-entities-with-component system Rectangle)]
              (let [rect (e/get-component system entity Rectangle)
                    geom (:rect rect)]
                  (doto shape-renderer
                      (.setColor (:colour rect))
                      (.rect (rectangle! geom :get-x)
                            (rectangle! geom :get-y)
                            (rectangle! geom :get-width)
                            (rectangle! geom :get-height)))))
          (.end shape-renderer)))

  (defn process-one-game-tick
      "Render all the things"
      [system _]
      (render-rectangles system)
      system)
)
