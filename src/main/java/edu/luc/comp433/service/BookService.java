package edu.luc.comp433.service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.model.Book;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
@WebService
public interface BookService extends BaseService<Short, Book> {
	
	public List<Book> searchBookByIds(List<Short> ids);
	
	public List<Book> listAllBooks();
	
	public List<Book> searchBookByTitle(String name);

	public List<Book> searchBookByAuthor(String name);

	public List<Book> searchBookByPrice(BigDecimal minPrice, BigDecimal maxPrice);
	
}
