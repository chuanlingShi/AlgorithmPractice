package DFS.I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsOfCoins {
    //tc: O(target^n), n is the length of coins
    //sc: O(n), n is the length of coins
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        combinations(target, 0, result, coins, solution);
        return result;
    }

    private void combinations(int difToTarget, int index, List<List<Integer>> result, int[] coins, List<Integer> solution) {
        if (index == coins.length) {
            if (difToTarget == 0) result.add(new ArrayList<>(solution));
            return;
        }
        int value = coins[index];
        int maxCanTake = difToTarget / value;
        for (int i = 0; i <= maxCanTake; i++) {
            solution.add(i);
            combinations(difToTarget - value * i, index + 1, result, coins, solution);
            solution.remove(solution.size() - 1);
        }
    }
}
