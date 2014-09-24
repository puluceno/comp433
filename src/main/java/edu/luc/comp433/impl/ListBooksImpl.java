package edu.luc.comp433.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.dao.BookDAO;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.service.ListBooks;

@WebService(endpointInterface = "edu.luc.comp433.service.ListBooks")
public class ListBooksImpl implements ListBooks {

	BookDAO bookDAO = new BookDAO();

	@Override
	public List<Book> listAll() {
		return bookDAO.listAll();
	}

	@Override
	public List<Book> searchByTitle(String name) {
		return null;
	}

	@Override
	public List<Book> searchByAuthor(String name) {
		return null;
	}

	@Override
	public List<Book> searchByPrice(BigDecimal price) {
		return null;
	}

}
