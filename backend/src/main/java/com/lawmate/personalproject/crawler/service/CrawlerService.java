package com.lawmate.personalproject.crawler.service;

import com.lawmate.personalproject.crawler.model.Crawler;

import java.io.IOException;
import java.util.List;

public interface CrawlerService {
    List<Crawler> crawl() throws IOException;
}
