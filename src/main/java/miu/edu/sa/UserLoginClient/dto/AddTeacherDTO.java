package miu.edu.sa.UserLoginClient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddTeacherDTO {
    private String userName;
    private String teacherNumber;
    private String firstName;
    private String lastname;
    private School school;
    private Contact contact;
    private TeachingClass teachingclass;
    private String password;


}
