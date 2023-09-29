package dev.yogizogi.domain.auth.model.dto.response;

import dev.yogizogi.global.common.status.MessageStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Schema(name = "인증코드 전송 응답 Dto")
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class SendVerificationCodeOutDto {

    @Schema(description = "전송 결과", allowableValues = {"SUCCESS", "FAIL"})
    private MessageStatus status;

    @Schema(description = "이유")
    private String message;

    public static SendVerificationCodeOutDto of(MessageStatus status, String message) {
        return SendVerificationCodeOutDto.builder()
                .status(status)
                .message(message)
                .build();
    }
}