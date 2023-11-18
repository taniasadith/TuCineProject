package com.TuCine.AccountManagement.domain.model;

import com.TuCine.AccountManagement.domain.enumeration.Genders;
import jakarta.persistence.*;
import lombok.*;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //For connection
    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 10, nullable = false)
    private Genders name;
}
