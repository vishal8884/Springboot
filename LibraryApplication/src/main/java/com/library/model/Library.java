package com.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library {
	@Id
	private int bookid;
	private String bookname;
	private String author;
	private int pages;
	private int cost;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Library [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", pages=" + pages
				+ ", cost=" + cost + "]";
	}
	
	
	

}
