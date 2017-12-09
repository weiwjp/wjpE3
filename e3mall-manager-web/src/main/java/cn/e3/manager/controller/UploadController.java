package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3.utils.FastDFSClient;
import cn.e3.utils.JsonUtils;
import cn.e3.utils.KindEditorModel;

@Controller
public class UploadController {

	//图片服务器地址
	@Value("${IMAGE_URL}")
	private String IMAGE_URL;
	
	/**
	 * 请求：/pic/upload
	 * @param uploadFile
	 * @return KindEditorModel
	 * kindEditor要求返回值为{}
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String upload(MultipartFile uploadFile){
		
		try {
			//得到文件的扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			
			//工具类（配置文件的路径）
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			//调用工具类方法,返回图片服务器图片地址
			String fname = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			
			//构造完整图片地址
			String url = IMAGE_URL+fname;
			KindEditorModel kindEditorModel = new KindEditorModel();
			
			kindEditorModel.setUrl(url);
			kindEditorModel.setError(0);
			
			//转换为json字符串
			String jsonString = JsonUtils.objectToJson(kindEditorModel);
			return jsonString;
		} catch (Exception e) {
			e.printStackTrace();
			KindEditorModel kindEditorModel = new KindEditorModel();
			
			kindEditorModel.setMessage("错误信息");
			kindEditorModel.setError(1);
			
			//转换为json字符串
			String jsonString = JsonUtils.objectToJson(kindEditorModel);
			return jsonString;
		} 
		
	}
}
