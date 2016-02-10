package com.eclipselink.demo;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.CacheIsolationType;

import javax.persistence.Entity;

@Entity
@Table
@Cacheable(false)
//@ReadOnly
//@Cache(alwaysRefresh=true,type=CacheType.SOFT,size=100,isolation=CacheIsolationType.SHARED)
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
