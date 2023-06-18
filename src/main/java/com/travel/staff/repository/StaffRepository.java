package com.travel.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.staff.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    // Add custom query methods if needed
}
