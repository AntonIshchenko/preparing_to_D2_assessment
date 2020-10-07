package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
@Warmup(iterations = 1)
@Measurement(iterations = 2)
public class BenchmarkCollection {

   @Param({ "10000" })
   private int N;

   private List<String> DATA_FOR_TESTING;
   private List<String> DATA_FOR_TESTING2;

   public static void main(String[] args) throws RunnerException {

      Options opt = new OptionsBuilder()
            .include(BenchmarkCollection.class.getSimpleName())
            .forks(1)
            .build();

      new Runner(opt).run();
   }

   @Setup
   public void setup() {
//      DATA_FOR_TESTING = arrayListAddElementToEnd();
//      DATA_FOR_TESTING2 = linkedListAddElementToEnd();
   }

//   @Benchmark
   public List<String> linkedListAddElementToEnd() {
      List<String> data = new LinkedList<>();
      for (int i = 0; i < N; i++) {
         data.add("Number : " + i);
      }
      return data;
   }

   @Benchmark
   public List<String> linkedListAddElementToBeginning() {
      List<String> data = new LinkedList<>();
      for (int i = 0; i < N; i++) {
         data.add(0, "Number : " + i);
      }
      return data;
   }

   @Benchmark
   public List<String> arrayListAddElementToBeginning() {
      List<String> data = new ArrayList<>();
      for (int i = 0; i < N; i++) {
         data.add(0, "Number : " + i);
      }
      return data;
   }

//   @Benchmark
   public List<String> arrayListAddElementToEnd() {
      List<String> data = new ArrayList<>();
      for (int i = 0; i < N; i++) {
         data.add("Number : " + i);
      }
      return data;
   }

   @Benchmark
   public List<String> arrayListInsertInTheMiddle() {
      List<String> data = new ArrayList<>();
      for (int i = 0; i < N; i++) {
         data.add(data.size()/2, "Number : " + i);
      }
      return data;
   }

   @Benchmark
   public List<String> linkedListInsertInTheMiddle() {
      List<String> data = new LinkedList<>();
      for (int i = 0; i < N; i++) {
         data.add(data.size()/2, "Number : " + i);
      }
      return data;
   }


   //   @Benchmark
   public void loopFor(Blackhole bh) {
      for (int i = 0; i < DATA_FOR_TESTING.size(); i++) {
         String s = DATA_FOR_TESTING.get(i); //take out n consume, fair with foreach
         bh.consume(s);
      }
   }

//   @Benchmark
   public void loopWhile(Blackhole bh) {
      int i = 0;
      while (i < DATA_FOR_TESTING.size()) {
         String s = DATA_FOR_TESTING.get(i);
         bh.consume(s);
         i++;
      }
   }

//   @Benchmark
   public void loopForEach(Blackhole bh) {
      for (String s : DATA_FOR_TESTING) {
         bh.consume(s);
      }
   }

//   @Benchmark
   public void loopIterator(Blackhole bh) {
      Iterator<String> iterator = DATA_FOR_TESTING.iterator();
      while (iterator.hasNext()) {
         String s = iterator.next();
         bh.consume(s);
      }
   }


}