package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSorter<T extends Comparable<T>> extends AbstractTwoWaySorter<T> {

    @Override
    protected List<T> sort(final List<T> unsortedList) {
        final List<T> mutableList = new ArrayList<>(unsortedList);
        final int len = mutableList.size();
        int sortedLimit = -1;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = len - 2; j > sortedLimit; j--) {
                if (mutableList.get(j).compareTo(mutableList.get(j + 1)) > 0) {
                    SortUtils.swap(mutableList, j, j + 1);
                    swapped = true;
                }
            }
            sortedLimit++;
        }
        return mutableList;
    }
}
