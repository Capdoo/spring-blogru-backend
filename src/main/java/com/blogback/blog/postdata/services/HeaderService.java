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

import java.util.ArrayList;
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
        sectionsElement = sectionsElementList.get(headerDTO.getIdSection());

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


    public List<HeadersElement> readListHeaders(long idPostData, int idSection){
        PostData postData = postDataRepository.findPostDataByIdPostData(idPostData).get();
        SectionsElement sectionsElement = new SectionsElement();

        List<SectionsElement> sectionsElementList = postData.getSections();
        sectionsElement = sectionsElementList.get(idSection);

        return sectionsElement.getListHeaders();

    }

    public void updateHeader(HeaderDTO headerDTO){
        PostData postData = postDataRepository.findPostDataByIdPostData(headerDTO.getIdPostData()).get();
        SectionsElement sectionsElement = new SectionsElement();

        List<SectionsElement> sectionsElementList = postData.getSections();
        sectionsElement = sectionsElementList.get(headerDTO.getIdSection());

        HeadersElement newHeader = new HeadersElement(headerDTO.getIdHeader(),//id
                headerDTO.getContent(),
                headerDTO.isVisible());

        //Get List Headers and add new Header
        List<HeadersElement> headersElementList = sectionsElement.getListHeaders();
        //Update header element
        headersElementList.set(headerDTO.getIdHeader(), newHeader);


        Query query = new Query();

        query.addCriteria(Criteria.where("idPostData")
                .is(headerDTO.getIdPostData()));

        query.addCriteria(Criteria.where("sections.idSection")
                .is(headerDTO.getIdSection()));

        Update update = new Update();
        update.set("sections.$.listHeaders", headersElementList); // change the field inside the child that must be updated

        mongoTemplate.findAndModify(query,update, new FindAndModifyOptions().returnNew(true), PostData.class);

    }


    public void deleteHeader(long idPostData, int idSection, int idHeader){
        PostData postData = postDataRepository.findPostDataByIdPostData(idPostData).get();
        SectionsElement sectionsElement = new SectionsElement();

        List<SectionsElement> sectionsElementList = postData.getSections();
        sectionsElement = sectionsElementList.get(idSection);

        //Get List Headers and add new Header
        List<HeadersElement> headersElementList = sectionsElement.getListHeaders();


        //Delete header element
        List<HeadersElement> newEmptyList = new ArrayList<HeadersElement>();

        for(HeadersElement p:headersElementList){
            if(p.getIdHeader() != idHeader){
                newEmptyList.add(p);
            }
        }

        Query query = new Query();

        query.addCriteria(Criteria.where("idPostData")
                .is(idPostData));

        query.addCriteria(Criteria.where("sections.idSection")
                .is(idSection));

        Update update = new Update();
        update.set("sections.$.listHeaders", newEmptyList); // change the field inside the child that must be updated

        mongoTemplate.findAndModify(query,update, new FindAndModifyOptions().returnNew(true), PostData.class);



    }


    public boolean existsHeaderByIdPostDataAndIdSection(long idPostData, int idSection, int idHeader){
        boolean res = false;
        PostData postData = postDataRepository.findPostDataByIdPostData(idPostData).get();
        SectionsElement sectionsElement = new SectionsElement();

        List<SectionsElement> sectionsElementList = postData.getSections();
        sectionsElement = sectionsElementList.get(idSection);
        List<HeadersElement> headersElementList = sectionsElement.getListHeaders();

        for(HeadersElement p:headersElementList){
            if(p.getIdHeader() == idHeader){
                res = true;
            }
        }
        return res;

    }


}
