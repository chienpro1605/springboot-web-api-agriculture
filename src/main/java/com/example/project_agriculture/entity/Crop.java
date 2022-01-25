package com.example.project_agriculture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crop")
public class Crop extends AbstractEntity {

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
    @Column(name = "cropid")
    private String cropId;

    @ManyToOne
    @JoinColumn(name = "cooperativeid", referencedColumnName = "cooperativeid")
    private Cooperative cooperative;

    @Size(max = 200)
    @Column(name = "name")
    private String name;

    @Size(max = 200)
    @Column(name = "location")
    private String location;

    @Size(max = 200)
    @Column(name = "field")
    private String field;

    @Column(name = "area")
    private Integer area;

    @ManyToOne
    @JoinColumn(name = "tree_typeid", referencedColumnName = "tree_typeid")
    private TreeType treeType;

    @NotBlank
    @Size(max = 100)
    @Column(name = "cultivar_name")
    private String cultivarName;

    @Column(name = "output_quantity")
    private Integer outputQuantity;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "created_time")
    private Timestamp created_time;

    @OneToMany
    private List<Users> users;
}
