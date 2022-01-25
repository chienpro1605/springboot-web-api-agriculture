package com.example.project_agriculture.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pesticide")
public class Pesticide extends AbstractEntity {

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
    @Column(name = "pesticideid")
    private String pesticideId;

    @Size(max = 200)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "usage_information")
    private String usage_information;

    @Column(name = "quarantee_time")
    private Integer quarantee_time;

    @ManyToOne
    @JoinColumn(name = "activityid", referencedColumnName = "activityid")
    private Activity activity;
}
