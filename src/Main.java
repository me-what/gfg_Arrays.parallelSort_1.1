import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numbers[] = {9, 8, 7, 6, 3, 1};

        System.out.print("Unsorted Array: ");
        Arrays.stream(numbers)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        Arrays.parallelSort(numbers);
        System.out.print("Sorted Array: ");
        Arrays.stream(numbers)
                .forEach(n -> System.out.print(n + " "));


        // 2
        int numbers2[] = new int[100];

        for (int i = 0; i < 1000; i += 10) {
            System.out.println("\n\nFor iteration number: "
                    + (i / 10 + 1));

            Random rand = new Random();

            for (int j = 0; j < 100; j++) {
                numbers2[j] = rand.nextInt();
            }

            long startTime = System.nanoTime();
            Arrays.sort(numbers2);
            long endTime = System.nanoTime();

            System.out.println("Start and End Time in Serial (in ns): "
                    + startTime + ":" + endTime);
            System.out.println("Time taken by Serial Sort(in ns): "
                    + (endTime - startTime));

            startTime = System.nanoTime();
            Arrays.parallelSort(numbers2);
            endTime = System.nanoTime();

            System.out.println("Start and End Time in parallel (in ns): "
                    + startTime + ":" + endTime);
            System.out.println("Time taken by Parallel Sort(in ns): "
                    + (endTime - startTime));
            System.out.println();
        }
    }
}