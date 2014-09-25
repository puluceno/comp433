package edu.luc.comp433.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.luc.comp433.model.Book;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */

public class BookDAO {

	private List<Book> books = new ArrayList<Book>();

	public BookDAO() {
		for (int i = 1; i <= 10; i++) {
			Book book = new Book();
			book.setTitle("Title " + i);
			book.setAuthor("Author " + i);
			book.setPrice(new BigDecimal(new Random().nextInt(10000) / 100.0)
					.setScale(2, RoundingMode.CEILING));
			books.add(book);
		}
	}

	public List<Book> listAll() {
		return books;
	}

	public Book searchByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title))
				return book;
		}
		return null;
	}

	public Book searchByAuthor(String author) {
		for (Book book : books) {
			if (book.getAuthor().equals(author))
				return book;
		}
		return null;
	}

	public Book searchByPrice(BigDecimal price) {
		for (Book book : books) {
			if (book.getPrice().equals(price))
				return book;
		}
		return null;
	}
}
