package combination;

import java.util.*;

public class Combination {

    public Combination(int n) {
        this.n = n;
    }

    int n;
    List<List<Integer>> combi = new ArrayList<>();

    List<List<Integer>> getCombination() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(i + 1);

        getCombinationHelper(arr, 3, 0, new ArrayList<>(), combi);

        return combi;
    }

    void getCombinationHelper(List<Integer> input, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < input.size(); i++) {
            current.add(input.get(i));
            getCombinationHelper(input, k - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}

class CombinationTest {
    public static void main(String[] args) {
        Combination combination = new Combination( 8 * 8);
        List<List<Integer>> combi = combination.getCombination();
        System.out.println(combi.get(6).get(0));
        System.out.println(combi.get(6).get(1));
        System.out.println(combi.get(6).get(2));
    }
}
