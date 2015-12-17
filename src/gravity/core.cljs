(ns gravity.core
  (:require ;[gravity.rendering :as rendering]
            [gravity.dummy :as dummy]
            [brute.entity :as be]
            [brute.system :as bs]))

(declare game-loop)
(declare app-state)

(enable-console-print!)

(defn- start [system]
  (-> system
      ))

(defn- create-systems
    "register all the system functions"
    [system]
    (-> system
        (dummy/start)
        (bs/add-system-fn dummy/process-one-game-tick)))

(defn setup []
  (.log js/console "Figwheel: Setup"))

(defn teardown []
  (.log js/console "Figwheel: Teardown"))

;; define a reload hook in the
(defn on-js-reload []
  (teardown)
  (setup))

(defn game-loop []
  (let [frame (js/requestAnimationFrame game-loop)]
    (bs/process-one-game-tick @app-state frame)))

(defonce app-state (-> (be/create-system)
                       create-systems
                       atom))

(js/requestAnimationFrame game-loop)
