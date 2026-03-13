package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="dmart")
public class Dmarts 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dmartId;
	
	private String dmartName;
	
	private String landLine;
	
	private String managerName;
	
	private String pincode;
	
	private String state;

	public Dmarts(String dmartName, String landLine, String managerName, String pincode, String state) 
	{
		super();
		this.dmartName = dmartName;
		this.landLine = landLine;
		this.managerName = managerName;
		this.pincode = pincode;
		this.state = state;
		
		
	}
	
	

}
