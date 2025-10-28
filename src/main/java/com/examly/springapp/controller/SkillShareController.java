package com.examly.springapp.controller;

import com.examly.springapp.model.SkillShare;
import com.examly.springapp.service.SkillShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillshares")
@CrossOrigin(origins = "*")
public class SkillShareController {
    
    @Autowired
    private SkillShareService skillShareService;
    
    @GetMapping("/allSkillShares")
    public ResponseEntity<List<SkillShare>> getAllSkillShares() {
        List<SkillShare> skillShares = skillShareService.getAllSkillShares();
        return ResponseEntity.ok(skillShares);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillShare> getSkillShareById(@PathVariable Long id) {
        SkillShare skillShare = skillShareService.getSkillShareById(id);
        return ResponseEntity.ok(skillShare);
    }
    
    @PostMapping("/addSkillShare")
    public ResponseEntity<SkillShare> addSkillShare(@RequestBody SkillShare skillShare) {
        SkillShare savedSkillShare = skillShareService.addSkillShare(skillShare);
        return ResponseEntity.ok(savedSkillShare);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SkillShare> updateSkillShare(@PathVariable Long id, @RequestBody SkillShare skillShare) {
        SkillShare updatedSkillShare = skillShareService.updateSkillShare(id, skillShare);
        return ResponseEntity.ok(updatedSkillShare);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkillShare(@PathVariable Long id) {
        skillShareService.deleteSkillShare(id);
        return ResponseEntity.ok().build();
    }
}
