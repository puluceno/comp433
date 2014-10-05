package edu.luc.comp433.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import edu.luc.comp433.dao.BookDAO;
import edu.luc.comp433.model.Book;
import edu.luc.comp433.service.BookService;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
@WebService(endpointInterface = "edu.luc.comp433.service.BookService")
public class BookServiceImpl extends BaseServiceImpl<Short, Book> implements
		BookService {

	BookDAO bookDAO = new BookDAO();

	@Override
	public List<Book> searchBookByTitle(@WebParam(name="bookTitle") String title) {
		return bookDAO.searchByTitle(title);
	}

	@Override
	public List<Book> searchBookByAuthor(@WebParam(name="authorName") String author) {
		return bookDAO.searchByAuthor(author);
	}

	@Override
	public List<Book> searchBookByPrice(@WebParam(name="minPrice") BigDecimal minPrice, @WebParam(name="maxPrice") BigDecimal maxPrice) {
		return bookDAO.searchByPrice(minPrice, maxPrice);
	}

	@Override
	public List<Book> listAllBooks() {
		return bookDAO.findAll();
	}
	
	@Override
	public List<Book> searchBookByIds(@WebParam(name="idsList") List<Short> ids) {
		return bookDAO.findById(ids);
	}
}

