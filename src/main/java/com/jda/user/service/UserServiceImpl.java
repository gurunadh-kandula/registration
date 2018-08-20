package com.jda.user.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.jda.user.model.ForgotPassword;
import com.jda.user.model.Login;
import com.jda.user.model.ResetPassword;
import com.jda.user.model.User;

public class UserServiceImpl implements  UserService{
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
		
	  public void register(User user) {
	    String sql = "insert into users values(?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
	    user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
	    }
	    public User validateUser(Login login) {
	   String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
	    + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	    }
	    public User getUserbyToken(String token) {
	 	   String sql = "select * from users where token='" + token 
	 	    + "'";
	 	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	 	    return users.size() > 0 ? users.get(0) : null;
	 	    }
	   public void newPassword(String password,String token) {
	   	String sql="update users set password='"+password +"'  where token='"+token+"'";
			jdbcTemplate.update(sql);
		}
		
	/*	public void newPassword(ResetPassword reset) {
			String sql="update users set password='"+reset.getNewpassword() +"'  where username='"+reset.getUsername()+"'";
			jdbcTemplate.update(sql);
			
		}*/

		/*public User validateUser(ResetPassword reset) {
			 String sql = "select * from users where username='" + reset.getUsername() + "' and password='" + reset.getPassword()
		    + "'";
		    List<User> users = jdbcTemplate.query(sql, new UserMapper());
		    return users.size() > 0 ? users.get(0) : null;
		}*/
		/*public String generator(String password) {

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
			String hashedPassword = passwordEncoder.encode(password);
			System.out.println(hashedPassword);
			return hashedPassword;

		}*/
	
		public User forgetPassword(String email) {
			  String sql = "select * from users where email='" + email+ "'";
			    List<User> users = jdbcTemplate.query(sql, new UserMapper());
			    if(!users.isEmpty())
			    { if(users.get(0).getEmail().equals(email)){
			   	String token= UUID.randomUUID().toString();
			   	users.get(0).setToken(token);
			   	String sql1="update users set token='"+token +"'  where email='"+email+"'";
			   	jdbcTemplate.update(sql1);
			   	return users.get(0);
			   	
			    }
			   	 
			    }
			    
			    return users.size() > 0 ? users.get(0) : null;
	
		}
 }
	  class UserMapper implements RowMapper<User> {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    user.setFirstname(rs.getString("firstname"));
	    user.setLastname(rs.getString("lastname"));
	    user.setEmail(rs.getString("email"));
	    user.setAddress(rs.getString("address"));
	    user.setPhone(rs.getInt("phone"));
	    return user;
	  }
}
