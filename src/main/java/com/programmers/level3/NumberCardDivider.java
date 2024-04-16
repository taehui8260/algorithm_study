package com.programmers.level3;

public class NumberCardDivider {
        public int solution(int[] arrayA, int[] arrayB) {
            int gcdA = findGCD(arrayA);
            int gcdB = findGCD(arrayB);

            int maxA = findMaxDivisor(gcdA, arrayB);
            int maxB = findMaxDivisor(gcdB, arrayA);

            return Math.max(maxA, maxB);
        }

        private int findGCD(int[] array) {
            int gcd = array[0];
            for (int i = 1; i < array.length; i++) {
                gcd = gcd(gcd, array[i]);
            }
            return gcd;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        private int findMaxDivisor(int gcd, int[] array) {
            for (int divisor = gcd; divisor > 0; divisor--) {
                if (isDivisor(gcd, divisor) && allCannotDivide(divisor, array)) {
                    return divisor;
                }
            }
            return 0;
        }

        private boolean isDivisor(int n, int divisor) {
            return n % divisor == 0;
        }

        private boolean allCannotDivide(int divisor, int[] array) {
            for (int num : array) {
                if (num % divisor == 0) return false;
            }
            return true;
        }
    }
