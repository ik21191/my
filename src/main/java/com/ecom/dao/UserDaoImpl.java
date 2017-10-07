package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ecom.beans.User;
import com.ecom.db.helper.ConnectionFactory;

public class UserDaoImpl implements UserDao {
	private Logger log = Logger.getLogger("ecomLog");
	
	@Override
	public boolean checkEmail(String email) throws Exception {
		log.info("Checking email address...........");
		boolean flag = false;
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT * FROM BASE_CUSTOMER WHERE EMAILADDRESS=?";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setString(1, email);
		ResultSet rset = stm.executeQuery();
		if (rset.next()) {
			flag = true;
		}
		log.info(email + "  :   " + flag);
		return flag;
	}
	
	@Override
	public List userRegistration(User user) throws Exception {
		List list = new ArrayList();
		Map m = new HashMap();
		if (checkEmail(user.getEmail())) {
			m.put("status", "true");
			list.add(m);
		} else {
			log.info("Registering user...........");

			try {
				Connection con = ConnectionFactory.getConnection();
				String query = "INSERT INTO BASE_CUSTOMER(LOGINID,FIRSTNAME,LASTNAME,EMAILADDRESS,CUSTOMERTYPE,USERPASSWORD,STATUS,CREATEDDATE,CREATEDBY) VALUES"
						+ "(?,?,?,?,'B2C',?,'Y',NOW(),'Web')";
				PreparedStatement stm = con.prepareStatement(query.toLowerCase());
				stm.setString(1, user.getEmail());
				stm.setString(2, user.getFirstName());
				stm.setString(3, user.getLastName());
				stm.setString(4, user.getEmail());
				stm.setString(5, user.getPassword());
				stm.executeUpdate();
				stm = con.prepareStatement("SELECT ID FROM BASE_CUSTOMER ORDER BY ID DESC limit 1");
				ResultSet rset = stm.executeQuery();
				rset.next();
				int CUSTOMERID = rset.getInt(1);
				m.put("customerId", CUSTOMERID);
				m.put("customerEmail", user.getEmail());
				m.put("customerFirstName", user.getFirstName());
				m.put("status", "false");
				list.add(m);
				String query1 = "INSERT INTO BASE_CUSTOMER_RELATION(CUSTOMERID,MOBILENO,CREATEDDATE) VALUES"
						+ "(?,?,NOW())";
				stm = con.prepareStatement(query.toLowerCase());
				stm.setInt(1, CUSTOMERID);
				stm.setString(2, user.getMobileNo());
				stm.executeUpdate();
			} catch (Exception e) {
				log.info(e);
			}
		}
		return list;
	}
	
	@Override
	public List registerEmail(String email) throws Exception {
		log.info("Inserting email address...........");
		Connection con = ConnectionFactory.getConnection();
		String query = "INSERT INTO BASE_CUSTOMER(EMAILADDRESS,CUSTOMERTYPE,CREATEDDATE,STATUS,CREATEDBY) VALUES(?,'B2C',NOW(),'N','System')";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setString(1, email);
		stm.executeUpdate();
		log.info("email address inserted.");
		return null;
	}
	
	@Override
	public List validateUser(String user, String password) throws Exception {
		List list = new ArrayList();
		Map m = new HashMap();
		log.info("Validating user...........");
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT FIRSTNAME,EMAILADDRESS FROM BASE_CUSTOMER WHERE LOGINID=? AND USERPASSWORD=?";
		PreparedStatement stm = con.prepareStatement(query.toLowerCase());
		stm.setString(1, user);
		stm.setString(2, password);
		ResultSet rset = stm.executeQuery();
		if (rset.next()) {
			m.put("customerFirstName", rset.getString(1));
			m.put("customerEmail", rset.getString(2));
			m.put("status", "Valid");
			list.add(m);
		} else {
			m.put("status", "InValid");
			list.add(m);
		}
		log.info("First Name is :" + user);
		return list;
	}
}
