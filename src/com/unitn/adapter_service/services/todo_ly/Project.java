package com.unitn.adapter_service.services.todo_ly;

import lombok.Data;

import java.util.List;

/**
 * Created by demiurgo on 1/31/16.
 */
@Data
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
