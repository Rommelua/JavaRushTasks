package com.javarush.task.task35.task3513;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
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

    public void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            emptyTiles.get((int) (Math.random() * emptyTiles.size())).
                    value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        return Arrays.stream(gameTiles).flatMap(Arrays::stream)
                .filter(Tile::isEmpty).collect(Collectors.toList());
    }

    private void compressTiles(Tile[] tiles) {
        Arrays.sort(tiles, Comparator.comparing(Tile::isEmpty));
    }

    private void mergeTiles(Tile[] tiles) {
        for (int i = 0; i < FIELD_WIDTH - 1 && tiles[i].value != 0; i++) {
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i] = new Tile(tiles[i].value * 2);
                maxTile = Math.max(maxTile, tiles[i].value);
                score += tiles[i].value;
                tiles[i + 1] = new Tile(0);
                compressTiles(tiles);
            }
        }
    }
}
