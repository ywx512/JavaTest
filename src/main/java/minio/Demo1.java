package minio;

import io.minio.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * @author yuweixiong
 * @date 2020/11/19 20:49
 * @description
 */
public class Demo1 {
    private static final String ENDPOINT = "http://192.168.128.207:15900/";
    private static final String ACCESS_KEY = "sunmi";
    private static final String SECRET_KEY = "sunmi@168";
    private static final String BUCKET = "test";

    private static MinioClient minioClient;

    public Demo1(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public static void main(String[] args) throws Exception {
        minioClient = MinioClient.builder().endpoint(ENDPOINT).credentials(ACCESS_KEY, SECRET_KEY).build();

        boolean isBucketExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET).build());
        if (!isBucketExist) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET).build());
        }

//        uploadObject(BUCKET, "data2.txt", "test/data.txt");
//        putObject(BUCKET, "data3.txt", new FileInputStream(new File("test/data.txt")));
        download(BUCKET, "data.txt", "test/data4.txt");
    }

    /**
     * 上传文件
     *
     * @param bucket
     * @param fileName
     * @param filePath
     * @throws Exception
     */
    public static void uploadObject(String bucket, String fileName, String filePath) throws Exception {
        minioClient.uploadObject(UploadObjectArgs.builder().bucket(bucket).object(fileName).filename(filePath).build());
    }

    /**
     * 流式上传文件
     *
     * @param bucket
     * @param objectKey
     * @param inputStream
     * @throws Exception
     */
    public static void putObject(String bucket, String objectKey, InputStream inputStream) throws Exception {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucket).object(objectKey).stream(inputStream,
                inputStream.available(), -1).build());
    }

    /**
     * 下载文件
     * @param bucket
     * @param objectKey
     * @param filePath
     * @throws Exception
     */
    public static void download(String bucket, String objectKey, String filePath) throws Exception {
        InputStream inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucket).object(objectKey).build());

        ReadableByteChannel inChannel = Channels.newChannel(inputStream);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileChannel outChannel = new FileOutputStream(filePath).getChannel();

        while (inChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        inChannel.close();
        outChannel.close();
        inputStream.close();
    }
}
