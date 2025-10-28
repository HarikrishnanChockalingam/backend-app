package com.examly.springapp.repository;

import com.examly.springapp.model.SkillShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillShareRepository extends JpaRepository<SkillShare, Long> {
}