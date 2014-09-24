/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.luc.comp433.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pulu
 */
@Entity
@Table(schema = "WS")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = Book.LIST_ALL_BOOKS, query = "SELECT b FROM Book b"),
		@NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
		@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
		@NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
		@NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price") })
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String LIST_ALL_BOOKS = "LIST_ALL_BOOKS";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Short id;
	@Basic(optional = false)
	private String title;
	@Basic(optional = false)
	private String author;
	@Max(value = 9999)
	@Min(value = 0)
	@Basic(optional = false)
	private BigDecimal price;
	@JoinTable(name = "Orders_has_Book", joinColumns = { @JoinColumn(name = "book", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "orders", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Orders> ordersList;

	public Book() {
	}

	public Book(Short id) {
		this.id = id;
	}

	public Book(Short id, String title, String author, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@XmlTransient
	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ordersList == null) ? 0 : ordersList.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ordersList == null) {
			if (other.ordersList != null)
				return false;
		} else if (!ordersList.equals(other.ordersList))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "model.Book[ id=" + id + " ]";
	}

}
