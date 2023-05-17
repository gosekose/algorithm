package lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 7};

        int size = lisOfBinarySearchSize(arr);
        List<Integer> list = lisOfBinarySearchList(arr);
        System.out.println("size = " + size);

    }

    static int lisOfBinarySearchSize(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            if (dp.isEmpty() || num > dp.get(dp.size() - 1)) {
                dp.add(num);
            } else {
                int left = 0, right = dp.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (dp.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp.set(right, num);
            }
        }
        return dp.size();
    }

    static List<Integer> lisOfBinarySearchList(int[] nums) {
        List<Integer> dp = new ArrayList<>();

        int[] idxs = new int[nums.length]; // 인덱스 저장할 배열
        int[] preIdxs = new int[nums.length]; // 이전 인덱스를 저장할 tmp 배열

        for (int i = 0; i < nums.length; i++) {
            if (dp.isEmpty() || nums[i] > dp.get(dp.size() - 1)) { // 리스트가 비어있거나 현재 리스트의 마지막 값보다 더 큰 경우
                if (!dp.isEmpty()) preIdxs[i] = idxs[dp.size() - 1]; // dp의 마지막 값을 임시 배열에 저장
                dp.add(nums[i]); // 값 추가하기
                idxs[dp.size() - 1] = i; // 인덱스를 저장할 색인 배열에 인덱스 업데이트
            } else { // 이진 검색 시작
                int left = 0, right = dp.size() - 1; // 초기화 양 끝
                while (left < right) {
                    int mid = left + (right - left) / 2; // 중앙을 설정할 mid
                    if (dp.get(mid) < nums[i]) { // 중간에 위치한 값보다 큰 경우 오른쪽 이진 검색
                        left = mid + 1; // left를 증가시켜서 위치를 옮김
                    } else {
                        right = mid; // right를 미드로 설정하여 왼쪽 이진 탐색
                    }
                }
                dp.set(right, nums[i]); // 중앙에 값을 대체함
                idxs[right] = i; // 대체한 인덱스 설정
                if (right > 0) preIdxs[i] = idxs[right - 1];
            }
        }

        List<Integer> lis = new ArrayList<>();
        int idx = idxs[dp.size() - 1];
        while (lis.size() < dp.size()) {
            lis.add(nums[idx]);
            idx = preIdxs[idx];
        }
        Collections.reverse(lis);
        return lis;
    }
}
