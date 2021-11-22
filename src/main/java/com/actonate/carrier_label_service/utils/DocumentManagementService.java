package com.actonate.carrier_label_service.utils;

//import com.actonate.api.libs.APIConstants;

import com.actonate.carrier_label_service.constants.AWSConstants;
import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FilenameUtils;
import io.github.biezhi.webp.WebpIO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

//import lombok.extern.slf4j.Slf4j;

@Service
public class DocumentManagementService {

//    @Autowired
//    private AmazonS3 amazonS3Client;
//    private Integer width = 1144;
//    private Integer hight = 248;
//    BufferedImage inputImage;
//    File webpFile;
//    String fileName;
//
//    public String uploadFile(MultipartFile files) {
//        if (files != null) {
//            File file = convertMultiPartFileToFile(files);
//            try {
//                inputImage = ImageIO.read(file);
//            } catch (IOException e) {
//                throw new BadRequestException("Please provide valid file");
//            }
//            try {
//                String fileNameWithOutExt = FilenameUtils.removeExtension(files.getOriginalFilename());
//                WebpIO.create().toWEBP(file.getAbsolutePath(), "./" + fileNameWithOutExt + ".webp");
//                webpFile = new File("./" + fileNameWithOutExt + ".webp");
//                long miliseconds = System.currentTimeMillis();
//                fileName = miliseconds + "_" + files.getOriginalFilename();
//                String webpFileName = miliseconds + "_" + webpFile.getName();
//                String uniqueFileName = AWSConstants.AWS_MEDIA_PATH + fileName;
//                String uniqueWebpFileName = AWSConstants.AWS_MEDIA_PATH + webpFileName;
//                uploadFileToS3bucket(uniqueFileName, file, AWSConstants.BUCKET_NAME);
//                uploadFileToS3bucket(uniqueWebpFileName, webpFile, AWSConstants.BUCKET_NAME);
//                if (webpFile.exists()) {
//                    webpFile.delete();
//                }
//                if (file.exists()) {
//                    file.delete();
//                }
//            } catch (Exception e) {
//                throw new BadRequestException("Please provide valid file");
//            }
//            return fileName;
//        }
//        return null;
//    }
//
//    public void uploadMultipleFiles(List<MultipartFile> files) {
//        if (files != null) {
//            files.forEach(multipartFile -> {
//                File file = convertMultiPartFileToFile(multipartFile);
//                try {
//                    BufferedImage inputImage = ImageIO.read(file);
//                    String fileNameWithOutExt = FilenameUtils.removeExtension(multipartFile.getOriginalFilename());
//                    WebpIO.create().toWEBP(file.getAbsolutePath(), "./" + fileNameWithOutExt + ".webp");
//                    webpFile = new File("./" + fileNameWithOutExt + ".webp");
////                    if (form.getHeight() != inputImage.getHeight() && form.getWidth() != inputImage.getWidth()) {
////                        System.out.println("Dimention is not matched----------------------");
////                    }
//                    long miliseconds = System.currentTimeMillis();
//                    String webpFileName = miliseconds + "_" + webpFile.getName();
//                    String uniqueFileName = miliseconds + "_" + multipartFile.getOriginalFilename();
//                    String uniqueWebpFileName = AWSConstants.AWS_MEDIA_PATH + webpFileName;
//                    uploadFileToS3bucket(uniqueFileName, file, AWSConstants.BUCKET_NAME);
//                    uploadFileToS3bucket(uniqueWebpFileName, webpFile, AWSConstants.BUCKET_NAME);
//                    if (webpFile.exists()) {
//                        webpFile.delete();
//                    }
//                    if (file.exists()) {
//                        file.delete();
//                    }
//                } catch (IOException e) {
//                    throw new BadRequestException("Please provide valid file");
//                } catch (Exception e) {
//                    throw new BadRequestException("Please provide valid file");
//                }
//            });
//        }
//    }
//
//    // private void uploadFileToS3bucket(String fileName, File file, String
//    // bucketName) {
//    // amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
//    // amazonS3Client
//    // .putObject(new PutObjectRequest(bucketName, fileName,
//    // file).withCannedAcl(CannedAccessControlList.PublicRead));
//    // }
//
//    private void uploadFileToS3bucket(String fileName, File file, String bucketName) {
//        amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setCacheControl("max-age=31536000");
//        amazonS3Client
//                .putObject(new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead))
//                .setMetadata(objectMetadata);
//    }
//
//    // private S3Object downloadFileFromS3bucket(String fileName, String bucketName)
//    // {
//    // S3Object object = amazonS3Client.getObject(bucketName, fileName);
//    // return object;
//    // }
//    // private void deleteFileFromS3bucket(String fileName, String bucketName) {
//    // amazonS3Client.deleteObject(bucketName, fileName);
//    // }
//
//    public File convertMultiPartFileToFile(MultipartFile file) {
//        File convertedFile = new File(file.getOriginalFilename());
//        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
//            fos.write(file.getBytes());
//        } catch (IOException e) {
//            System.out.println("Error converting multipartFile to file " + e);
//        }
//        return convertedFile;
//    }

}
