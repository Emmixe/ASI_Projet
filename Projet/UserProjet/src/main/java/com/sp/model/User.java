package com.sp.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sp.service.UserService;

@Entity
public class User {
	
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name = "jdoe";
	private String surname = "jdo";
	private String passwd = "0000";
	private int bank = 0;
	
	@ElementCollection
	private List<Integer> cardList;

	public User( String name, String surname, String passwd) {
		this.name = name;
		this.surname = surname;
		this.passwd = passwd;
	}
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<Integer> getListCards() {
		return cardList;
	}

	public void setListCards(List<Integer> listCards) {
		this.cardList = listCards;
	}
	
	public void addCard(Integer card)
	{
		if (card != null)
		{
			this.cardList.add(card);
		}
	}
	
	public Integer deleteCard(int id)
	{
		Integer card = null;
		for (Integer mycard : this.cardList)
		{
			if (mycard == id)
			{
				if (this.cardList.remove(mycard))
				{
					return mycard;
				}
			}
		}
		return card;
		
	}

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}
	
	
	

	
}