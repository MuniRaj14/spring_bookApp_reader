package com.muni.service;

import com.muni.beans.Book;
import com.muni.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookdao;

    @Override
    public void processBooks() {
        String myFilePath = "C:\\Intellij_WorSpace\\BooksApp\\BooksApp\\book.txt";
        try {

            Stream<String> lines = Files.lines(Paths.get(myFilePath));

            lines.forEach(s->{
                String[] values = s.split(",");

                String id = values[0];
                String name = values[1];
                String price = values[2];

                Book b = new Book();
                b.setBookId(Integer.parseInt(id));
                b.setBookName(name);
                b.setBookPrice(Double.parseDouble(price));

               int cnt =  bookdao.insertBook(b);

               if(cnt>0){
                   System.out.println("Record inserted");
               }


            });


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
