import java.util.HashSet;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-11-05 20:17
 */
public class Two {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashSet<Integer> powers = new HashSet<>();
        System.out.println(checkPowerSum(n,powers));
    }

    public static int checkPowerSum(int X, HashSet<Integer> powers) {
        if (X == 0) {
            return 1;
        }
        if (X < 0) {
            return -1;
        }
        for (int power = 0; power < 10; power++) {
            int currentPower = (int) Math.pow(7, power);
            if (!powers.contains(currentPower)) {
                powers.add(currentPower);
                int result = checkPowerSum(X - currentPower, powers);
                if (result == 1) {
                    return 1;
                }
                powers.remove(currentPower);
            }
        }
        return -1;
    }
}
