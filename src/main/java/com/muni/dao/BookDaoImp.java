package com.muni.dao;

import com.muni.beans.Book;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class BookDaoImp implements BookDao{

    private static final String DB_URL = "jdbc:mysql://localhost:3306/muniraj";
    private static final String DB_UNAME = "root";
    private static final String DB_PW = "Rajucan2@123";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.driver";


    @Override
    public int insertBook(Book book) {

        try(Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PW);){

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO BOOKS VALUE (?,?,?)");
            pstmt.setInt(1,book.getBookId());
            pstmt.setString(2, book.getBookName());
            pstmt.setDouble(3,book.getBookPrice());

            int i = pstmt.executeUpdate();
            return i;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    return 0;
    }
}
