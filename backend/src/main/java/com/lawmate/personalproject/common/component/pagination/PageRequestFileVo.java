//package com.lawmate.personalproject.common.component.pagination;
//
//import com.james.api.article.model.ArticleDto;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Data
//@AllArgsConstructor
//@Builder
//public class PageRequestFileVo {    // 파일을 페이지 단위로 요청한다
//    private int page;
//    private int size;
//    private String type;
//    private String keyword;
//
//    private List<ArticleDto> pageFileDto;
//
//    public PageRequestFileVo() {
//        this.page = 1;
//        this.size = 10;
//    }
//
//    public Pageable getPageable(Sort sort){
//        return PageRequest.of(1,size,sort);
//    }
//}
