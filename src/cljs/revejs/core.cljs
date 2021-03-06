(ns revejs.core
  (:require [quil.core :as q :include-macros true]
            [revejs.input :as input]
            [revejs.setup :as setup]
            [revejs.util :refer [WIDTH HEIGHT]]
            [figwheel.client :as fw]
            )
  )

(q/defsketch revejs
  :title "A game-like simulation built with Quil, with game-state undo"
  :size [WIDTH HEIGHT]
  :host "canvas-id"
  :setup setup/setup 
  :draw setup/game-loop
  :renderer :opengl
  :key-pressed input/key-pressed
  :key-released input/key-released
  )

(fw/start
 {
  
  ;; configure a websocket url if you are using your own server
  ;; :websocket-url "ws://localhost:3449/figwheel-ws"

  ;; optional callback
  :on-jsload (fn [] (print "reloaded"))

  ;; The heads up display is enabled by default
  ;; to disable it: 
  ;; :heads-up-display false

  ;; when the compiler emits warnings figwheel
  ;; blocks the loading of files.
  ;; To disable this behavior:
  ;; :load-warninged-code true

  ;; if figwheel is watching more than one build
  ;; it can be helpful to specify a build id for
  ;; the client to focus on
  ;; :build-id "example"
})
