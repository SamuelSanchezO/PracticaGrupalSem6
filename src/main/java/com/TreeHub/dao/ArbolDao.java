
package com.TreeHub.dao;

import com.TreeHub.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ArbolDao extends JpaRepository<Arbol,Long>{
    
}
