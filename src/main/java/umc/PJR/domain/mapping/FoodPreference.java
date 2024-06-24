package umc.PJR.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.PJR.domain.FoodType;
import umc.PJR.domain.User;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodType_id")
    private FoodType foodType;

    public void setUser(User user){
        if(this.user != null)
            user.getFoodPreferenceList().remove(this);
        this.user = user;
        user.getFoodPreferenceList().add(this);
    }

    public void setFoodType(FoodType foodType){
        this.foodType = foodType;
    }
}
