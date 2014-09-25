package edu.luc.comp433.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

import org.apache.cxf.common.i18n.Exception;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import edu.luc.comp433.model.Book;
import edu.luc.comp433.service.BookService;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
public final class BookClient {

	private BookClient() {
	}

	public static void main(String args[]) throws Exception {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(BookService.class);
		factory.setAddress("http://localhost:8080/project2/ListBooks");
		BookService client = (BookService) factory.create();

		// Test the list all books
		List<Book> books = client.listAll();
		for (Book book : books) {
			System.out.println("Book title: " + book.getTitle());
			System.out.println("Book author: " + book.getAuthor());
			System.out.println("Book price: " + book.getPrice() + "\n");
		}

		// Test the search by Author
		Book searchByAuthor = client.searchByAuthor("Author 1");
		System.out.println("Book title: " + searchByAuthor.getTitle());
		System.out.println("Book author: " + searchByAuthor.getAuthor());
		System.out.println("Book price: " + searchByAuthor.getPrice() + "\n");

		// Test the search by Title
		Book searchByTitle = client.searchByTitle("Title 5");
		System.out.println("Book title: " + searchByTitle.getTitle());
		System.out.println("Book author: " + searchByTitle.getAuthor());
		System.out.println("Book price: " + searchByTitle.getPrice() + "\n");

		// Test the search by Price - Tries to find a book with the given price
		Boolean flag = true;
		while (flag) {
			Book searchByPrice = client.searchByPrice(new BigDecimal(
					new Random().nextInt(10000) / 100.0).setScale(2,
					RoundingMode.CEILING));
			if (searchByPrice != null) {
				System.out.println("Book title: " + searchByPrice.getTitle());
				System.out.println("Book author: " + searchByPrice.getAuthor());
				System.out.println("Book price: " + searchByPrice.getPrice()
						+ "\n");
				flag = false;
			}
		}
	}

}