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

import java.util.ArrayList;
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

    //READ SINGLE SECTION
    public SectionDTO readSection(long idPostData, int idSection){
        PostData postData = postDataRepository.findPostDataByIdPostData(idPostData).get();
        List<SectionsElement> sectionsElementList = postData.getSections();

        SectionDTO sectionDTO = new SectionDTO();
        for(SectionsElement p:sectionsElementList){
            if(p.getIdSection() == idSection){
                    sectionDTO.setIdSection(p.getIdSection());
                    sectionDTO.setNameSection(p.getNameSection());
                    sectionDTO.setListHeaders(p.getListHeaders());
                    sectionDTO.setListParagraphs(p.getListParagraphs());
                    sectionDTO.setIdPostData(idPostData);
                    sectionDTO.setVisible(p.isVisible());
            }
        }
        return sectionDTO;
    }

    //READ ALL
    public List<SectionDTO> readAllSections(long idPostData){
        List<SectionDTO> newListSectionsDTO = new ArrayList<SectionDTO>();

        PostData postData = postDataRepository.findPostDataByIdPostData(idPostData).get();
        List<SectionsElement> sectionsElementList = postData.getSections();

        for(SectionsElement p:sectionsElementList){
            SectionDTO sectionDTO = new SectionDTO();
                sectionDTO.setIdSection(p.getIdSection());
                sectionDTO.setIdPostData(idPostData);
                sectionDTO.setNameSection(p.getNameSection());
                sectionDTO.setListHeaders(p.getListHeaders());
                sectionDTO.setListParagraphs(p.getListParagraphs());
                sectionDTO.setVisible(p.isVisible());
            newListSectionsDTO.add(sectionDTO);
        }
        return newListSectionsDTO;
    }

    //UPDATE SECTION
    public void updateSection(SectionDTO sectionDTO){
        //Only update name
        String newNameSection = sectionDTO.getNameSection();

        Query query = new Query();

        query.addCriteria(Criteria.where("idPostData")
                .is(sectionDTO.getIdPostData()));

        query.addCriteria(Criteria.where("sections.idSection")
                .is(sectionDTO.getIdSection()));

        Update update = new Update();
        update.set("sections.$.nameSection", newNameSection);

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
