package com.cg.jpa.lab21;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class AuthorNew
{
	@Id
	private int authorId;
	private String authorName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Author_Books",
			joinColumns={@JoinColumn(name="authorId")},
			inverseJoinColumns = {@JoinColumn(name="bookISBN")})
	Set<Book> books;

	public AuthorNew()
	{
		books = new HashSet<>();
	}
	
	public void addPorduct(Book book)
	{
		books.add(book);
	}
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
