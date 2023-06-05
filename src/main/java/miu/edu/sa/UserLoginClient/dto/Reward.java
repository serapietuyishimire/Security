package miu.edu.sa.UserLoginClient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reward {
    private String id;
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
