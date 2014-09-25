package edu.luc.comp433.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.dao.BookDAO;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.service.BooksService;

@WebService(endpointInterface = "edu.luc.comp433.service.ListBooks")
public class ListBooksImpl implements BooksService {

	BookDAO bookDAO = new BookDAO();

	@Override
	public List<Book> listAll() {
		return bookDAO.listAll();
	}

	@Override
	public Book searchByTitle(String title) {
		return bookDAO.searchByTitle(title);
	}

	@Override
	public Book searchByAuthor(String author) {
		return bookDAO.searchByAuthor(author);
	}

	@Override
	public Book searchByPrice(BigDecimal price) {
		return bookDAO.searchByPrice(price);
	}

}
