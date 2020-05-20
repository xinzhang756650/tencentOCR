package com.tencentocr.tencent.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.ocr.v20181119.OcrClient;

import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRResponse;
import com.tencentocr.tencent.config.ConfigProperties;
import com.tencentocr.tencent.model.IDCardVi;
import com.tencentocr.tencent.model.IDCardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IDCardOCR {

    @Autowired
    private ConfigProperties configProperties;

    public String doOCRMethod(IDCardVi idCardVi) {
        try {

            Credential cred = new Credential(configProperties.getSecretId(), configProperties.getSecretKey());

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            OcrClient client = new OcrClient(cred, configProperties.getRegion(), clientProfile);

            String params = getParams(idCardVi);

            IDCardOCRRequest req = IDCardOCRRequest.fromJsonString(params, IDCardOCRRequest.class);

            IDCardOCRResponse resp = client.IDCardOCR(req);

            String result=IDCardOCRRequest.toJsonString(resp);
            IDCardVo idCardVo= JSONObject.parseObject(result,IDCardVo.class);
            System.out.println(idCardVo);
            return idCardVo.toString();
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return "";
        }

    }

    private String getParams(IDCardVi idCardVi){
        Map<String,String> paramsMap=new HashMap<>();
        paramsMap.put("ImageBase64",idCardVi.getImageBase64());
        paramsMap.put("ImageUrl",idCardVi.getImageUrl());
        paramsMap.put("CardSide",idCardVi.getCardSide());
        paramsMap.put("Config",idCardVi.getConfig());
        return JSON.toJSONString(paramsMap);
    }

}