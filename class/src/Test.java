import java.util.Scanner;
import java.util.TreeSet;

public class Test {
    public String a;
    public String b;

//    public Test() {}

    public void range_check() {
        System.out.println("-----正在检查输入数据范围-----");
        //检查整数类型
        if (!a.matches("^[0-9]*$")) {
            System.out.println("输入的下界不为整数，请重新输入：");

            System.out.println("请输入数据范围下界：");
            Scanner input = new Scanner(System.in);
            a = input.next();
            System.out.println("请输入数据范围上界：");
            b = input.next();
            range_check();
        }
        if (!b.matches("^[0-9]*$")) {
            System.out.println("输入的上界不为整数，请重新输入：");

            System.out.println("请输入数据范围下界：");
            Scanner input = new Scanner(System.in);
            a = input.next();
            System.out.println("请输入数据范围上界：");
            b = input.next();
            range_check();
        } else {
            System.out.println("输入范围上下界均为整数");
        }

        //检查下界小于等于上界
        if (!(Integer.parseInt(a) <= Integer.parseInt(b))) {
            System.out.println("输入的下界大于上界，请重新输入：");
            System.out.println("请输入数据范围下界：");
            Scanner input = new Scanner(System.in);
            a = input.next();
            System.out.println("请输入数据范围上界：");
            b = input.next();
            range_check();
        } else {
            System.out.println("输入范围下界小于等于上界，符合要求！");
        }
    }

    public int[] equ() {
        System.out.println("-----正在进行等价类划分-----");
        int[] result = new int[6];
        //用Integer.MAX_VALUE表示无穷大整数，Integer.MIN_VALUE 表示无穷小整数
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.parseInt(a) - 1;
        result[2] = Integer.parseInt(a);
        result[3] = Integer.parseInt(b);
        result[4] = Integer.parseInt(b) + 1;
        result[5] = Integer.MAX_VALUE;
        System.out.println("1个有效区间为：[" + result[2] + "," + result[3] + "]；");
        System.out.println("2个无效区间为：(-∞," + result[1] + "], [" + result[4] + ",+∞)");
        return result;
    }

    public TreeSet<Integer> bound() {
        System.out.println("-----正在进行边界值分析-----");
        //用TreeSet实现去重存储，顺便可以排序
        TreeSet<Integer> result = new TreeSet<Integer>();
        result.add(Integer.parseInt(a) - 1);
        result.add(Integer.parseInt(a));
        result.add(Integer.parseInt(a) + 1);
        result.add(Integer.parseInt(b) - 1);
        result.add(Integer.parseInt(b));
        result.add(Integer.parseInt(b) + 1);

        System.out.println("待测边界值为：");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.print('\n');
        return result;
    }

    public TreeSet<Integer> rand() {
        System.out.println("-----正在进行随机数生成-----");
        System.out.println("---生成等价划分区间---");
        int[] equs = equ();
        //为防止整数越界，将正负无穷上下界设置为正负一百万
        equs[0] = -1000000;
        equs[5] = 1000000;

        System.out.println("请输入每个区间要生成的随机数个数：");
        Scanner input = new Scanner(System.in);
        TreeSet<Integer> result = new TreeSet<Integer>();
        int n = Integer.parseInt(input.next());
//        int count=1;
        for (int i = 0; i <= 4; i += 2) {
            for (int j = 0; j < n; j++) {
//                System.out.println(count++);
                result.add((int) (Math.random() * (equs[i + 1] - equs[i] + 1) + equs[i]));
            }
        }
//        System.out.println(result.size());
        System.out.println("待测边界值为：");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.print('\n');
        return result;
    }

    public static void main(String[] args) {
        Test testcase = new Test();
        System.out.println("请输入数据范围下界：");
        Scanner input = new Scanner(System.in);
        testcase.a = input.next();
        System.out.println("请输入数据范围上界：");
        testcase.b = input.next();
        testcase.range_check();
        testcase.equ();
        testcase.bound();
    }
}