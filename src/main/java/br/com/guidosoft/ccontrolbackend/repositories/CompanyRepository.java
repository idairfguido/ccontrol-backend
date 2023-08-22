package br.com.guidosoft.ccontrolbackend.repositories;

import br.com.guidosoft.ccontrolbackend.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
