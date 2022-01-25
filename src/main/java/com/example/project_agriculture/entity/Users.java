package com.example.project_agriculture.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }), @UniqueConstraint(columnNames = {
        "mobile"
})
})
public class Users extends AbstractEntity {

    private static final String MOBILE_REGEX = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            })
    @Column(name = "userid")
    private String userId;

    @NotBlank
    @Size(max = 200)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max = 200)
    @Column(name = "password")
    private String password;

    @NotBlank
    @Size(max = 100)
    @Column(name = "name_user")
    private String name_user;

    @Column(name = "status")
    private Integer status;

    @Column(name = "groupid")
    private String groupId;

    @Column(name = "created_time")
    private Timestamp created_time;

    @Column(name = "last_login_time")
    private Timestamp last_login_time;

    @Size(max = 200)
    @Column(name = "address")
    private String address;

    @NotBlank
    @Size(max = 20)
    @Column(name = "mobile")
    private String mobile;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "avatar")
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "userid"),inverseJoinColumns = @JoinColumn(name = "roleid"))
    Set<Role> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cooperativeid", referencedColumnName = "cooperativeid")
    private Cooperative cooperative;

    @ManyToOne
    @JoinColumn(name = "cropid", referencedColumnName = "cropid")
    private Crop crop;

    public Users(@NotBlank @Size(max = 100)String name,
                 @NotBlank @Size(max = 100)String username,
                 @NotBlank @Size(max = 20) String mobile,
                 @NotBlank @Size(min = 6, max = 100) String encode) {
        this.name_user = name;
        this.username = username;
        this.mobile = mobile;
        this.password = encode;
    }
    public Users(@NotBlank @Size(max = 100)String name,
                 @NotBlank @Size(max = 100)String username,
                 @NotBlank @Size(max = 200)String address,
                 @NotBlank Date birthday,
                 Cooperative cooperative,
                 @NotBlank @Pattern(regexp = MOBILE_REGEX, flags = Pattern.Flag.UNICODE_CASE)String mobile,
                 String avatar,
                 @NotBlank String groupId,
                 @NotBlank @Size(min = 6, max = 100) @Pattern(regexp = PASSWORD_REGEX, flags = Pattern.Flag.UNICODE_CASE)String encode) {
        this.name_user = name;
        this.username = username;
        this.address = address;
        this.birthday = birthday;
        this.cooperative = cooperative;
        this.mobile = mobile;
        this.avatar = avatar;
        this.groupId = groupId;
        this.password = encode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
