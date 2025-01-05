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
public class selectionSort {
    List<gamesModel> gamesSortList;

    public selectionSort(){
        gamesSortList = new ArrayList<>();
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param gamesSortList the list of gamesModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<gamesModel> gamesSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < gamesSortList.size(); j++) {
            if (shouldSwap(gamesSortList.get(j).getID(), gamesSortList.get(extremumIndex).getID(), isDesc)) {
                extremumIndex = j;
            }
        }
        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current value should replace the extremum; false otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param gamesSortList the list of gamesModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<gamesModel> gamesSortList, int i, int j) {
        gamesModel temp = gamesSortList.get(i);
        gamesSortList.set(i, gamesSortList.get(j));
        gamesSortList.set(j, temp);
    }

    /**
     * Sorts a list of gamesModel objects by their ID in ascending or descending order.
     *
     * @param gamesList the list of gamesModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<gamesModel> sortById(List<gamesModel> gamesList, boolean isDesc) {
        this.gamesSortList.clear();
        this.gamesSortList.addAll(gamesList);

        if (gamesSortList == null || gamesSortList.isEmpty()) {
            throw new IllegalArgumentException("Games list cannot be null or empty.");
        }
        for (int i = 0; i < gamesSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(gamesSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(gamesSortList, i, extremumIndex);
            }
        }
        return gamesSortList;
    }
}
