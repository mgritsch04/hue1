/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.gritschm190062.hue1;

import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class EratosthenesPrimeSieve implements PrimeSieve {

    private int grenze;
    private boolean[] primes = new boolean[grenze];

    public static void main(String[] args) {
        EratosthenesPrimeSieve sieb = new EratosthenesPrimeSieve(20);
        sieb.getPrimes();
        sieb.printPrimes();
    }

    public EratosthenesPrimeSieve(int grenze) {
        grenze = grenze;
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
                int y = 2;
                int x = (int) Math.pow(i, y);
                while (x <= primes.length) {
                    primes[x] = false;
                    y++;
                    x = (int) Math.pow(i, y);

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
}
