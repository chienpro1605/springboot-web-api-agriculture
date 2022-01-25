package com.example.project_agriculture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cooperative_member")
public class CooperativeMember extends AbstractEntity {

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
    @Column(name = "cooperative_memberid")
    private String cooperativeMemberId;

    @ManyToOne
    @JoinColumn(name = "cooperativeid", referencedColumnName = "cooperativeid")
    private Cooperative cooperative;

//    @JsonIgnore
//    @OneToMany(mappedBy = "cooperativeMember", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Users> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cooperative_member_role",
            joinColumns = @JoinColumn(name = "cooperative_memberid"),inverseJoinColumns = @JoinColumn(name = "roleid"))
    Set<Role> roles = new HashSet<>();
}
