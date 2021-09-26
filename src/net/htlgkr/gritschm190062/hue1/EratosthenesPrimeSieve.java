/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.gritschm190062.hue1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maxim
 */
public class EratosthenesPrimeSieve implements PrimeSieve {

    private boolean[] primes;

    public static void main(String[] args) {
        EratosthenesPrimeSieve sieb = new EratosthenesPrimeSieve(20);
        sieb.getPrimes();
        sieb.printPrimes();
        System.out.println("");
        sieb.bsp2();
    }

    public EratosthenesPrimeSieve(int grenze) {
        primes = new boolean[grenze];
    }

    @Override
    public boolean isPrime(int p) {
        if (primes[p] == true) {
            return true;
        } else {
            return false;
        }
    }

    public void getPrimes() {
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == true) {

                for (int j = 2; j < primes.length; j++) {
                    if (i * j >= primes.length) {
                        break;
                    } else {
                        primes[i * j] = false;

                    }
                }

            }
        }
    }

    @Override
    public void printPrimes() {
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == true) {
                System.out.println(i + ",");
            }

        }
    }

    public void bsp2() {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == true) {
                primeNumbers.add(i);
            }
        }

        for (int i = 4; i < primes.length; i = i + 2) {
            for (int primeNumber : primeNumbers) {
                for (int primeNumber1 : primeNumbers) {
                    if ((primeNumber + primeNumber1) == i) {
                        System.out.println(i + " = " + primeNumber + " + " + primeNumber1);
                    }
                }
            }
        }
    }
}
