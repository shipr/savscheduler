package org.sav.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position{

    @Id
    @Column(name = "position_id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long positionId;
    @Column(name = "name")
    private String name;

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long id) {
        this.positionId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
