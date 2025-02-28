package com.stemlen.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.stemlen.dto.AccountType;
import com.stemlen.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private Long id;
    private String name;
    
    @Indexed(unique = true) // Ensure email is unique
    private String email;
    
    private String password;
    private AccountType accountType;
    private Long profileId;
    
    // Optional: Add a field to track the OAuth2 provider
    private String provider; // e.g., "google", "github"

    // Constructor for OAuth2 users
    public User(String email, String name, String provider) {
        this.email = email;
        this.name = name;
        this.provider = provider;
        this.password = "OAUTH_USER_NO_PASSWORD"; // Default password for OAuth2 users
        this.accountType = AccountType.APPLICANT; // Default account type for OAuth2 users
    }

    // Convert User entity to UserDTO
    public UserDTO toDTO() {
        return new UserDTO(
            this.id,
            this.name,
            this.email,
            this.password,
            this.accountType,
            this.profileId,
            this.provider
        );
    }
}