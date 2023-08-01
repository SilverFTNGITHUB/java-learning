package com.pineftn.thread.basic;

/*
The other way to create a thread is to declare a class that implements the Runnable interface.
That class then implements the run method.
An instance of the class can then be allocated, passed as an argument when creating Thread, and started.
The same example in this other style looks like the following:
*/
class PrimeRun implements Runnable {
    long minPrime;

    PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        // compute primes larger than minPrime
        //. . .
    }
}