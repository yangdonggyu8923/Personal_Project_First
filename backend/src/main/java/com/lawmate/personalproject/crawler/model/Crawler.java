package com.lawmate.personalproject.crawler.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Crawler {
    private String name;
    private String subject;
    private String imgUrl;
    private String birth;
    private String office;
    private String address;


}
