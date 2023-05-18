package com.vap.projectM.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="Customer_Stg")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String dob;
    private String panId;
    private String city;

    @ManyToOne()
    private PossibleMergeTable possibleMergeTable;
}
