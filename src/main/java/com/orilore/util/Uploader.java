package com.orilore.util;
import java.io.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用于实现文件上传的工具类
 * @author Yue
 */
public class Uploader {
	public static String upload(MultipartFile file,String path){
		//获取原始图片名称
		String oname = file.getOriginalFilename();
		//获取图片扩展名
		String ext = oname.substring(oname.lastIndexOf("."));
		//使用时间戳算法生成新的文件名称
		String fname = System.currentTimeMillis()+ext;
		//构建目标文件
		File dest = new File(path+"\\"+fname);
		try {
			//将内存中的文件保存成磁盘物理文件
			file.transferTo(dest);
			return fname;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
