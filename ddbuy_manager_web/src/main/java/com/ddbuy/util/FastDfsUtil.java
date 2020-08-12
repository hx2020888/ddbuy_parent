package com.ddbuy.util;

import org.csource.fastdfs.*;

public class FastDfsUtil {
    public static String [] uploadFile(byte[] bs,String extname) {
        try {
//加载配置文件
            ClientGlobal.init("fastdfs.properties");
//创建客户端对象
            TrackerClient trackerClient = new TrackerClient();
//创建一个对象连接
            TrackerServer trackerServer = trackerClient.getConnection();
//创建一个storageServer引用，值为空
            StorageServer storageServer = null;
//创建一个storageClient对象，提供两个参数：对象连接和storageServer
            StorageClient storageClient = new StorageClient(trackerServer,storageServer);
//使用storageClient上传文件
            String[] strings = storageClient.upload_file(bs, extname, null);
            return strings;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}