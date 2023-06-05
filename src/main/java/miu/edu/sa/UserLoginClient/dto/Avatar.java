package miu.edu.sa.UserLoginClient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Avatar {
    private String id;
    private String head;
    private String hair;
    private String eye;
    private String eyebrow;
    private String nose;
    private String mouth;
    private String ears;
    private String body;
    private String hat;
    private String top;
    private String topColour;
    private String hatColour;
}
