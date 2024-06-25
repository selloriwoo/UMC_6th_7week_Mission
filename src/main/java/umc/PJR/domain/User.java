package umc.PJR.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

//    @Column(nullable = false, length = 20)
//    private String birthday;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 100)
    private String specAddress;

    @ColumnDefault("0")
    private Integer missionPoint;

    //@Column(nullable = false, length = 40) 원래 이메일을 소셜 로그인에서 처리 한 후, 나머지 정보를 기입 받는 것이 맞는 순서이나,
    // 소셜 로그인 없이 하는 중이라 이메일은 nullable로 바꾸고 진행하겠습니다.
    private String email;

    @Column(nullable = true, length = 20)
    private String tel;

    @Column(nullable = true, length = 20)
    private String nickname;

    private LocalDate inactiveDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
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