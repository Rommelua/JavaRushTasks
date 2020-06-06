package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    public static class Goods{
        public List<String> names;
    }

    @Override
    public String toString() {

        return "goods: " + "\n"
                + goods.names.get(0) + "\n"
                + goods.names.get(1) + "\n"
                + "count = " + count + "\n"
                + "profit = " + profit + "\n"
                + Arrays.toString(secretData);
    }
}
