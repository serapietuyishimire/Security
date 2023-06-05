package miu.edu.sa.UserLoginClient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private String studentNumber;

    private double score = 1000.00;

    private ClassRoom classRoom;

    private Avatar avatar;

    private List<Reward> rewardList = new ArrayList<>();

    private School school;

    private List<Element> elementList = new ArrayList<>();

    public void addElement(Element element) {
        elementList.add(element);
    }
}
