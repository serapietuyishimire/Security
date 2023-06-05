package miu.edu.sa.UserLoginClient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentRewardDto {

    private String studentNumber;

    private String elementId;
}
