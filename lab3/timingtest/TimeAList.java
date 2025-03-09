package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int N = 1000; N <= 128000; N *= 2) {
            Stopwatch sw = new Stopwatch();

            // 创建一个新的 AList 并执行添加操作
            AList<Integer> list = new AList<>();
            for (int i = 0; i < N; i++) {
                list.addLast(i);
            }

            // 记录执行时间
            double timeInSeconds = sw.elapsedTime();

            // 将数据添加到相应的列表中
            Ns.addLast(N);
            times.addLast(timeInSeconds);
            opCounts.addLast(N);


        }

        // 打印计时表格
        printTimingTable(Ns, times, opCounts);


    }
}
