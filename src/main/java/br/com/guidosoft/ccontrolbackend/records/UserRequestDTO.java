package br.com.guidosoft.ccontrolbackend.records;

import br.com.guidosoft.ccontrolbackend.entities.Address;
import br.com.guidosoft.ccontrolbackend.enuns.UserRule;

import java.time.LocalDateTime;

public record UserRequestDTO(
        String fullName,
        String userName,
        String password,
        String phoneNumber,
        UserRule accessLevel,
        int status,
        Address address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
