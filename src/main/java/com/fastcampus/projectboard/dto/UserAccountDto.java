package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.UserAccount;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.fastcampus.projectboard.domain.UserAccount}
 */
public record UserAccountDto(
        String userId
        , String userPassword
        , String email
        , String nickname
        , String memo
        , LocalDateTime createAt
        , String createBy
        , LocalDateTime modifiedAt
        , String modifiedBy
) {
    public static UserAccountDto of(String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createAt, String createBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(userId, userPassword, email, nickname, memo, createAt, createBy, modifiedAt, modifiedBy);
    }

    public static UserAccountDto from(UserAccount entity){
        return new UserAccountDto(
                entity.getUserId()
                , entity.getUserPassword()
                , entity.getEmail()
                , entity.getNickname()
                , entity.getMemo()
                , entity.getCreateAt()
                , entity.getCreateBy()
                , entity.getModifiedAt()
                , entity.getModifiedBy()
        );
    }

    public UserAccount toEntity(){
        return UserAccount.of(
                userId
                , userPassword
                , email
                , nickname
                , memo
        );
    }
}