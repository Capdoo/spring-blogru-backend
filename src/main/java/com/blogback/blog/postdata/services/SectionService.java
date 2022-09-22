package com.blogback.blog.postdata.services;

import com.blogback.blog.postdata.data.PostData;
import com.blogback.blog.postdata.dto.SectionDTO;
import com.blogback.blog.postdata.elements.HeadersElement;
import com.blogback.blog.postdata.elements.ParagraphsElement;
import com.blogback.blog.postdata.elements.SectionsElement;
import com.blogback.blog.postdata.repositories.PostDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    PostDataRepository postDataRepository;

    @Autowired
    PostDataService postDataService;

    @Autowired
    MongoTemplate mongoTemplate;

    //CREATE NEW SECTION
    public void createSection(SectionDTO sectionDTO){
        PostData postData = postDataRepository.findPostDataByIdPostData(sectionDTO.getIdPostData()).get();
        List<SectionsElement> sectionsElementList = postData.getSections();

        SectionsElement newSection = new SectionsElement(sectionsElementList.size(), sectionDTO.getNameSection(), sectionDTO.isVisible(),null,null);
        sectionsElementList.add(newSection);

        Query query = new Query();

        query.addCriteria(Criteria.where("idPostData")
                .is(sectionDTO.getIdPostData()));

        Update update = new Update();
        update.set("sections", sectionsElementList); //

        mongoTemplate.findAndModify(query,update, new FindAndModifyOptions().returnNew(true), PostData.class);

    }

    public boolean existsSectionByIdPostData(long idPostData, int idSection){
        boolean res = false;
        PostData postData = postDataRepository.findPostDataByIdPostData(idPostData).get();
        List<SectionsElement> sectionsElementList = postData.getSections();

        for(SectionsElement p:sectionsElementList){
            if(p.getIdSection() == idSection){
                res = true;
            }
        }
        return res;
    }


}
