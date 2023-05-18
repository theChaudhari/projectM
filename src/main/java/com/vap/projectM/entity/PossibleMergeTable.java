package com.vap.projectM.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PossibleMergeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "possibleMergeTable")
    private List<User> user;
    private String firstName;
    private String lastName;
    private String phone;
    private String dob;
    private String panId;
    private String city;
}
