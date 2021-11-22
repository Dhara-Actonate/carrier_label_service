package com.actonate.carrier_label_service.utils;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Slf4j
@Configuration
public class ApplicationConfig {
//    @Value("${cloud.aws.credentials.accessKey}")
//    private String accessKey;
//    @Value("${cloud.aws.credentials.secretKey}")
//    private String secretKey;
//    @Bean
//    public AmazonS3 amazonS3Client(@Value("${cloud.aws.region.static}") String region) {
//        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
//        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(region).build();
//    }
}
