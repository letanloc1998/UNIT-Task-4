package vn.com.unit.entity;

import java.util.Date;

import jp.sf.amateras.mirage.annotation.Column;

public class Log {

	@Column(name = "log")
	private String log;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "author")
	private String author;

	@Column(name = "create_at")
	private Date createAt;
}
