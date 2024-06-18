package com.lawmate.personalproject.crawler.service;


import com.lawmate.personalproject.crawler.model.Crawler;
import com.lawmate.personalproject.crawler.repository.CrawlerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrawlerServiceImpl implements CrawlerService {
    private final CrawlerRepository repository;

    @Override
    public List<Crawler> crawl() throws IOException {
        return repository.crawl();
    }
}
