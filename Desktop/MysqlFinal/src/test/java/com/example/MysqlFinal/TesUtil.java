package com.example.MysqlFinal;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;

import com.example.mysql.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TesUtil {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),                        
            Charset.forName("utf8")                     
            );
	
	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
 
    public static String createStringWithLength(int length) {
        StringBuilder builder = new StringBuilder();
 
        for (int index = 0; index < length; index++) {
            builder.append("a");
        }
 
        return builder.toString();
    }
	
	public static String asJsonString(final Object obj) {
	    try {
	    	final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static List<User> createUserListForTesting() {
		List<User> users = new ArrayList<>();
		users.add(getUser1());
		users.add(getUser2());
		return users;
	}

	public static User getUser1() {
		User user1 = new User();
		user1.setId(22);
		user1.setName("juan");
		user1.setEmail("juan@gmail.com");
		return user1;
	}

	public static User getUser2() {
		User user2 = new User();
		user2.setId(23);
		user2.setName("julio");
		user2.setEmail("julio@gmail.com");
		return user2;
	}

}

