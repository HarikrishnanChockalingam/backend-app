package com.examly.springapp.service;

import com.examly.springapp.model.SkillShare;
import com.examly.springapp.repository.SkillShareRepository;
import com.examly.springapp.exception.SkillShareNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillShareService {
    
    @Autowired
    private SkillShareRepository skillShareRepository;
    
    public List<SkillShare> getAllSkillShares() {
        return skillShareRepository.findAll();
    }
    
    public SkillShare getSkillShareById(Long id) {
        return skillShareRepository.findById(id)
                .orElseThrow(() -> new SkillShareNotFoundException("SkillShare not found with id: " + id));
    }
    
    public SkillShare addSkillShare(SkillShare skillShare) {
        return skillShareRepository.save(skillShare);
    }
    
    public SkillShare updateSkillShare(Long id, SkillShare skillShare) {
        SkillShare existingSkillShare = getSkillShareById(id);
        existingSkillShare.setSkillName(skillShare.getSkillName());
        existingSkillShare.setCategory(skillShare.getCategory());
        existingSkillShare.setSkillLevel(skillShare.getSkillLevel());
        existingSkillShare.setUserEmail(skillShare.getUserEmail());
        existingSkillShare.setDescription(skillShare.getDescription());
        existingSkillShare.setAvailability(skillShare.getAvailability());
        return skillShareRepository.save(existingSkillShare);
    }
    
    public void deleteSkillShare(Long id) {
        SkillShare skillShare = getSkillShareById(id);
        skillShareRepository.delete(skillShare);
    }
}