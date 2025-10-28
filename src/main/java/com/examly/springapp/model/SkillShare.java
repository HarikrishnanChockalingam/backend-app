package com.examly.springapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "skill_shares")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String skillName;
    
    @Column(nullable = false)
    private String category;
    
    @Column(nullable = false)
    private String skillLevel;
    
    @Column(nullable = false)
    private String userEmail;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false)
    private String availability;
}