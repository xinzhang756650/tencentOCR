package com.tencentocr.tencent.model;

import lombok.Data;

import java.util.List;

/**
 * Create by jiuyv on 2020/5/20
 */
@Data
public class IDCardVo {

    private String Name;

    private String Sex;

    private String Nation;

    private String Birth;

    private String Address;

    private String IdNum;

    private String Authority;

    private String ValidDate;

    private List<String> AdvancedInfo;

    private String RequestId;


}
