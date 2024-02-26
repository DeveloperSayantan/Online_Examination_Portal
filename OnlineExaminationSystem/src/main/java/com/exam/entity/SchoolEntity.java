package com.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "school")
public class SchoolEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	@Column(length = 50)
	private String schoolName;
	@Column(length = 50)
	private String location;
}
//Each school have their Rank by the students (Participations, marks , teachers)