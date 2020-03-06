package com.example.demo.topics;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="topics")
public class Topics {
	@Id
	private int id;
	private String name;
	private String description;	
	
	
}
