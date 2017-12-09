package cn.e3.fastdfs;

import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3.utils.FastDFSClient;

public class MyFastDFS {

	@Test
	public void uploadPicTest01() throws Exception{
		//指定上传图片
		String pic = "C:\\Users\\dell\\Desktop\\0.jpg";
		//指定配置文件绝对路径
		String client = "D:\\java\\e3\\e3mall-manager-web\\src\\main\\"
				+ "resources\\conf\\client.conf";
		
		ClientGlobal.init(client);
		
		//创建trackerServer服务对象
		TrackerClient tClient = new TrackerClient();
		//从客户端对象中获取服务对象
		TrackerServer trackerServer = tClient.getConnection();
		
		StorageServer storageServer = null;
		StorageClient sClient = new StorageClient(trackerServer, storageServer);
		
		String[] urls = sClient.upload_file(pic, "jpg", null);
		
		for (String string : urls) {
			System.out.println(string);
		}
		
		
	}
	@Test
	public void uploadPicTest02() throws Exception{
		//指定上传图片
		String pic = "C:\\Users\\dell\\Desktop\\0.jpg";
		//指定配置文件绝对路径
		String client = "D:\\java\\e3\\e3mall-manager-web\\src\\main\\"
				+ "resources\\conf\\client.conf";
		
		//创建工具类
		FastDFSClient fastDFSClient = new FastDFSClient(client);
		//上传
		String url = fastDFSClient.uploadFile(pic);
		
		System.out.println(url);
		
		
	}
}
