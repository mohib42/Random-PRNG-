public class TestRandomGenerator {

    public static void main(String[] args) {
        
        System.out.println("--- Testing NovelRandomGenerator ---");

        // 1. Generate a single random integer (full range)
        int r1 = NovelRandomGenerator.generateInt();
        System.out.println("Single full-range int: " + r1);

        // 2. Generate a random integer from 0 to 9
        int r2 = NovelRandomGenerator.generateInt(10);
        System.out.println("Int from 0 to 9: " + r2);
        
        // 3. Generate a random integer from 50 to 100
        int r3 = NovelRandomGenerator.generateInt(50, 100);
        System.out.println("Int from 50 to 100: " + r3);

        // 4. Generate a random double [0.0, 1.0)
        double d1 = NovelRandomGenerator.generateDouble();
        System.out.println("Double from 0.0 to 1.0: " + d1);

        // 5. Generate a random float [10.0, 20.0)
        float f1 = NovelRandomGenerator.generateFloat(10.0f, 20.0f);
        System.out.println("Float from 10.0f to 20.0f: " + f1);

        System.out.println("\n--- Filling an Array (from your hint) ---");
        
        // Using the hint's structure, but filling with *generated* numbers
        // instead of user input.
        double[] myList = new double[10];

        System.out.println("Filling array with 10 values from 1.0 to 100.0:");
        for (int i = 0; i < myList.length; i++) {
            // Use your method here!
            myList[i] = NovelRandomGenerator.generateDouble(1.0, 100.0);
            System.out.printf("myList[%d] = %.4f\n", i, myList[i]);
        }
    }
}
