package org.mypractice.algo.sort;

import java.util.Collections;
import java.util.List;

public abstract class AbstractTwoWaySorter<T> implements TwoWaySorter<T> {

    @Override
    public List<T> sort(List<T> unsortedList, SortOrder sortOrder) {
        if (SortUtils.isNullOrEmpty(unsortedList)) {
            return Collections.emptyList();
        }
        List<T> updatedList = sort(unsortedList);
        if (SortOrder.NON_INCREASING == sortOrder) {
            updatedList = SortUtils.reverse(updatedList);
        }
        return updatedList;
    }

    protected abstract List<T> sort(List<T> unsortedList);
}
