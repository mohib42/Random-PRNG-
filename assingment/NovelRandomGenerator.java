import java.util.concurrent.atomic.AtomicLong;

 
public class NovelRandomGenerator {

   
    private static final long m = 281474976710656L; // 2^48
    // a (multiplier)
    private static final long a = 25214903917L;
    // c (increment)
    private static final long c = 11L;

 
    private static final AtomicLong seed = new AtomicLong(System.nanoTime() + c);

     
    private static int nextRawInt() {
        long oldSeed, nextSeed;
        do {
            oldSeed = seed.get();
            // The LCG formula: X_n+1 = (a * X_n + c) % m
            nextSeed = (a * oldSeed + c) & (m - 1); // (m-1) is a bitmask for % 2^48
        } while (!seed.compareAndSet(oldSeed, nextSeed));

        // Return the most significant 32 bits of the 48-bit value
        return (int) (nextSeed >>> 16);
    }

    
    public static int generateInt() {
        return nextRawInt();
    }

    
    public static int generateInt(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("Bound must be positive.");
        }
        
        int r = nextRawInt();
        // Take the absolute value to handle negatives, then modulo
        return Math.abs(r % bound);
    }

     
    public static int generateInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Max must be greater than or equal to min.");
        }
       
        return generateInt(max - min + 1) + min;
    }

    
    public static double generateDouble() {
     
        return (double) (nextRawInt() >>> 8) * 0x1.0p-24;
    }

   
    public static double generateDouble(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min.");
        }
        return generateDouble() * (max - min) + min;
    }

     
    public static float generateFloat() {
        // Similar to double, but scale to a float
        return (float) (nextRawInt() >>> 8) * 0x1.0p-24f;
    }

     
    public static float generateFloat(float min, float max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min.");
        }
        return generateFloat() * (max - min) + min;
    }
}
