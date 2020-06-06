package com.javarush.task.task35.task3513;

import java.util.*;
import java.util.stream.Collectors;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean  isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[j][i] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 0;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j - 1][i].value)
                    return true;
            }
        }
        return false;
    }

    public void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            emptyTiles.get((int) (Math.random() * emptyTiles.size())).
                    value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean needToAdd = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            needToAdd = compressTiles(gameTiles[i]) || needToAdd;
            needToAdd = mergeTiles(gameTiles[i]) || needToAdd;
        }
        isSaveNeeded = true;
        if (needToAdd) {
            addTile();
        }
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void rollback() {
        if (!previousScores.empty() && !previousStates.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove(){
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                left();
                break;
            case 2:
                up();
                break;
            case 3:
                right();
                break;
            case 4:
                down();
                break;
        }
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Comparator.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        queue.poll().getMove().move();
    }

    private List<Tile> getEmptyTiles() {
        return Arrays.stream(gameTiles).flatMap(Arrays::stream)
                .filter(Tile::isEmpty).collect(Collectors.toList());
    }

    private boolean compressTiles(Tile[] tiles) {
        int hash = Arrays.hashCode(tiles);
        Arrays.sort(tiles, Comparator.comparing(Tile::isEmpty));
        return hash != Arrays.hashCode(tiles);
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean result = false;
        for (int i = 0; i < FIELD_WIDTH - 1 && tiles[i].value != 0; i++) {
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i] = new Tile(tiles[i].value * 2);
                maxTile = Math.max(maxTile, tiles[i].value);
                score += tiles[i].value;
                tiles[i + 1] = new Tile(0);
                compressTiles(tiles);
                result = true;
            }
        }
        return result;
    }

    private void rotate() {
        Tile[][] rotated = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rotated[j][FIELD_WIDTH - 1 - i] = gameTiles[i][j];
            }
        }
        gameTiles = rotated;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] toSave = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                toSave[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(toSave);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    private boolean hasBoardChanged() {
        int currentWeight = Arrays.stream(gameTiles).flatMap(Arrays::stream)
                .mapToInt(t -> t.value).sum();
        int previousWeight = Arrays.stream(previousStates.peek()).flatMap(Arrays::stream)
                .mapToInt(t -> t.value).sum();
        return currentWeight != previousWeight;
    }

    private MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }
}
