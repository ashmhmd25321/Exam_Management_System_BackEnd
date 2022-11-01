package com.exam.examinationsystem.repository;

import com.exam.examinationsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
