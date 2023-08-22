package br.com.guidosoft.ccontrolbackend.repositories;

import br.com.guidosoft.ccontrolbackend.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
