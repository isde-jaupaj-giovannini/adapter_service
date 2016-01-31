package com.unitn.adapter_service.services.todo_ly;

import lombok.Data;

import java.util.List;

/**
 * Created by demiurgo on 1/31/16.
 */

@Data
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
}
