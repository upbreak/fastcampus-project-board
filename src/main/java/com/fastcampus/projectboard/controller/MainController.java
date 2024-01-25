package com.fastcampus.projectboard.controller;

import com.fastcampus.projectboard.dto.response.ArticleCommentResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * 메인 컨트롤러
 * swagger javadoc 테스트
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String root(){

        return "forward:/articles";
    }

    /**
     * 댓글 정보를 열람한다.
     *
     * @param id 댓글ID
     * @return 댓글 응답
     */
    @ResponseBody
    @GetMapping("/test-rest")
    public ArticleCommentResponse test(Long id){
        return ArticleCommentResponse.of(
                id
                , "content"
                , "userId"
                , LocalDateTime.now()
                , "email@eamil.com"
                , "nickname"
        );
    }
}
