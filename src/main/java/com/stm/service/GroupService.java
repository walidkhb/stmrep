package com.stm.service;

import com.stm.data.entity.Group;
import com.stm.data.entity.User;

public interface GroupService {
public void saveGroup(Group group);
public Group findById(Long id);
Iterable<Group> listAllGroups();

}
