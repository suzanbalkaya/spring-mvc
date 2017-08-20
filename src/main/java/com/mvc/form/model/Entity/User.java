package com.mvc.form.model.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
//entity class
//you have this fields for Db
@Document(collection = "Kullanicilar")
public class User implements Serializable{
	@Id
	private String id;
	private String name;
	private String surname;
	private String captcha;
	private String numbers;

	public boolean isNew() {
		return (this.id == null);
	}

	public String getId() {
		return id;
	}

	public void setId(String  id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String number) {
		this.numbers = number;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", captcha=" + captcha
				+ ", number=" + numbers + "]" + isNew();
	}

}
