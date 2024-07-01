package umc.PJR.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.PJR.domain.enums.RestaurantType;
import umc.PJR.domain.mapping.FoodPreference;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RestaurantType name;

    @OneToMany(mappedBy = "foodType", cascade = CascadeType.ALL)
    private List<FoodPreference> foodPreferenceList = new ArrayList<>();
}
