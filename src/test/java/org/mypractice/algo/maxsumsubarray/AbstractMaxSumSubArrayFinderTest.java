package org.mypractice.algo.maxsumsubarray;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

@Getter
@Setter
public abstract class AbstractMaxSumSubArrayFinderTest {

    private MaxSumSubArrayFinder maxSumSubArrayFinder;

    @BeforeEach
    public void setuo() {
        initFinder();
    }

    public abstract void initFinder();

    @ParameterizedTest
    @EmptySource
    protected void empty_array(int[] nums) {
        int[] maxSubArray = maxSumSubArrayFinder.find(nums);
        Assertions.assertEquals(0, maxSubArray.length);
    }

    @ParameterizedTest(name = "Positive integer array of size: {2}")
    @MethodSource("org.mypractice.algo.maxsumsubarray.MaxSumSubArrayTestUtil#getPositiveIntArrays")
    public void postive_int_arrays(int[] nums, int[] expectedMaxSumSubArray, int size) {
        int[] result = maxSumSubArrayFinder.find(nums);
        MaxSumSubArrayTestUtil.validateMaxSubArrayResult(expectedMaxSumSubArray, result);
    }

    @ParameterizedTest(name = "Negative integer array of size: {2}")
    @MethodSource("org.mypractice.algo.maxsumsubarray.MaxSumSubArrayTestUtil#getNegativeIntArrays")
    public void negative_int_arrays(int[] nums, int[] expectedMaxSumSubArray, int size) {
        int[] result = maxSumSubArrayFinder.find(nums);
        MaxSumSubArrayTestUtil.validateMaxSubArrayResult(expectedMaxSumSubArray, result);
    }

    @ParameterizedTest(name = "Random positive and negative integer array of size: {2}")
    @MethodSource("org.mypractice.algo.maxsumsubarray.MaxSumSubArrayTestUtil#getRandomIntArrays")
    public void random_int_arrays(int[] nums, int[] expectedMaxSumSubArray, int size) {
        int[] result = maxSumSubArrayFinder.find(nums);
        MaxSumSubArrayTestUtil.validateMaxSubArrayResult(expectedMaxSumSubArray, result);
    }
}
