package com.tencentocr.tencent;

import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesResponse;
import com.tencentocr.tencent.config.ConfigProperties;
import com.tencentocr.tencent.service.IDCardOCR;
import com.tencentocr.tencent.model.IDCardVi;
import com.tencentocr.tencent.model.IDCardVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesRequest;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@SpringBootTest
class TencentApplicationTests {

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    IDCardOCR idCardOCR;

    @Test
    void json(){
        String json="{\"Name\":\"顾斌\",\"Sex\":\"男\",\"Nation\":\"汉\",\"Birth\":\"1993/1/15\",\"Address\":\"上海市奉贤区金汇镇梅园村502号\",\"IdNum\":\"310226199301152015\",\"Authority\":\"\",\"ValidDate\":\"\",\"AdvancedInfo\":\"{}\",\"RequestId\":\"356a8d96-c6ab-4dd0-a72a-e4a7f312a91c\"}";

        IDCardVo idCardVo= JSONObject.parseObject(json, IDCardVo.class);

        System.out.println(idCardVo);
    }

    //测试主要方法
    @Test
    void alibabaJson(){
        IDCardVi idCardVi=new IDCardVi();
        idCardVi.setImageBase64(ImageToBase64("123"));
        String result=idCardOCR.doOCRMethod(idCardVi);
        System.out.println("result="+result);
    }

    @Test
    String ImageToBase64(String imgPath) {
        imgPath="C:\\Users\\53055\\Pictures\\Camera Roll\\123.bmp";
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
//        System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(data)));
        return encoder.encode(Objects.requireNonNull(data));
    }

    //测试配置
    @Test
    void testConfig(){
        System.out.println(configProperties.getRegion());
        System.out.println(configProperties.getSecretId());
        System.out.println(configProperties.getSecretKey());
    }



    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @Param: SecretID 用于标识 API 调用者的身份。
     * SecretKey 用于加密签名字符串和服务器端验证签名字符串的密钥，SecretKey 需妥善保管，避免泄露。
     * @Return: void
     * @Author: songxinzhang
     * @Date: 2020/5/20 11:07
     */
    @Test
    void contextLoads() {
        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户 secretId，secretKey
            Credential cred = new Credential("secretId", "secretKey");

            // 实例化要请求产品（以 CVM 为例）的 client 对象
            CvmClient client = new CvmClient(cred, "ap-guangzhou");

            // 实例化一个请求对象
            DescribeZonesRequest req = new DescribeZonesRequest();

            // 通过 client 对象调用想要访问的接口，需要传入请求对象
            DescribeZonesResponse resp = client.DescribeZones(req);

            // 输出 JSON 格式的字符串回包
            System.out.println(DescribeZonesRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 功能描述: <br>
     * 〈公鸡5元一只，母鸡3元一只，小鸡1元三只，用100块钱买一百只鸡，问公鸡、母鸡、小鸡各有多少只？〉
     *  基础循环算法
     * @Param:
     * @Return: void
     * @Author: songxinzhang
     * @Date: 2020/5/20 11:17
     */
    @Test
    void outString() {
        long gongji = 1;
        long muji = 1;
        long xiaoji = 1;
        int num=0;
        for (gongji = 1; gongji<100/5; gongji++) {
            for (muji = 1; muji<100/3; muji++) {
                for (xiaoji = 1; xiaoji<300; xiaoji++) {
                    if (gongji * 5 + muji * 3 + xiaoji/3 == 100&&gongji + muji + xiaoji == 100) {
                        System.out.println("================");
                        System.out.println("公鸡数量=" + gongji+",金钱="+gongji*5);
                        System.out.println("母鸡数量=" + muji+",金钱="+muji*3);
                        System.out.println("小鸡数量=" + xiaoji+",金钱"+xiaoji/3);
                        System.out.println("总数量=" + (xiaoji+muji+gongji)+",总金钱"+(xiaoji/3+muji*3+gongji*5));
                        num++;
                        break;
                    }
                }
            }
        }
        System.out.println("=====总可能性====="+num);
    }

}
