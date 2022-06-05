package edu.aluismarte.diplomado.model.week5;

import lombok.*;

import java.util.List;

/**
 * @author aluis on 5/1/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ChuckNorrisJoke {

    private String id;
    private List<String> categories;

    private String url;
    private String icon_url;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SS")
    private String created_at;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SS")
    private String updated_at;

    private String value;

}
