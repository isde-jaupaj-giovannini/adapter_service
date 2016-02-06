package com.unitn.adapter_service.services.xkcd;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by demiurgo on 2/6/16.
 */

@Data
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XkcdComic {
    private String title;
    private String img;
    private String alt;
    private String year;
    private String month;
    private String day;
}
