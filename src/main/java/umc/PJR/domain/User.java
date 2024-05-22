package umc.PJR.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.PJR.domain.common.BaseEntity;
import umc.PJR.domain.enums.Gender;
import umc.PJR.domain.enums.UserStatus;
import umc.PJR.domain.mapping.FoodPreference;
import umc.PJR.domain.mapping.UserMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    //@Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 20)
    private String birthday;

    @Column(nullable = false, length = 100)
    private String address;

    private Long missionPoint;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = true, length = 20)
    private String tel;

    @Column(nullable = false, length = 20)
    private String nickname;

    private LocalDate inactiveDate;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FoodPreference> foodPreferenceList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Inquery> inqueryList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();
}