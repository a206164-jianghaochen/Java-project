package benchmark;

import bubbleSort.BubbleSort;
import heapSort.HeapSort;
import quickSort.QuickSort;
import selection_sort.SelectionSort;
import InsertionSort.InsertionSort;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

/**
 * Times the sorting algorithms in this project against each other.
 *
 * <p>Every algorithm sorts a fresh copy of the same random input, so the
 * comparison is like-for-like. Each case runs once to let the JIT warm up, then
 * {@link #REPEATS} times, and the median of those runs is reported — a single
 * run on a laptop is dominated by noise.
 *
 * <p>Results are printed as a Markdown table so they can be pasted straight
 * into the README.
 */
public class Benchmark {

    private static final long SEED = 42L;
    private static final int REPEATS = 5;

    /** The two size sets: quadratic sorts cannot survive a million elements. */
    private static final int[] QUADRATIC_SIZES = {1_000, 5_000, 10_000};
    private static final int[] NLOGN_SIZES = {10_000, 100_000, 1_000_000};

    private interface Sort {
        void sort(int[] data);
    }

    public static void main(String[] args) {
        System.out.printf("Java %s on %s (%d cores)%n%n",
                System.getProperty("java.version"),
                System.getProperty("os.name"),
                Runtime.getRuntime().availableProcessors());

        System.out.println("## Quadratic sorts\n");
        System.out.println("Random input, median of " + REPEATS + " runs.\n");
        printTable(QUADRATIC_SIZES, new String[]{
                "Bubble sort", "Selection sort", "Insertion sort"
        }, new Sort[]{
                BubbleSort::bubbleSort,
                SelectionSort::selection_sort,
                data -> InsertionSort.Insertion_Sort(data, data.length)
        });

        System.out.println();
        System.out.println("## O(n log n) sorts\n");
        System.out.println("Random input, median of " + REPEATS + " runs.\n");
        printTable(NLOGN_SIZES, new String[]{
                "Quicksort", "Heap sort"
        }, new Sort[]{
                data -> QuickSort.quickSort(data, 0, data.length - 1),
                HeapSort::heapSort
        });
    }

    private static void printTable(int[] sizes, String[] names, Sort[] sorts) {
        System.out.print("| Algorithm |");
        for (int size : sizes) {
            System.out.print(" " + formatSize(size) + " |");
        }
        System.out.println();

        System.out.print("| --- |");
        for (int i = 0; i < sizes.length; i++) {
            System.out.print(" ---: |");
        }
        System.out.println();

        int[] input = randomArray(sizes[sizes.length - 1]);

        for (int i = 0; i < sorts.length; i++) {
            System.out.print("| " + names[i] + " |");
            for (int size : sizes) {
                int[] data = Arrays.copyOf(input, size);
                double millis = time(sorts[i], data);
                System.out.print(" " + formatMillis(millis) + " |");
            }
            System.out.println();
        }
    }

    /** One warm-up run, then {@link #REPEATS} timed runs; returns the median in ms. */
    private static double time(Sort sort, int[] data) {
        int[] warmUp = data.clone();
        sort.sort(warmUp);
        verify(warmUp);

        long[] samples = new long[REPEATS];
        for (int r = 0; r < REPEATS; r++) {
            int[] copy = data.clone();
            long start = System.nanoTime();
            sort.sort(copy);
            samples[r] = System.nanoTime() - start;
            verify(copy);
        }
        Arrays.sort(samples);
        return samples[samples.length / 2] / 1_000_000.0;
    }

    /** A wrong sort should fail loudly, not produce a fast but meaningless number. */
    private static void verify(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1] > data[i]) {
                throw new IllegalStateException("array is not sorted at index " + i);
            }
        }
    }

    private static int[] randomArray(int size) {
        Random random = new Random(SEED);
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }

    private static String formatSize(int size) {
        return String.format(Locale.ROOT, "%,d", size);
    }

    private static String formatMillis(double millis) {
        if (millis < 1) {
            return String.format(Locale.ROOT, "%.2f ms", millis);
        }
        if (millis < 100) {
            return String.format(Locale.ROOT, "%.1f ms", millis);
        }
        return String.format(Locale.ROOT, "%,.0f ms", millis);
    }
}
