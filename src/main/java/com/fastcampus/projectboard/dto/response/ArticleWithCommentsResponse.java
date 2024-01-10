package com.fastcampus.projectboard.dto.response;

import com.fastcampus.projectboard.dto.ArticleWithCommentsDto;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleWithCommentsResponse(
        Long id
        , String title
        , String content
        , String hashtag
        , LocalDateTime createAt
        , String email
        , String nickname
        , Set<ArticleCommentResponse> articleCommentsResponse
) {
    public static ArticleWithCommentsResponse of(Long id, String title, String content, String hashtag, LocalDateTime createAt, String email, String nickname, Set<ArticleCommentResponse> articleCommentResponses) {
        return new ArticleWithCommentsResponse(id, title, content, hashtag, createAt, email, nickname, articleCommentResponses);
    }

    public static ArticleWithCommentsResponse from(ArticleWithCommentsDto dto){
        String nickname = dto.userAccountDto().nickname();
        if(nickname == null || nickname.isBlank()){
            nickname = dto.userAccountDto().userId();
        }

        return new ArticleWithCommentsResponse(
                dto.id()
                , dto.title()
                , dto.content()
                , dto.hashtag()
                , dto.createAt()
                , dto.userAccountDto().email()
                , nickname
                , dto.articleCommentDtos().stream()
                        .map(ArticleCommentResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }
}
