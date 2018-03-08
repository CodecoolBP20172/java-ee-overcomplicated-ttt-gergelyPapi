package main.java.com.codecool.enterprise.tictactoeai.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicTacToeService {

    ArrayList<Integer> playerStepList = new ArrayList<>();
    ArrayList<Integer> aiStepList = new ArrayList<>();

    public Integer getCellForAiStep (Map <String, String> playerSelectedCell) {
        addToPlayerStepList(Integer.parseInt(playerSelectedCell.get("playerSelectedCell")));
        return getRandomCellBasedOnGlobalCellList ();
    }

    public void addToPlayerStepList(Integer playerSelectedCell) {
        playerStepList.add(playerSelectedCell);
    }

    public void addToAiStepList(Integer aiSelectedCell) {
        aiStepList.add(aiSelectedCell);
    }


    public Integer getRandomCellBasedOnGlobalCellList () {
        Random randomObject = new Random ();
        int randomNum = randomObject.nextInt(9) + 1;
        while(playerStepList.contains(randomNum) || aiStepList.contains(randomNum)){
            randomNum = randomObject.nextInt(9) + 1;
            if ((playerStepList.size() + aiStepList.size()) == 9) {
                return null;
            }
        }
        return randomNum;
    }

    public String checkWinningCondition () {
        ArrayList<List<Integer>> winningConditionCollection = new ArrayList<>();
        winningConditionCollection.add(Arrays.asList(1, 2, 3));
        winningConditionCollection.add(Arrays.asList(4, 5, 6));
        winningConditionCollection.add(Arrays.asList(7, 8, 9));
        winningConditionCollection.add(Arrays.asList(1, 4, 7));
        winningConditionCollection.add(Arrays.asList(2, 5, 8));
        winningConditionCollection.add(Arrays.asList(3, 6, 9));
        winningConditionCollection.add(Arrays.asList(1, 5, 9));
        winningConditionCollection.add(Arrays.asList(3, 5, 7));

        Collections.sort(playerStepList);
        Collections.sort(aiStepList);

        for (int i = 0; i < winningConditionCollection.size(); i ++) {
            if (playerStepList.equals(winningConditionCollection.get(i))) {
                playerStepList = new ArrayList<>();
                return "player";
            }
            if (aiStepList.equals(winningConditionCollection.get(i))) {
                aiStepList = new ArrayList<>();
                return "ai";
            }
        }
        return "";
    }
}
