package com.TuCine.AccountManagement.domain.model;

import com.TuCine.AccountManagement.domain.enumeration.TypeUsers;
import jakarta.persistence.*;
import lombok.*;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type_user")
public class TypeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //For connection
    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 20, nullable = false)
    private TypeUsers name;
}
