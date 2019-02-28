package com.xue;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.services.s3.AmazonS3Client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;


import java.io.File;
import java.io.IOException;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * OTC广告主完成率
 *
 * @author xuyou
 * @version $Id: OtcAdBuyApplyProcessor.java, v 0.1 2018年9月6日 xy Exp $
 */


public class test  {




    // Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-s3-developer-guide/blob/master/LICENSE-SAMPLECODE.)


    public static void main(String[] args) throws IOException {
        String clientRegion = "ap-northeast-1";
        String bucketName = "wanghf";
//			String stringObjKeyName = "D:\\111.jpg";
        String fileObjKeyName = "13.jpg";
        String fileName = "D:\\13.jpg";
        AWSCredentials credentials = new BasicAWSCredentials("AKIAIORFVADEPUE4U36Q", "sf2ythLrsPxV7S8A84ackIprwz1Vd46PpWrRRWVg");

        try {
            AmazonS3 s3client = new AmazonS3Client(credentials);

//            String regionName = "cn-north-1";
            Region region = Region.getRegion(Regions.fromName(clientRegion));
            s3client.setRegion(region);
            String serviceEndpoint = region.getServiceEndpoint(ServiceAbbreviations.S3);
            s3client.setEndpoint(serviceEndpoint);
            s3client.putObject(new PutObjectRequest(bucketName, fileObjKeyName, fileName));
            // 关键是下面这一行, 在除了中国外的其他region, 这行代码不用写
            s3client.setEndpoint(serviceEndpoint);
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withRegion(clientRegion)
//                    .withCredentials(new ProfileCredentialsProvider())
//                    .build();

            // Upload a text string as a new object.
//				s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");

            // Upload a file as a new object with ContentType and title specified.
            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            request.setMetadata(metadata);
            s3client.putObject(request);
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        } catch (Exception e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }

}
