package com.syrs.web.entity;
import java.util.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Count {
	int Id;
	int Type;
	int List;
	int Num;
	int Pc;
	Date Day;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public int getList() {
		return List;
	}
	public void setList(int list) {
		List = list;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public Date getDay() {
		return Day;
	}
	public void setDay(Date day) {
		Day = day;
	}
	public int getPc() {
		return Pc;
	}
	public void setPc(int pc) {
		Pc = pc;
	}
	
	
}
