(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.day1 :refer :all]))

;For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
;For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
;For a mass of 1969, the fuel required is 654.
;For a mass of 100756, the fuel required is 33583.

(deftest get-fuel-test-1
  (testing "Should return fuel requirement of 2 for module mass of 12"
    (is (= 2.0 (get-fuel 12)))))

(deftest get-fuel-test-2
  (testing "Should return fuel requirement of 2 for module mass of 14"
    (is (= 2.0 (get-fuel 14)))))

(deftest get-fuel-test-3
  (testing "Should return fuel requirement of 654 for module mass of 1969"
    (is (= 654.0 (get-fuel 1969)))))

(deftest get-fuel-test-4
  (testing "Should return fuel requirement of 33583 for module mass of 100756"
    (is (= 33583.0 (get-fuel 100756)))))

(deftest get-fuel-adjusted-1
  (testing "Should get adjusted fuel requirement of 2 for module mass of 14"
    (is (= 2.0 (get-adjusted-fuel 14)))))

(deftest get-fuel-adjusted-2
  (testing "Should get adjusted fuel requirement of 966 for module mass of 1969"
    (is (= 966.0 (get-adjusted-fuel 1969)))))

(deftest get-fuel-adjusted-3
  (testing "Should get adjusted fuel requirement of 50346 for module mass of 100756"
    (is (= 50346.0 (get-adjusted-fuel 100756)))))
