package miu.edu.sa.UserLoginClient.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddStudentDTO {
    private long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private Contact contact;
    private School school;
}
