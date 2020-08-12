package com.fastdfs;

import org.csource.fastdfs.*;

class TestFastDfs {
    // 测试文件上传
    public static void main(String[] args) {
        try {
//1 加载配置文件
            ClientGlobal.init("fastdfs.properties");
// 2 创建客户端对象
            TrackerClient trackerClient=new TrackerClient();
//3 创建一个对象连接
            TrackerServer trackerServer = trackerClient.getConnection();
//4 创建一个 storageServer 引用，值为空
            StorageServer storageServer=null;
// 5 创建一个 storageClient 对象，提供两个参数：对象连接和 storageServer
            StorageClient storageClient=new
                    StorageClient(trackerServer,storageServer);
/*
            // 6 使用 storageClient 查看文件信息
            FileInfo fi = storageClient.get_file_info("group1",
                    "M00/00/00/wKgBHl5-IcOACNM_AAIvyRIC0Wo367.jpg");
            System.out.println("址 文件的服务器地址 = " + fi.getSourceIpAddr());
            System.out.println("小 文件大小 = " + fi.getFileSize());
            System.out.println("间 文件创建的时间 = " + fi.getCreateTimestamp());
*/
            // 6 使用 storageClient 删除文件
            int temp = storageClient.delete_file("group1",
                    "M00/00/00/wKgBHl5-IcOACNM_AAIvyRIC0Wo367.jpg");
/*
// 6 使用 storageClient 上传文件：将本地d盘中的名称为123图片上传到fastdf服务器，上传到服务器后的文件后缀为 jpg
            String[] strings = storageClient.upload_file("D:\\images\\1556711072346.jpg",
                    "jpg", null);
// 上传后的文件信息都在 strings
            System.out.println(" 上传文件成功！");
            System.out.println(" 上传的文件信息：");
            for (String info : strings) {
                System.out.println("string = " + info);
            }
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}