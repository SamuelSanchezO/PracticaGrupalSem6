
package com.TreeHub.dao;

import com.TreeHub.domain.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface EspecieDao extends JpaRepository<Especie,Long>{
    
}
