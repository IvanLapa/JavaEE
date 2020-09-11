package dao;
import bean.Book;
import dao.exception.DAOException;

public interface BookDao {
void addBook(Book book) throws DAOException;
void deleteBook(long idBook) throws DAOException;
void delete(Book book) throws DAOException;
}
