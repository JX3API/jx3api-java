package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 科举试题
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ExamAnswerData {
    @JsonProperty("id")
    private int id;

    @JsonProperty("question")
    private String question;

    @JsonProperty("answer")
    private String answer;

    @JsonProperty("correctness")
    private int correctness;

    @JsonProperty("index")
    private int index;

    @JsonProperty("pinyin")
    private String pinyin;
}
