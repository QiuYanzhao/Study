package com.my.shardingdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	private Long cid;

	private String cname;
	private Long userId;
	private String cstatus;

	public Course(String cname, Long userId, String cstatus) {
		this.cname = cname;
		this.userId = userId;
		this.cstatus = cstatus;
	}
}
