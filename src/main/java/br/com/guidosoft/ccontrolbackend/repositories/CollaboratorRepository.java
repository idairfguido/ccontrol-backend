package br.com.guidosoft.ccontrolbackend.repositories;

import br.com.guidosoft.ccontrolbackend.entities.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
}
