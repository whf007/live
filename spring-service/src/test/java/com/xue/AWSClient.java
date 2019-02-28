package com.xue;

import java.io.*;
import java.util.Date;
import java.util.Properties;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * 与云存储服务 digitalocean spaces 通信工具类 
 * 使用 AWS S3 的SDK
 *
 * 20180131
 * @author fengshi
 * @version 1.0
 */
public class AWSClient {
    public static void main(String[] args) throws IOException {
        com.xue.AWSClient instance = AWSClient.getInstance();
        instance.putObject("D:\\13.jpg","13",false);
    }
//    private static final String CONTENT_TYPE_SVG = "image/svg+xml";

    private static String downloadUrl;
    private static String bucketName;

    private static AWSClient AWSClient;
    private static AmazonS3 s3;
    private static ObjectMetadata metadata;

    private AWSClient(){

    }

    /**
     * 上传公有文件
     *
     * @param filePath		待上传文件路径
     * @param key			该文件在bucket中的文件名
     * @param isPub			是否公有
     * @return String		文件访问url
     * @throws FileNotFoundException
     */
    public String putObject(String filePath, String key, boolean isPub) throws FileNotFoundException{
        return putObject(new File(filePath), key, isPub);
    }

    /**
     *
     * @param file		待上传文件
     * @param key		该文件在bucket中的文件名
     * @param isPub		上传文件是否公有
     * @return String	文件访问url
     * @throws FileNotFoundException
     */
    public String putObject(File file, String key, boolean isPub) throws FileNotFoundException{
        return putObject(new FileInputStream(file), key, isPub);
    }

    /**
     * @param inputStream		待上传文件流
     * @param key				该文件在bucket中的文件名
     * @param isPub				上传文件是否公有
     * @return String			文件访问url
     * @throws FileNotFoundException
     */
    public String putObject(InputStream inputStream, String key, boolean isPub) throws FileNotFoundException{
        PutObjectRequest request = new PutObjectRequest(bucketName, key, inputStream, metadata);
        if(isPub) request.setCannedAcl(CannedAccessControlList.PublicRead);
        s3.putObject(request);
        return isPub ? new StringBuffer().append(downloadUrl).append(key).toString() : getPublicURL(key, null);
    }

    /**
     * 获取文件公有链接
     *
     * @param key				该文件在bucket中的文件名
     * @param expirationDate 	设置过期时间 无过期时间传null
     * @return
     */
    public String getPublicURL(String key, Date expirationDate){
        GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketName, key);
        if (null != expirationDate) urlRequest.setExpiration(expirationDate);
        return s3.generatePresignedUrl(urlRequest).toString();
    }

    public static AWSClient getInstance(){
        if(AWSClient == null){
            synchronized (AWSClient.class){
                if (AWSClient == null) {
                    AWSClient = new AWSClient();
                    s3 = AmazonS3ClientBuilder.standard()
                            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAIORFVADEPUE4U36Q", "sf2ythLrsPxV7S8A84ackIprwz1Vd46PpWrRRWVg")))
                            .withRegion("ap-northeast-1")
                            .build();
                    metadata = new ObjectMetadata();
//                    metadata.setContentType(CONTENT_TYPE_SVG);//目前只用于上传svg v1.0
                    downloadUrl = "d:\\";
                    bucketName = "wanghf";
                }
            }
        }
        return AWSClient;
    }
}
