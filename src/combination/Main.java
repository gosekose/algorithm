package combination;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(); // arrayList 생성
        for (int i = 0; i < 64; i++) numbers.add(i + 1); // 인덱스 추가

        List<List<Integer>> combinations = getCombinations(numbers, 3); // 3개의 조합 생성
        System.out.println(combinations.size());
        System.out.println(combinations.get(6).get(0));
        System.out.println(combinations.get(6).get(1));
        System.out.println(combinations.get(6).get(2));
    }

    static List<List<Integer>> getCombinations(List<Integer> input, int k) {
        List<List<Integer>> result = new ArrayList<>(); // 결과를 저장할 list
        getCombinationHelper(input, k, 0, new ArrayList<>(), result); // 재귀 시작
        return result;
    }

    static void getCombinationHelper(List<Integer> input, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) { // k 가 0이라면 재귀 종료
            result.add(new ArrayList<>(current)); // current 값을 복사하여 리턴 / current 리스트는 다음에도 써야하는데 그대로 값을 넣게되면 변경 시 함께 변경됌
            return;
        }

        for (int i = start; i < input.size(); i++) {
            current.add(input.get(i));
            getCombinationHelper(input, k - 1, i + 1, current, result); // k를 줄이고, 인덱스를 늘려서 재귀
            current.remove(current.size() - 1); // 마지막 remove(current.size() - 1)을 하는 이유는 [1, 2] -> [1, 2, 3] 이후 다시 [1, 2]로 복귀하여 다음 재귀 실행
        }
    }
}
