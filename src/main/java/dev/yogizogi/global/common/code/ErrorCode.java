package dev.yogizogi.global.common.code;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    /**
     * Code : 400
     * - Bad Request
     */
    FAIL_TO_TEST(HttpStatus.BAD_REQUEST, "요청 실패"),
    FAIL_TO_VALIDATE(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    FAIL_TO_SEND_MESSAGE(HttpStatus.BAD_REQUEST, "인증번호 전송 실패"),
    FAIL_TO_GET_COORDINATE(HttpStatus.BAD_REQUEST, "좌표 조회 실패"),
    FAIL_TO_REMOVE_RESTAURANT_ON_MEOK_MAP(HttpStatus.BAD_REQUEST, "먹지도에서 음식점 삭제를 실패했습니다."),

    ALREADY_USE_PHONE_NUMBER(HttpStatus.BAD_REQUEST, "이미 사용중인 핸드폰 번호입니다."),
    ALREADY_USE_NICKNAME(HttpStatus.BAD_REQUEST, "이미 사용중인 닉네임입니다."),
    ALREADY_USE_PASSWORD(HttpStatus.BAD_REQUEST, "이미 사용중인 비밀번호입니다."),

    INVALID_RESTAURANT_TYPE(HttpStatus.BAD_REQUEST, "유효하지 않은 음식점 종류입니다."),
    INVALID_YOGI_MOOD(HttpStatus.BAD_REQUEST, "유효하지 않은 요기무드입니다."),

    /**
     * Code : 401
     */
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    EMPTY_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 없습니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다." ),

    /**
     * Code : 403
     * - Forbidden (요청한 자원에 대해 권한 없음)
     */
    FAIL_TO_LOGIN(HttpStatus.FORBIDDEN, "핸드폰 번호 또는 비밀번호를 잘못 입력했습니다."),
    FAIL_TO_REVIEW_UNAUTHORIZED_RESTAURANT(HttpStatus.FORBIDDEN, "권한이 없는 음식점입니다."),
    FAIL_TO_REVIEW_UNAUTHORIZED_REVIEW(HttpStatus.NOT_FOUND, "권한이 없는 리뷰입니다."),

    /**
     * Code : 404
     * - Not Found (존재하지 않는 자원임)
     */
    NOT_EXIST_PHONE_NUMBER(HttpStatus.NOT_FOUND, "존재하지 않는 핸드폰 번호입니다."),
    NOT_EXIST_USER(HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다."),
    NOT_EXIST_RESTAURANT(HttpStatus.NOT_FOUND, "존재하지 않는 음식점입입다."),
    NOT_EXIST_REVIEW(HttpStatus.NOT_FOUND, "존재하지 않는 리뷰입니다."),
    NOT_EXIST_MENU(HttpStatus.NOT_FOUND, "존재하지 않는 메뉴입니다."),
    NOT_EXIST_MEOK_MAP(HttpStatus.NOT_FOUND, "존재하지 않는 먹지도입니다."),
    NOT_EXIST_RESTAURANT_ON_MEOK_MAP(HttpStatus.NOT_FOUND, "먹지도에 존재하지 않는 음식점입니다."),
    NOT_EXIST_MENU_REVIEW(HttpStatus.NOT_FOUND, "존재하지 않는 메뉴 리뷰입니다."),

    /**
     * Code : 500
     * - INTERNAL_SERVER_ERROR (서버 오류)
     */
    FAIL_TO_CREATE_JWT(HttpStatus.INTERNAL_SERVER_ERROR, "JWT를 생성하지 못했습니다."),
    FAIL_TO_EXTRACT_SUBJECT(HttpStatus.INTERNAL_SERVER_ERROR, "Subject를 추출할 수 없습니다.");

    private final HttpStatus code;
    private final String message;

}
