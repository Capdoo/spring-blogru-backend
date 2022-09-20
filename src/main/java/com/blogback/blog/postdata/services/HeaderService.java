package com.blogback.blog.postdata.services;

import com.blogback.blog.postdata.data.PostData;
import com.blogback.blog.postdata.dto.HeaderDTO;
import com.blogback.blog.postdata.elements.HeadersElement;
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
public class HeaderService {


    @Autowired
    PostDataRepository postDataRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public void createHeader(HeaderDTO headerDTO){
        PostData postData = postDataRepository.findPostDataByIdPostData(headerDTO.getIdPostData()).get();
        SectionsElement sectionsElement = new SectionsElement();

        List<SectionsElement> sectionsElementList = postData.getSections();
        for(SectionsElement p:sectionsElementList){
            if(p.getIdSection() == headerDTO.getIdSection()){
                sectionsElement = p;
            }
        }

        //Get List Headers and add new Header
        List<HeadersElement> headersElementList = sectionsElement.getListHeaders();
        HeadersElement newHeader = new HeadersElement(headersElementList.size(),//id
                                                                    headerDTO.getContent(),
                                                                    headerDTO.isVisible());
        headersElementList.add(newHeader);

        Query query = new Query();

        query.addCriteria(Criteria.where("idPostData")
                .is(headerDTO.getIdPostData()));

        query.addCriteria(Criteria.where("sections.idSection")
                .is(headerDTO.getIdSection()));

        Update update = new Update();
        update.set("sections.$.listHeaders", headersElementList); // change the field inside the child that must be updated

        mongoTemplate.findAndModify(query,update, new FindAndModifyOptions().returnNew(true), PostData.class);

    }

}
