/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pawnandplay.controller;
import com.pawnandplay.model.gamesModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 23048503_SanskritiAgrahari
 */
public class mergeSort {
    /**
     * Sorts a list of gamesModel objects by stock in ascending order.
     *
     * @param gamesList List of gamesModel objects to sort.
     * @return Sorted list in ascending order by stock.
     */
    public List<gamesModel> sortByStockAscending(List<gamesModel> gamesList) {
        return mergeSort(gamesList, true);
    }

    /**
     * Sorts a list of gamesModel objects by stock in descending order.
     *
     * @param gamesList List of gamesModel objects to sort.
     * @return Sorted list in descending order by stock.
     */
    public List<gamesModel> sortByStockDescending(List<gamesModel> gamesList) {
        return mergeSort(gamesList, false);
    }

    /**
     * merge sort logic.
     *
     * @param gamesList List of gamesModel objects to sort.
     * @param ascending True for ascending order, false for descending order.
     * @return Sorted list of gamesModel objects.
     */
    private List<gamesModel> mergeSort(List<gamesModel> gamesList, boolean ascending) {
        if (gamesList.size() <= 1) {
            return gamesList;
        }

        // Split the list into two halves
        int mid = gamesList.size() / 2;
        List<gamesModel> left = new ArrayList<>(gamesList.subList(0, mid));
        List<gamesModel> right = new ArrayList<>(gamesList.subList(mid, gamesList.size()));

        // Recursively sort both halves
        left = mergeSort(left, ascending);
        right = mergeSort(right, ascending);

        // Merge the sorted halves
        return merge(left, right, ascending);
    }

    /**
     * Merges two sorted lists into a single sorted list.
     *
     * @param left The left sorted list.
     * @param right The right sorted list.
     * @param ascending True for ascending order, false for descending order.
     * @return Merged and sorted list.
     */
    private List<gamesModel> merge(List<gamesModel> left, List<gamesModel> right, boolean ascending) {
        List<gamesModel> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge elements in sorted order
        while (i < left.size() && j < right.size()) {
            if (shouldMergeLeft(left.get(i), right.get(j), ascending)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements from left list
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        // Add remaining elements from right list
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    /**
     * Determines whether to take the element from the left list during merge.
     *
     * @param leftElement The current element from the left list.
     * @param rightElement The current element from the right list.
     * @param ascending True for ascending order, false for descending order.
     * @return True if the left element should be taken, false otherwise.
     */
    private boolean shouldMergeLeft(gamesModel leftElement, gamesModel rightElement, boolean ascending) {
        return ascending ? leftElement.getStock() <= rightElement.getStock() 
                         : leftElement.getStock() > rightElement.getStock();
    }
}
