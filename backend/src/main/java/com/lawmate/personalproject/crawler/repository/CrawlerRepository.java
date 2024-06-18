package com.lawmate.personalproject.crawler.repository;

import com.lawmate.personalproject.crawler.model.Crawler;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class CrawlerRepository {

    public List<Crawler> crawl() throws IOException {
        List<Crawler> ls = new ArrayList<>();
        System.out.println("크롤링 실행");

        for (int page = 1; page <= 5; page++) {
            Document doc = Jsoup.connect("https://www.koreanbar.or.kr/pages/search/search1.asp?sido1=&gun1=&dong1=&special1_1=&special1=1&searchtype=mname&searchstr=&page=" + page).timeout(10 * 1000).get();
            Elements rows = doc.select("div.board_listW tr");

            for (Element row : rows) {
                Element nameElement = row.select("td:nth-child(3) a").first();
                String name = "";
                if (nameElement != null) {
                    name = nameElement.ownText().trim();
                }

                String subject = row.select("td:nth-child(4) li").text();
                subject = subject.replaceAll("\\(.*?\\)", "");

                String imgUrl = row.select("td:nth-child(2) img").attr("src");
                String birth = row.select("td:nth-child(5)").text();
                String office = row.select("td:nth-child(6)").text();
                String address = row.select("td:nth-child(7)").text();
                if (!name.isEmpty()) {
                    ls.add(new Crawler(imgUrl, name, birth, office, address, subject));
                }
            }
        }

        System.out.println("크롤링 종료");

        return ls;
    }
}
