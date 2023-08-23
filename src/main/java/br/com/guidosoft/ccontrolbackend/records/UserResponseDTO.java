package br.com.guidosoft.ccontrolbackend.records;

import br.com.guidosoft.ccontrolbackend.entities.Address;
import br.com.guidosoft.ccontrolbackend.entities.User;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String fullName,
        String userName,
        String password,
        String phoneNumber,
        int accessLevel,
        int status,
        Address address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public UserResponseDTO (User user){
        this(
                user.getId(),
                user.getFullName(),
                user.getUserName(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getAccessLevel(),
                user.getStatus(),
                user.getAddress(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
