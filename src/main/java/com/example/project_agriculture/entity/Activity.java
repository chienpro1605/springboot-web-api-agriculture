package com.example.project_agriculture.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activity")
public class Activity extends AbstractEntity {

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
    @Column(name = "activityid")
    private String activityId;

    @ManyToOne
    @JoinColumn(name = "cropid", referencedColumnName = "cropid")
    private Crop crop;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users users;

    @Size(max = 200)
    @Column(name = "name")
    private String name;

    @Column(name = "activity_date")
    private Date activityDate;

    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigInteger cost;

    @Column(name = "revenue")
    private BigInteger revenue;

    @Column(name = "created_time")
    private Timestamp created_time;

    @ManyToOne
    @JoinColumn(name = "pesticideid", referencedColumnName = "pesticideid")
    private Pesticide pesticide;

    @Column(name = "working_day")
    private Date working_day;

    @Column(name = "warning")
    private String warning;

    public Activity(String activityId, Date working_day) {
        this.activityId = activityId;
        this.working_day = working_day;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Date getWorking_day() {
        return working_day;
    }

    public void setWorking_day(Date working_day) {
        this.working_day = working_day;
    }
}
