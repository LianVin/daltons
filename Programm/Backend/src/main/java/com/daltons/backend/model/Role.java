package com.daltons.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "role")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
public class Role {
    @Id
    @Column(name = "ROLE_ID", nullable = false)
    private int roleId;

    @NotNull
    private String role;

    @OneToMany(mappedBy = "userId")
    private List<User> users;
}
