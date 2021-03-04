package com.mcosta21.springrestfulapiexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mcosta21.springrestfulapiexample.model.SchoolClass;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long>{

}
