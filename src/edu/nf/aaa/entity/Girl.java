package edu.nf.aaa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Girl {

    @Id
    @GeneratedValue
    private long gid;

    private String name;
    private String boyFriendName;

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoyFriendName() {
        return boyFriendName;
    }

    public void setBoyFriendName(String boyFriendName) {
        this.boyFriendName = boyFriendName;
    }
}
