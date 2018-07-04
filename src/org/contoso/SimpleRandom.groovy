package org.contoso

// This class is based from below resource.
// https://stackoverflow.com/a/13444172

class SimpleRandom {
    private int max;
    private int last;

    SimpleRandom(int max) {
        this.max = max;
        this.last = (int) (System.currentTimeMillis() % max);
    }

    int nextInt() {
        // These 32719 and 32749 are random two "large" prime numbers.
        // Last value increased all the time but keep it within some limits.
        // This prime number generator will fail if you ask for numbers bigger then 32749.
        // Result cannot be bigger than 32749.
        last = (last * 32719 + 3) % 32749;
        return last % max;
    }
}