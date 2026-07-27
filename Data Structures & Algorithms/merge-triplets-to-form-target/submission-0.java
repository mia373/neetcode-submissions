public class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        //since we may find multiple indices with the same values as target, use a hashset to gurantee we don't overcount
        Set<Integer> good = new HashSet<>();

        for (int[] t : triplets) {
            //if a triplet t has any element greater than the corresponding value in target (i.e., t[0] > target[0], t[1] > target[1], or t[2] > target[2]), we can discard it. This is because using such a triplet in operations would exceed the target values, making it invalid.
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            
            //Now, from the remaining valid triplets, we only need to check whether the target triplet values exist. Since all values in the valid triplets are less than or equal to the corresponding values in the target triplet, finding the target triplet among them guarantees that we can achieve it.
            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    good.add(i);
                }
            }
        }
        
        //the size of the hashset should be 3
        return good.size() == 3;
    }
}
