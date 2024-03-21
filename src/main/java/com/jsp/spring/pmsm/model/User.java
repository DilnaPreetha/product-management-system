package com.jsp.spring.pmsm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;



	@Entity
	@Table(name="users")
	public class User {
		@Override
		public String toString() {
			return "User [userid=" + userid + ", username=" + username + ", phonenumber=" + phonenumber + ", email="
					+ email + ", password=" + password + "]";
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public long getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(long phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private int userid;
		@NotNull
		private String username;
		@Min(value=600000000000l,message="phone number is invalid,should be greater than 6000000000")
		@Max(value=9000000000l,message="phone number is invalid,should be less than 9999999999")
		private long phonenumber;
		@Email(regexp="" ,message="invalid email")
		@Pattern(regexp = "",message="invalid email")
		private String email;
		@NotBlank(message = "Password is required")
		@NotNull(message = "Password is required")
		@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must"
				+ " contain at least one letter, one number, one special character")
		
		private String password;
		
		

	}



