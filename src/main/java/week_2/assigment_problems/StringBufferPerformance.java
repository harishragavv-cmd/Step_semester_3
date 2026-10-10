package week_2.assigment_problems;

public class StringBufferPerformance {
    static long testStringBuffer(int count) {
        long start = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < count; i++) buffer.append("a");
        return System.nanoTime() - start;
    }
    static long testStringBuilder(int count) {
        long start = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) builder.append("a");
        return System.nanoTime() - start;
    }
    public static void main(String[] args) {
        int count = 100000;
        long builderTime = testStringBuilder(count);
        long bufferTime = testStringBuffer(count);
        System.out.println("StringBuilder time: " + builderTime + " ns");
        System.out.println("StringBuffer time: " + bufferTime + " ns");
        System.out.println("Times vary by computer and run; StringBuffer is synchronized.");
    }
}