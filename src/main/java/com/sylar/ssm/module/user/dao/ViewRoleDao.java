package com.sylar.ssm.module.user.dao;

import com.sylar.ssm.module.user.pojo.ViewRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRoleDao extends JpaRepository<ViewRole,Long>{

    @Query(value = "select v.authority from ViewRole v where v.user_id = ?1")
    List<ViewRole> getUserGrantedAuthoritys(Long id);
}
