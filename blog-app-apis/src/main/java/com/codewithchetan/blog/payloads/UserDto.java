package com.codewithchetan.blog.payloads;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4,message = "Username must be min of 4 character !!")
	private String name;
	
	@Email(message = "Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max= 10, message = "Password must be min of 3 char and max of 10 char !!")
	private String password;
	
	@NotEmpty
	private String about;

}
