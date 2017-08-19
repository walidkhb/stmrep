package com.stm.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stm.data.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
