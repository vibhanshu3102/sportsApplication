package com.app.gloesports.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/*
    task is to add the required annotation to make this class a JPA entity
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Equipment {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
        task is to add a new column type of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @NotNull
    private String type;
    /*
        task is to add a new column brand of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @NotNull
    private String brand;
    /*
        task is to add a new column model of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @NotNull
    private String model;

    /*
        task is to establish the mapping between User and Equipment
        it should be a appropriate mapping as per the diagram
     */

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
