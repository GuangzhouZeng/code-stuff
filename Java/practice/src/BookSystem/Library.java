package BookSystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangzhouzeng on 2/7/16.
 */
public class Library {
    HashMap<String, List<Book>> booksForAuthor;
    HashMap<String, List<Book>> booksForTitle;
    List<Book> allBookList;

    public Library(){
        booksForAuthor = new HashMap<>();
        booksForTitle = new HashMap<>();
        allBookList = new LinkedList<>();
    }

    public void addBook(Book book){
        allBookList.add(book);

        if(!booksForAuthor.containsKey(book.author)){
            List<Book> bookList = new LinkedList<>();
            booksForAuthor.put(book.author, bookList);
        }
        booksForAuthor.get(book.author).add(book);

        if(!booksForTitle.containsKey(book.title)){
            List<Book> bookList = new LinkedList<>();
            booksForTitle.put(book.title, bookList);
        }
        booksForTitle.get(book.title).add(book);
    }

    public List<Book> findBookByAuthor(String author){
        return booksForAuthor.get(author);
    }

    public List<Book> findBookByTitle(String title){
        return booksForTitle.get(title);
    }

    public List<Book> pickBookInRatingRange(int low, int high){
        List<Book> result = new LinkedList<>();
        for(Book book: allBookList){
            if(low <= book.rating && book.rating <= high)
                result.add(book);
        }
        return result;
    }
}
