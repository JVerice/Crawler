package com.model;
/**
 * 书实体类
 * @author jverice
 *
 */
public class Valve {
	
	private String bookName;
	private String score;
	private String number;
	private String author;
	private String press;
	private String date;
	private String price;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Valve [bookName=" + bookName + ", score=" + score + ", number=" + number + ", author=" + author
				+ ", press=" + press + ", date=" + date + ", price=" + price + "]";
	}
	
}
