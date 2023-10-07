package com.chenk.sca.service.impl;

import com.chenk.sca.service.AwsE3Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@Service
@Component
public class AwsE3ServiceImpl implements AwsE3Service {

    private static String bucketName = "";
    private static String accessKey="";
    private static String secretKey="";
    @Override
    public void upload() throws IOException {
        Region region = Region.AP_NORTHEAST_1;
        AwsCredentialsProvider awsCredentialsProvider = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));


        S3Client s3 = S3Client.builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(region)
                .build();
// create a bucket
//        try {
//            CreateBucketRequest createBucketRequest = CreateBucketRequest.builder()
//                    .bucket(bucketName)
//                    .createBucketConfiguration(
//                            CreateBucketConfiguration.builder()
//                                    .locationConstraint(region.id())
//                                    .build())
//                    .build();
//
//            s3.createBucket(createBucketRequest);
//            System.out.println("Bucket created successfully!");
//        } catch (S3Exception e) {
//            e.printStackTrace();
//        }
        String path = "/Users/chenk/Pictures/Wallpaper/";
        String name = "2.jpg";
        byte[] bytes = Files.readAllBytes(Paths.get(path+name));

        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(name)
                .build();

        s3.putObject(objectRequest, RequestBody.fromByteBuffer(ByteBuffer.wrap(bytes)));
    }

    private static ByteBuffer getRandomByteBuffer(int size) throws IOException {
        byte[] b = new byte[size];
        new Random().nextBytes(b);
        return ByteBuffer.wrap(b);
    }
}
