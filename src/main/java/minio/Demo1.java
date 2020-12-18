package minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author yuweixiong
 * @date 2020/11/19 20:49
 * @description
 */
public class Demo1 {
    private static final String ENDPOINT = "http://192.168.0.152:15900";
    private static final String ACCESS_KEY = "sunmi";
    private static final String SECRET_KEY = "sunmi@168";
    private static final String BUCKET = "test3";

    private static MinioClient minioClient;

    public Demo1(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public static void main(String[] args) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        MinioClient minioClient =
                MinioClient.builder().endpoint(ENDPOINT).credentials(ACCESS_KEY, SECRET_KEY).build();

        boolean isBucketExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET).build());
        if (!isBucketExist) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET).build());
        }

    }

}
