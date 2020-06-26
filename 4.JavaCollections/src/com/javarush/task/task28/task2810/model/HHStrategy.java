package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private final static String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int pageValue = 0;
        try {
            Document document = getDocument(searchString, pageValue);
            Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            while (elements.size() > 0) {
                for (Element element : elements) {
                    if (element != null) {
                        Vacancy vac = new Vacancy();
                        vac.setTitle(element.getElementsByAttributeValueContaining("data-qa", "title").text());
                        vac.setCity(element.getElementsByAttributeValueContaining("data-qa", "address").text());
                        vac.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                        vac.setSiteName(URL_FORMAT);
                        String urlPage = element.getElementsByAttributeValueContaining("data-qa", "title").attr("href");
                        vac.setUrl(urlPage);
                        String salary = element.getElementsByAttributeValueContaining("data-qa", "compensation").text();
                        vac.setSalary(salary.length() == 0 ? "" : salary);
                        result.add(vac);

                    }
                }
                document = getDocument(searchString, ++pageValue);
                elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (jsoup)").referrer("").get();
    }
}
