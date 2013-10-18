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
    @Column(name = "position_name")
    private String positionName;

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long id) {
        this.positionId = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String name) {
        this.positionName = name;
    }
}
