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
public class binarySearch {
    /**
     * Performs binary search on a sorted list of gamesModel objects.
     * 
     * @param searchValue The value to search for.
     * @param gamesList The sorted list of gamesModel objects.
     * @param left The starting index of the search range.
     * @param right The ending index of the search range.
     * @param searchByName True to search by product name, false to search by ID.
     * @return The found gamesModel object, or null if not found.
     */
    public gamesModel search(String searchValue, List<gamesModel> gamesList, int left, int right, boolean searchByName) {
        if (right < left) {
            return null; // Base case: not found
        }

        int mid = (left + right) / 2;

        if (searchByName) {
            // Compare product name
            int comparison = searchValue.compareToIgnoreCase(gamesList.get(mid).getProductname());
            if (comparison == 0) {
                return gamesList.get(mid);
            } else if (comparison < 0) {
                return search(searchValue, gamesList, left, mid - 1, true);
            } else {
                return search(searchValue, gamesList, mid + 1, right, true);
            }
        } else {
            // Compare ID
            int idToSearch = Integer.parseInt(searchValue);
            int midId = gamesList.get(mid).getID();
            if (midId == idToSearch) {
                return gamesList.get(mid);
            } else if (idToSearch < midId) {
                return search(searchValue, gamesList, left, mid - 1, false);
            } else {
                return search(searchValue, gamesList, mid + 1, right, false);
            }
        }
    }

}
