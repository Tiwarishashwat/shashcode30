class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int bestSingleStart = 0;
        int[] bestDoubleStart = { 0, k };
        int[] bestTripleStart = { 0, k, k * 2 };
        int singleWindowSum = 0;
        //initial window
        for(int i = 0; i < k; i++) {
            singleWindowSum += nums[i];
        }

        int doubleWindowSum = 0;
        for(int i = k; i < k * 2; i++) {
            doubleWindowSum += nums[i];
        }

        int tripleWindowSum = 0;
        for(int i = k * 2; i < k * 3; i++) {
            tripleWindowSum += nums[i];
        }

        int bestSingleSum = singleWindowSum;
        int bestDoubleSum = singleWindowSum + doubleWindowSum;
        int bestTripleSum = singleWindowSum + doubleWindowSum + tripleWindowSum;

        int singleStartIndex = 1;
        int doubleStartIndex = k + 1;
        int tripleStartIndex = k * 2 + 1;

        while (tripleStartIndex <= nums.length - k) {
            // current sum
            singleWindowSum = singleWindowSum - nums[singleStartIndex - 1] + nums[singleStartIndex + k - 1];
            doubleWindowSum = doubleWindowSum - nums[doubleStartIndex - 1] + nums[doubleStartIndex + k - 1];
            tripleWindowSum = tripleWindowSum - nums[tripleStartIndex - 1] + nums[tripleStartIndex + k - 1];
            // updating best sum
            if (singleWindowSum > bestSingleSum) {
                bestSingleStart = singleStartIndex;
                bestSingleSum = singleWindowSum;
            }

            if (doubleWindowSum + bestSingleSum > bestDoubleSum) {
                bestDoubleStart[0] = bestSingleStart;
                bestDoubleStart[1] = doubleStartIndex;
                bestDoubleSum = doubleWindowSum + bestSingleSum;
            }

            if (tripleWindowSum + bestDoubleSum > bestTripleSum) {
                bestTripleStart[0] = bestDoubleStart[0];
                bestTripleStart[1] = bestDoubleStart[1];
                bestTripleStart[2] = tripleStartIndex;
                bestTripleSum = tripleWindowSum + bestDoubleSum;
            }
            singleStartIndex += 1;
            doubleStartIndex += 1;
            tripleStartIndex += 1;
        }
        return bestTripleStart;
    }
}
