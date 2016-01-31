package com.unitn.adapter_service.services.todo_ly;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by demiurgo on 1/31/16.
 */
@Data
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
        public long Id;
        public String Content;
        public int ItemsCount;
        public int ItemType;
        public Long ParentId;
        public List<Project> Children;


    public Project(String content){
        this.Content = content;
    }
}
