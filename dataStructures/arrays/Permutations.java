package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        return permuteList(list);
    }

    private static List<List<Integer>> permuteList(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Integer elem = list.remove(i);
            List<List<Integer>> tempPerm = permuteList(list);
            if (tempPerm.size() == 0) tempPerm.add(new ArrayList<>());
            for (List<Integer> p : tempPerm) {
                p.add(0, elem);
                result.add(p);
            }
            list.add(i, elem);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 2, 3});
        for (List<Integer> list : res) {
            list.stream().forEach(System.out::print);
            System.out.println();
        }
    }
}
