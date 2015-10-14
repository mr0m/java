package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.Author;


public class JDBCDao {

	Connection conn;
	public JDBCDao() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/logos", "root", "root");
		Statement statement = conn.createStatement();
		statement.execute("create table if not exists author (id int auto_increment primary key, firstName varchar(45), lastName varchar(45))");
	}
	
	public void create(Author author) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into author(firstName, lastName) values(?,?)");
		ps.setString(1, author.getFirstName());
		ps.setString(2, author.getLastName());
		ps.execute();
	}
	
	public void delete(Author author) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("delete from author where firstName = ?");
		ps.setString(1, author.getFirstName());
		ps.execute();
	}
	
}
