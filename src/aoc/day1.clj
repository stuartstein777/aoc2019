(ns aoc.day1
  (:require [clojure.core.reducers :as r]))

;--- Day 1: The Tyranny of the Rocket Equation ---
;
;Santa has become stranded at the edge of the Solar System while delivering presents to other planets! To accurately calculate his position in space, safely align his warp drive, and return to Earth in time to save Christmas, he needs you to bring him measurements from fifty stars.
;
;Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
;
;The Elves quickly load you into a spacecraft and prepare to launch.
;
;At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper. They haven't determined the amount of fuel required yet.
;
;Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
;
;For example:
;
;For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
;For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
;For a mass of 1969, the fuel required is 654.
;For a mass of 100756, the fuel required is 33583.
;
;The Fuel Counter-Upper needs to know the total fuel requirement. To find it, individually calculate the fuel needed for the mass of each module (your puzzle input), then add together all the fuel values.
;
;What is the sum of the fuel requirements for all of the modules on your spacecraft?


(def input [118997 63756 124972 141795 111429 53536 50522 143985 62669 77518 60164 72698 123145 57693 87138 82831 
            53289 60110 115660 51217 117781 81556 103963 89000 109330 100487 136562 145020 140554 102425 93333 75265 
            55764 70093 73800 81349 141055 56441 141696 89544 106152 98674 100882 137932 88008 149027 92767 113740
            79971 85741 126630 75626 125042 69237 147069 60786 63751 144363 81873 107230 90789 81655 144004 74536
            126675 147470 123359 68081 136423 94629 58263 122420 143933 148528 129120 78391 74289 106795 143640
            59108 64462 78216 56113 64708 82372 115231 74229 130979 83590 76666 93156 138450 71077 128048 65476
            85804 145692 106836 70016 113158])

(defn get-fuel [mass]
  (- (Math/floor (/ mass 3)) 2))

(reduce + (map get-fuel input))

;;--- Part Two ---
;
; During the second Go / No Go poll, the Elf in charge of the Rocket Equation Double-Checker stops the launch sequence.
; Apparently, you forgot to include additional fuel for the fuel you just added.
;
; Fuel itself requires fuel just like a module - take its mass, divide by three, round down, and subtract 2. However,
; that fuel also requires fuel, and that fuel requires fuel, and so on. Any mass that would require negative fuel
; should instead be treated as if it requires zero fuel; the remaining mass, if any, is instead handled by wishing
; really hard, which has no mass and is outside the scope of this calculation.
;
; So, for each module mass, calculate its fuel and add it to the total. Then, treat the fuel amount you just
; calculated as the input mass and repeat the process, continuing until a fuel requirement is zero or negative. For example:
;
; A module of mass 14 requires 2 fuel. This fuel requires no further fuel (2 divided by 3 and rounded down is 0,
; which would call for a negative fuel), so the total fuel required is still just 2.
;
; At first, a module of mass 1969 requires 654 fuel. Then, this fuel requires 216 more fuel (654 / 3 - 2). 216 then
; requires 70 more fuel, which requires 21 fuel, which requires 5 fuel, which requires no further fuel. So, the
; total fuel required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966.
; The fuel required by a module of mass 100756 and its fuel is: 33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346.
;
; What is the sum of the fuel requirements for all of the modules on your spacecraft when also taking into account
; the mass of the added fuel? (Calculate the fuel requirements for each module separately, then add them all up at the end.)

(defn get-adjusted-fuel [mass]
  ((fn [mass total]
     (if (<= mass 6)
       total
       (let [current (- (Math/floor (/ mass 3)) 2)]
         (recur current (+ total current))))) mass 0))

(reduce + (map get-adjusted-fuel input))

(time (r/fold + (r/map get-adjusted-fuel input)))
