package com.blogback.blog.postdata.services;

import com.blogback.blog.postdata.data.PostData;
import com.blogback.blog.postdata.elements.SectionsElement;
import com.blogback.blog.postdata.repositories.PostDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    PostDataRepository postDataRepository;

    @Autowired
    PostDataService postDataService;

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
