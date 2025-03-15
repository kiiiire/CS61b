package flik;

/** An Integer tester created by Flik Enterprises.
 * @author Josh Hug
 * */
public class Flik {
    /** @param a Value 1
     *  @param b Value 2
     *  @return Whether a and b are the same */
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b);
    }
}
//如果直接使用 == 比较两个 Integer 对象，实际上是比较它们的引用地址，而不是值。
//对于 -128 到 127 范围内的整数，Java 的自动装箱机制会缓存这些值，因此在该范围内的 Integer 对象比较时，== 可能会返回 true。
//超出该范围的整数（如 128），每次装箱都会创建新的对象，因此 == 比较引用时会返回 false。