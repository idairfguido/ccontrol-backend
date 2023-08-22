package br.com.guidosoft.ccontrolbackend.repositories;

import br.com.guidosoft.ccontrolbackend.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
