package com.utc.nckh.domain.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private AppUserRole role;
    private String imageName;

}
