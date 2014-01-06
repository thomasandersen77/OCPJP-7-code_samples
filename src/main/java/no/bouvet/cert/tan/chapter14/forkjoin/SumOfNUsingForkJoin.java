package no.bouvet.cert.tan.chapter14.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 06.01.14
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
public class SumOfNUsingForkJoin {
    private static long N = 1_000_000;
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static int forkCount;


    static class RecursiveSumOfN extends RecursiveTask<Long> {
        private long from;
        private long to;

        public RecursiveSumOfN(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if( (to - from) <= N/NUM_THREADS){
                long localSum = 0;
                for(long i = from; i <= to; i++) {
                    localSum += i;
                }
                return localSum;
            } else {
                long mid = (from + to) / 2;
                RecursiveSumOfN firstHalf = new RecursiveSumOfN(from, mid);
                firstHalf.fork();
                //System.out.printf("Fork count: %d%n", ++forkCount);
                RecursiveSumOfN secondHalf = new RecursiveSumOfN(mid+1, to);
                long resultSecond = secondHalf.compute();

                return firstHalf.join() + resultSecond;
            }
        }
    }


    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool(NUM_THREADS);
        long start = System.nanoTime();
        long computedSum = pool.invoke(new RecursiveSumOfN(0, N));
        System.out.println(System.nanoTime() - start);
        System.out.println(computedSum);
        long start2 = System.nanoTime();
        long computedSum2 = (N * (N +1)) / 2;
        System.out.println(System.nanoTime() - start2);
        System.out.println(computedSum2);


    }

}
