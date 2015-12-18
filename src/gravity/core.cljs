(ns gravity.core
  (:require ;[gravity.rendering :as rendering]
            [gravity.dummy :as dummy]
            [gravity.rendering :as rendering]
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
        (rendering/start)
        (bs/add-system-fn rendering/process-one-game-tick)))

;; (defn setup []
;;   (.log js/console "Figwheel: Setup"))
;;
;; (defn teardown []
;;   (.log js/console "Figwheel: Teardown"))
;;
;; ;; define a reload hook in the
;; (defn on-js-reload []
;;   (teardown)
;;   (setup))

(defn game-loop []
  (let [frame (js/requestAnimationFrame game-loop)]
    (swap! app-state (fn [system] (bs/process-one-game-tick system frame)))))

(defn create-entities [system]
  (-> system
    (rendering/create-rect 10 10 20 20 "#cecece")))

(defonce app-state (-> (be/create-system)
                       create-systems
                       create-entities
                       atom))

(js/requestAnimationFrame game-loop)




