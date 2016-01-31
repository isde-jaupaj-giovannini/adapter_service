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
public class Task {
    public long Id;
    public String Content;
    public int ItemType;
    public Boolean Checked;
    public Long ProjectId;
    public Long ParentId;
    public String Path;
    public String DateString;
    public int DateStringPriority;
    public String DueDate;
    public Integer Priority;
    public List<Task> Children;
    public String CreatedDate;
    public Boolean Deleted;


    public Task(String content){
        this.Content = content;
    }
    public Task(String content, long projectId){
        this.Content = content;
        this.ProjectId = projectId;
    }

}
