package com.varun.portfolio.skill;

import com.varun.portfolio.skill.dto.SkillCategoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SkillService {


    private final SkillCategoryRepository skillCategoryRepository;


    public SkillService(SkillCategoryRepository skillCategoryRepository){
        this.skillCategoryRepository = skillCategoryRepository;
    }


    public List<SkillCategoryResponse> getAll(){
        return skillCategoryRepository.findAllByOrderByDisplayOrderAsc().stream().map(SkillCategoryResponse::from).toList();
    }
}
