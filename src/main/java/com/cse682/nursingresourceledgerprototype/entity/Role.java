package com.cse682.nursingresourceledgerprototype.entity;

import javax.persistence.*;

/**
 * Role entity store in the datastore
 */
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private Roles roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Roles getRoleName() {
        return roleName;
    }

    public void setRoleName(Roles roleName) {
        this.roleName = roleName;
    }
}
