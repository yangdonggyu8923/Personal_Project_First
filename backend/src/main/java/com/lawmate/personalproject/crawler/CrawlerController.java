package com.lawmate.personalproject.crawler;

import com.lawmate.personalproject.crawler.model.Crawler;
import com.lawmate.personalproject.crawler.service.CrawlerServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("api/crawlers")
@Slf4j
public class CrawlerController {

    private final CrawlerServiceImpl service;

    @GetMapping("/list")
    public List<Crawler> crawl() throws IOException {
        log.info("크롤링 실행");
        return service.crawl();
    }
}
