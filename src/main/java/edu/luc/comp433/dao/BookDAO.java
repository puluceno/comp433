package edu.luc.comp433.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import edu.luc.comp433.model.Book;

public class BookDAO {
	@Inject
	EntityManager em;

	private Book book = new Book();

	public BookDAO() {
		book.setTitle("title");
		book.setAuthor("author");
		book.setPrice(new BigDecimal(95.24));
	}

	// @SuppressWarnings("unchecked")
	public List<Book> listAll() {
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		return books;
		// return em.createNamedQuery(Book.LIST_ALL_BOOKS).getResultList();
	}
}
