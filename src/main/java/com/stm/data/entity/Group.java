package com.stm.data.entity;
// Generated Jul 31, 2017 10:22:15 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "group", catalog = "stm")
public class Group {

	private long id;
	private String name;
	private Set<GroupHasService> groupHasServices = new HashSet<GroupHasService>(0);
	private Set<User> users = new HashSet<User>(0);

	public Group() {
	}

	public Group(String name, Set<GroupHasService> groupHasServices, Set<User> users) {
		this.name = name;
		this.groupHasServices = groupHasServices;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	public Set<GroupHasService> getGroupHasServices() {
		return this.groupHasServices;
	}

	public void setGroupHasServices(Set<GroupHasService> groupHasServices) {
		this.groupHasServices = groupHasServices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
