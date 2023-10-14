package dev.yogizogi.infra.s3.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@Schema(name = "객체 업로드 주소 발행 요청 Dto", description = "객체 업로드에 필요한 정보")
public class IssuePreSignedInDto {

    @Schema(description = "객체 주인에 대한 식별자")
    @NotBlank(message = "식별자를 입력해주세요.")
    private String id;

    @Schema(description = "업로드할 객체 개수", example = "1")
    @NotBlank(message = "업로드 할 파일 개수를 입력해주세요.")
    private Long number;

    @Schema(description = "폴더 이름", example = "profile")
    @NotBlank(message = "객체를 저장할 폴더 이름을 입력해주세요.")
    private String directory;

}
