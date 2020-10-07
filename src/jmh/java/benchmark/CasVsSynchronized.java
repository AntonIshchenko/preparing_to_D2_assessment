package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
@Warmup(iterations = 1)
@Measurement(iterations = 2)
public class CasVsSynchronized {
   public static void main(String[] args) throws RunnerException {
      new Runner(
            new OptionsBuilder().include(CasVsSynchronized.class.getSimpleName())
                  .shouldFailOnError(true)
                  .mode(Mode.AverageTime)
                  .timeUnit(TimeUnit.NANOSECONDS)
                  .warmupIterations(5)
                  .warmupTime(TimeValue.seconds(5))
                  .measurementIterations(5)
                  .measurementTime(TimeValue.seconds(5))
                  .threads(8)
                  .forks(1)
                  .build()
      ).run();

   }

   private long number = 0L;
   private final Object lock = new Object();
   private final AtomicLong atomicNumber = new AtomicLong(number);

   @Setup(Level.Iteration)
   public void setUp() {
      number = 0xCAFEBABECAFED00DL;
      atomicNumber.set(number);
   }

   @Benchmark
   public long casShared() {
      return atomicNumber.updateAndGet(x -> x * 123L);
   }

   @Benchmark
   public long syncShared() {
      synchronized (lock) {
         return number *= 123L;
      }
   }

}