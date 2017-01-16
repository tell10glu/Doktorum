package com.doktorum.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	private int id;
	private String title;
	private String context;
	private Date askingDate;
	private boolean reply;
	private Date replyDate;
	
}
