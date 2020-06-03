package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private List<Entry<String>> elements = new ArrayList<>();

    public CustomTree() {
        root = new Entry<>("0");
        elements.add(root);
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public void removeChild(Entry child) {
            if (leftChild != null && leftChild.elementName.equals(child.elementName)) {
                leftChild = null;
            } else if (rightChild != null && rightChild.elementName.equals(child.elementName)) {
                rightChild = null;
            }
            if (leftChild == null && rightChild == null) {
                availableToAddLeftChildren = true;
                availableToAddRightChildren = true;
            }
        }
    }
    @Override
    public boolean add(String s) {
        Entry<String> newEntry = new Entry(s);
        for (Entry<String> entry : elements) {
            if (entry.availableToAddLeftChildren) {
                entry.leftChild = newEntry;
                newEntry.parent = entry;
                elements.add(newEntry);
                entry.availableToAddLeftChildren = false;
                return true;
            }
            if (entry.availableToAddRightChildren) {
                entry.rightChild = newEntry;
                newEntry.parent = entry;
                elements.add(newEntry);
                entry.availableToAddRightChildren = false;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return elements.size() - 1;
    }


    public String getParent(String s) {
        for (Entry<String> entry : elements) {
            if (entry.elementName.equals(s)) {
                return entry.parent.elementName;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        String delName = (String) o;
        for (Entry<String> entry : elements) {
            if (entry.elementName.equals(delName)) {
                elements.remove(entry);
                entry.parent.removeChild(entry);
                if (entry.leftChild != null) {
                    remove(entry.leftChild.elementName);
                }
                if (entry.rightChild != null) {
                    remove(entry.rightChild.elementName);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
