package com.tencentocr.tencent.model;

import lombok.Data;

/**
 * Create by jiuyv on 2020/5/20
 */
@Data
public class IDCardVi {

    //图片的 Base64 值。要求图片经Base64编码后不超过 7M，
    // 分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。
    // 建议卡片部分占据图片2/3以上。 图片的 ImageUrl、ImageBase64 必须提供一个，如果都提供，只使用 ImageUrl。
    private String ImageBase64;
    //图片的 Url 地址。要求图片经Base64编码后不超过 7M，
    // 分辨率建议500*800以上，支持PNG、JPG、JPEG、BMP格式。
    // 建议卡片部分占据图片2/3以上。 建议图片存储于腾讯云，可保障更高的下载速度和稳定性。
    private String ImageUrl;
    //FRONT：身份证有照片的一面（人像面），
    // BACK：身份证有国徽的一面（国徽面），
    // 该参数如果不填，将为您自动判断身份证正反面。
    private String CardSide;
    //以下可选字段均为bool 类型，默认false：
    // CropIdCard，身份证照片裁剪（去掉证件外多余的边缘、自动矫正拍摄角度）
    // CropPortrait，人像照片裁剪（自动抠取身份证头像区域）
    // CopyWarn，复印件告警
    // BorderCheckWarn，边框和框内遮挡告警
    // ReshootWarn，翻拍告警
    // DetectPsWarn，PS检测告警
    // TempIdWarn，临时身份证告警
    // InvalidDateWarn，身份证有效日期不合法告警
    // Quality，图片质量分数（评价图片的模糊程度）
    // SDK 设置方式参考： Config = Json.stringify({"CropIdCard":true,"CropPortrait":true})
    // API 3.0 Explorer 设置方式参考： Config = {"CropIdCard":true,"CropPortrait":true}
    private String Config;

}
