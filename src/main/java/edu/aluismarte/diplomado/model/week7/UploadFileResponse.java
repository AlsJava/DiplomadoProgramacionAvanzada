package edu.aluismarte.diplomado.model.week7;

import lombok.*;

/**
 * @author aluis on 5/9/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UploadFileResponse {

    private String message;
    private Long fileSize;
}
