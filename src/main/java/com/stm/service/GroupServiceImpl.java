package com.stm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stm.data.entity.Group;
import com.stm.data.rep.GroupRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class GroupServiceImpl implements GroupService{
@Autowired
private GroupRepository groupRepository;
	@Override
	public void saveGroup(Group group) {
		groupRepository.save( group);
		
	}

	@Override
	public Group findById(Long id) {
		// TODO Auto-generated method stub
		return groupRepository.findOne(id);
	}

	@Override
	public Iterable<Group> listAllGroups() {
		// TODO Auto-generated method stub
		return groupRepository.findAll();
	}

}
