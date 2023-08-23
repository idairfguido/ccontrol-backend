package br.com.guidosoft.ccontrolbackend.records;

import br.com.guidosoft.ccontrolbackend.entities.Address;

import java.time.LocalDateTime;

public record UserRequestDTO(
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
}
