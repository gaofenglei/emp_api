package com.gfl.utils.ossUtils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public class OssAliyunUtils {

    /*CommonsMultipartFile file 要保存的图片文件*/
    /*String catalogName 服务器上面的目录 字符串前面不需要加/*/
    public static String uploadingOSS(MultipartFile file, String catalogName) {

        FileInputStream inputStream=null;

        String endpoint = "oss-cn-zhangjiakou.aliyuncs.com";
        String accessKeyId = "LTAI4FmTMjXze1jtKa5PYK2A";
        String accessKeySecret = "hCdRzcDy3T6zG1JAEPlOLBj6YrO4Xk";
        String bucketName = "img-gfl";

        /*获取上传的名称*/
        String oldName = file.getOriginalFilename();
        /*生产随机的32为的UUID名称*/
        UUID randomUUID = UUID.randomUUID();
        /*截取上传的名称的后缀*/
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        /*拼接新的名称 UUID+后缀*/
        String newFileName = randomUUID + suffix;
        try {
            /*将要上传的图片放入输入流中*/
            inputStream= (FileInputStream) file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件。新图片名称+要上传的图片的输入流
        ossClient.putObject(bucketName, catalogName+newFileName, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //关流
        try {
            if(inputStream!=null){
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "https://"+bucketName+"."+endpoint+"/"+catalogName+newFileName;
    }

}
