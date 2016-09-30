package com.vitrenko.spittr.model.domain;

import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.Null;

@MappedSuperclass
public class DomainObject {

    @Id
    @GeneratedValue
    private Long id;

    public DomainObject() {

    }

    public DomainObject(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DomainObject other = (DomainObject) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
