(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.day1 :refer :all]
            [aoc.day2 :refer :all]))

;; Day 1

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

;; Day 2

(deftest get-int-computer-output-1
   (testing "Should get output of 3500 for specified program")
   (is (= 3500 (intcode-computer [1,9,10,3,2,3,11,0,99,30,40,50]))))

(deftest get-int-computer-output-2
  (testing "Should get output of 2 for specified program")
  (is (= 2 (intcode-computer [1 0 0 0 99]))))

(deftest get-int-computer-output-3
  (testing "Should get output of 2 for specified program")
  (is (= 2 (intcode-computer [2 3 0 3 99]))))

(deftest get-int-computer-output-4
  (testing "Should get output of 2 for specified program")
  (is (= 2 (intcode-computer [2 4 4 5 99 0]))))

(deftest get-int-computer-output-5
  (testing "Should get output of 30 for specified program")
  (is (= 30 (intcode-computer [1 1 1 4 99 5 6 0 99]))))