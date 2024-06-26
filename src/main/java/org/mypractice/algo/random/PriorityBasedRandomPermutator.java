package org.mypractice.algo.random;

import lombok.AllArgsConstructor;
import org.mypractice.algo.sort.MergeSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Implemention of RandomPermutator by assigning random priority to the items and then
 * sorting them based on the priority.
 * @param <T> Generic Type
 */
@AllArgsConstructor
public class PriorityBasedRandomPermutator<T> implements RandomPermutator<T> {

    private final Random random;

    private final MergeSorter<Prioritized<T>> sorter = new MergeSorter<>();

    @Override
    public List<T> randomize(List<T> given) {
        if (given == null || given.isEmpty()) {
            return Collections.emptyList();
        }
        List<Prioritized<T>> prioritizedList = getListWithRandomPriorities(given);
        List<Prioritized<T>> sortedList = sorter.sort(prioritizedList);

        return getListWithoutPriorities(sortedList);
    }

    private List<Prioritized<T>> getListWithRandomPriorities(List<T> list) {
        List<Prioritized<T>> prioritizedList = new ArrayList<>();
        int randomUpperBound = list.size() ^ 3 + 1;
        for (T element : list) {
            prioritizedList.add(new Prioritized<T>(random.nextInt(1, randomUpperBound), element));
        }
        return prioritizedList;
    }

    private List<T> getListWithoutPriorities(List<Prioritized<T>> listWithPriorities) {
        return listWithPriorities.stream().map(Prioritized::getElement).toList();
    }
}
