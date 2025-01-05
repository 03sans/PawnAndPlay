/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pawnandplay.controller;
import com.pawnandplay.model.gamesModel;
import java.util.List;
/**
 *
 * @author 23048503_SanskritiAgrahari
 */
public class insertionSort {
    /**
     * Sorts a list of gamesModel objects alphabetically by productName.
     *
     * @param gamesList List of gamesModel objects to sort.
     * @return Sorted list in alphabetical order.
     */
    public List<gamesModel> sortAlphabetically(List<gamesModel> gamesList) {
        return sort(gamesList, true);
    }

    /**
     * Sorts a list of gamesModel objects in reverse alphabetical order by productName.
     *
     * @param gamesList List of gamesModel objects to sort.
     * @return Sorted list in reverse alphabetical order.
     */
    public List<gamesModel> sortReverseAlphabetically(List<gamesModel> gamesList) {
        return sort(gamesList, false);
    }

    /**
     * sorting logic for insertion sort.
     * 
     * @param gamesList List of gamesModel objects to sort.
     * @param ascending True for alphabetical order, false for reverse order.
     * @return Sorted list of gamesModel objects.
     */
    private List<gamesModel> sort(List<gamesModel> gamesList, boolean ascending) {
        for (int i = 1; i < gamesList.size(); i++) {
            gamesModel key = gamesList.get(i);
            int insertPosition = findInsertPosition(gamesList, key, i, ascending);
            shiftRight(gamesList, insertPosition, i);
            gamesList.set(insertPosition, key);
        }
        return gamesList;
    }

    /**
     * Finds the correct position for the current key.
     *
     * @param gamesList List of gamesModel objects.
     * @param key The gamesModel object being positioned.
     * @param endIndex The current end of the sorted portion of the list.
     * @param ascending True for alphabetical order, false for reverse order.
     * @return The index where the key should be inserted.
     */
    private int findInsertPosition(List<gamesModel> gamesList, gamesModel key, int endIndex, boolean ascending) {
        int j = endIndex - 1;
        while (j >= 0 && shouldSwap(gamesList.get(j), key, ascending)) {
            j--;
        }
        return j + 1;
    }

    /**
     * Determines whether two elements should be swapped based on the sorting order.
     *
     * @param a The first gamesModel object to compare.
     * @param b The second gamesModel object to compare.
     * @param ascending True for alphabetical order, false for reverse order.
     * @return True if swapping is needed, false otherwise.
     */
    private boolean shouldSwap(gamesModel a, gamesModel b, boolean ascending) {
        int comparison = a.getProductname().compareToIgnoreCase(b.getProductname());
        return ascending ? comparison > 0 : comparison < 0;
    }

    /**
     * Shifts elements to the right to make space for the key.
     *
     * @param gamesList List of gamesModel objects.
     * @param start The starting index for shifting.
     * @param end The ending index for shifting.
     */
    private void shiftRight(List<gamesModel> gamesList, int start, int end) {
        for (int k = end; k > start; k--) {
            gamesList.set(k, gamesList.get(k - 1));
        }
    }
}
