package com.metrologist.sand.dao;

import com.metrologist.sand.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
