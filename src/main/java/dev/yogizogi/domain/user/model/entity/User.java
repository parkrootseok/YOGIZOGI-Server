package dev.yogizogi.domain.user.model.entity;

import dev.yogizogi.domain.meokmap.model.entity.MeokMap;
import dev.yogizogi.domain.meokprofile.model.entity.MeokProfile;
import dev.yogizogi.domain.review.model.entity.Review;
import dev.yogizogi.global.common.model.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Embedded
    private Profile profile;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FirstLoginStatus firstLoginStatus;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authority> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meok_profile_id")
    private MeokProfile meokProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private MeokMap meokMap;


    public void setMeokProfile(MeokProfile meokProfile) {
        this.meokProfile = meokProfile;
    }

    public void setProfile(String nickname, String imageUrl, String introduction) {
        this.profile = Profile.builder()
                .nickname(nickname)
                .imageUrl(imageUrl)
                .introduction(introduction)
                .build();

    }

    public void setRoles(List<Authority> roles) {
        this.roles = roles;
        roles.forEach(role -> role.setUser(this));
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateFirstLoginStatus(FirstLoginStatus firstLoginStatus) {
        this.firstLoginStatus = firstLoginStatus;
    }

    @Builder
    public User(UUID id, String phoneNumber, String password, FirstLoginStatus firstLoginStatus) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.firstLoginStatus = FirstLoginStatus.ACTIVE;
    }

}
