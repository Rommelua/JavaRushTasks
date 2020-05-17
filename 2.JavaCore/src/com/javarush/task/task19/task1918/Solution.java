package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"span"};
        String text;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            text = reader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(text))) {
            text = reader.lines().collect(Collectors.joining());
        }

        Document document = Jsoup.parse(text,  "", Parser.xmlParser());
        //Document document = Jsoup.parse(new File(text), "UTF-8");
        Elements elements = document.select(args[0]);
        //Elements elements = document.getElementsByTag(args[0]);
        for (Element element : elements) {
            System.out.println(element);
        }
    }
}
