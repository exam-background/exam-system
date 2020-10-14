package com.yyhn.exam.service;

import com.tencentcloudapi.asr.v20190614.AsrClient;
import com.tencentcloudapi.asr.v20190614.models.SentenceRecognitionRequest;
import com.tencentcloudapi.asr.v20190614.models.SentenceRecognitionResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class VoiceServiceImpl implements VoiceService {
    //取出application.properties配置中配置的secretId和secretKey的值
    //并把值赋给对应的变量
    @Value("${spring.secretId}")
    private String secretId;
    @Value("${spring.secretKey}")
    private String secretKey;
    @Override
    public String Sentence(File file) {
        try{
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("asr.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            clientProfile.setSignMethod("TC3-HMAC-SHA256");
            AsrClient client = new AsrClient(cred, "ap-shanghai", clientProfile);
            String params = "{\"ProjectId\":0,\"SubServiceType\":2,\"EngSerViceType\":\"16k_zh\",\"SourceType\":1,\"Url\":\"\",\"VoiceFormat\":\"wav\",\"UsrAudioKey\":\"session-123\"}";
            SentenceRecognitionRequest req = SentenceRecognitionRequest.fromJsonString(params, SentenceRecognitionRequest.class);
            //这里直接给出一个音频文件的本地路径
            //File file = new File("D:\\1\\test.wav");
            FileInputStream inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int)file.length()];
            req.setDataLen(file.length());
            inputFile.read(buffer);
            inputFile.close();
            String encodeData = Base64.getEncoder().encodeToString(buffer);
            req.setData(encodeData);

            SentenceRecognitionResponse resp = client.SentenceRecognition(req);
            String result = resp.getResult();
            return result;
        } catch (TencentCloudSDKException | IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
