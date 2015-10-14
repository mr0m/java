package lv.lgs.controller;

import java.sql.SQLException;

import pojo.Author;
import dao.JDBCDao;

public class Main {
	public static void main(String[] args) throws SQLException {
		
		JDBCDao dao = new JDBCDao();
		dao.create(new Author("Ivan", "Petrov"));
		dao.delete(new Author("Ivan", "Sidorow"));
	}

}
