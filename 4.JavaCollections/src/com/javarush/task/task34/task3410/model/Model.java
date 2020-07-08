package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public final static int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("4.JavaCollections/src/com/javarush/task/task34/task3410/res/levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction) {
        Player player = getGameObjects().getPlayer();
        if (checkWallCollision(player, direction)
                || checkBoxCollisionAndMoveIfAvailable(direction)) return;
        moveToDirection(player, direction);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        return getGameObjects().getWalls().stream()
                .anyMatch(wall -> gameObject.isCollision(wall, direction));
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        Box box = boxCollision(getGameObjects().getPlayer(), direction);
        if (box != null && (boxCollision(box, direction) != null || checkWallCollision(box, direction))) {
            return true;
        }
        if (box != null) {
            moveToDirection(box, direction);
        }
        return false;
    }

    private Box boxCollision(CollisionObject gameObject, Direction direction) {
        return getGameObjects().getBoxes().stream()
                .filter(b -> gameObject.isCollision(b, direction))
                .findAny().orElse(null);
    }

    private void moveToDirection(Movable movable, Direction direction) {
        switch (direction) {
            case UP:
                movable.move(0, FIELD_CELL_SIZE * (-1));
                break;
            case DOWN:
                movable.move(0, FIELD_CELL_SIZE);
                break;
            case LEFT:
                movable.move(FIELD_CELL_SIZE * (-1), 0);
                break;
            case RIGHT:
                movable.move(FIELD_CELL_SIZE, 0);
        }
    }

    public void checkCompletion() {
        boolean isComplete = getGameObjects().getHomes().stream()
                .allMatch(this::hasBox);
        if (isComplete) {
            eventListener.levelCompleted(currentLevel);
        }
    }

    private boolean hasBox(Home home) {
        return getGameObjects().getBoxes().stream()
                .anyMatch(box -> box.getX() == home.getX() && box.getY() == home.getY());
    }
}
