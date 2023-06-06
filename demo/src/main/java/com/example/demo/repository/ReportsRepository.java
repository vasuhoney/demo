/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reports;

/**
 * @author vasavi.yakkali
 *
 */
@Repository
public interface ReportsRepository extends JpaRepository<Reports, Long> {

}
