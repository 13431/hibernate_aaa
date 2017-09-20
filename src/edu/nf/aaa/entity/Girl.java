package edu.nf.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Girl {

    private long id;
    private String name;
    private String address;

    public Girl () {}

    public Girl(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long gid) {
        this.id = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
