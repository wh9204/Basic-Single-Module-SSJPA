package com.sylar.ssm.module.user.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "pojoCache")
@Cacheable(true)
@Entity
@Table(name = "view_role")
public class ViewRole {

    @Id
    @GenericGenerator(name = "IdentifierGenerator", strategy = "identity")
    @GeneratedValue(generator = "IdentifierGenerator")
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "authority")
    private String authority;

    @Column(name = "user_id")
    private  String user_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ViewRole{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
