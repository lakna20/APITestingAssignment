package files;

import java.util.ArrayList;
import java.util.List;

public class Payload {

	public static String createUser(String username, String firstname, String lastname, String email, String pwd, String phone) {
		return "{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"username\": \""+username+"\",\r\n"
				+ "  \"firstName\": \""+firstname+"\",\r\n"
				+ "  \"lastName\": \""+lastname+"\",\r\n"
				+ "  \"email\": \""+email+"\",\r\n"
				+ "  \"password\": \""+pwd+"\",\r\n"
				+ "  \"phone\": \""+phone+"\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}";
	}
	
	public static String createUserArray(String[] user1, String[] user2, String[] user3) {
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"username\": \""+user1[0]+"\",\r\n"
				+ "    \"firstName\": \""+user1[1]+"\",\r\n"
				+ "    \"lastName\": \""+user1[2]+"\",\r\n"
				+ "    \"email\": \""+user1[3]+"\",\r\n"
				+ "    \"password\": \""+user1[4]+"\",\r\n"
				+ "    \"phone\": \""+user1[5]+"\",\r\n"
				+ "    \"userStatus\": 0\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 2,\r\n"
				+ "    \"username\": \""+user2[0]+"\",\r\n"
				+ "    \"firstName\": \""+user2[1]+"\",\r\n"
				+ "    \"lastName\": \""+user2[2]+"\",\r\n"
				+ "    \"email\": \""+user2[3]+"\",\r\n"
				+ "    \"password\": \""+user2[4]+"\",\r\n"
				+ "    \"phone\": \""+user2[5]+"\",\r\n"
				+ "    \"userStatus\": 0\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 3,\r\n"
				+ "    \"username\": \""+user3[0]+"\",\r\n"
				+ "    \"firstName\": \""+user3[1]+"\",\r\n"
				+ "    \"lastName\": \""+user3[2]+"\",\r\n"
				+ "    \"email\": \""+user3[3]+"\",\r\n"
				+ "    \"password\": \""+user3[4]+"\",\r\n"
				+ "    \"phone\": \""+user3[5]+"\",\r\n"
				+ "    \"userStatus\": 0\r\n"
				+ "  }\r\n"
				+ "]";
	}
	
	public static String createUserList(String username, String firstname, String lastname, String email, String pwd, String phone) {		
		List<String> userlist = new ArrayList<String>();
		userlist.add(0, username);
		userlist.add(1, firstname);
		userlist.add(2, lastname);
		userlist.add(3, email);
		userlist.add(4, pwd);
		userlist.add(5, phone);
		
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5,\r\n"
				+ "    \"username\": \""+userlist.get(0)+"\",\r\n"
				+ "    \"firstName\": \""+userlist.get(1)+"\",\r\n"
				+ "    \"lastName\": \""+userlist.get(2)+"\",\r\n"
				+ "    \"email\": \""+userlist.get(3)+"\",\r\n"
				+ "    \"password\": \""+userlist.get(4)+"\",\r\n"
				+ "    \"phone\": \""+userlist.get(5)+"\",\r\n"
				+ "    \"userStatus\": 0\r\n"
				+ "  }\r\n"
				+ "]";
	}
	
	public static String updateUser(String username, String firstname, String lastname, String email, String pwd, String phone) {
		return "{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"username\": \""+username+"\",\r\n"
				+ "  \"firstName\": \""+firstname+"\",\r\n"
				+ "  \"lastName\": \""+lastname+"\",\r\n"
				+ "  \"email\": \""+email+"\",\r\n"
				+ "  \"password\": \""+pwd+"\",\r\n"
				+ "  \"phone\": \""+phone+"\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}";
	}
	
	public static String addPet(String categoryName, String name, String tagName, String status) {
	
			return "{\r\n"
			+ "  \"id\": 0,\r\n"
			+ "  \"category\": {\r\n"
			+ "    \"id\": 0,\r\n"
			+ "    \"name\": \""+categoryName+"\"\r\n"
			+ "  },\r\n"
			+ "  \"name\": \""+name+"\",\r\n"
			+ "  \"photoUrls\": [\r\n"
			+ "    \"string\"\r\n"
			+ "  ],\r\n"
			+ "  \"tags\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 0,\r\n"
			+ "      \"name\": \""+tagName+"\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"status\": \"available\"\r\n"
			+ "}";
	}
}
