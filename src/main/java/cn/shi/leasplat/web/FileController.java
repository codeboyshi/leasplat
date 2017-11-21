package cn.shi.leasplat.web;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.shi.leasplat.annotation.Auditable;
import cn.shi.leasplat.entity.File;
import cn.shi.leasplat.entity.GoodsImage;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.service.FileService;
import cn.shi.leasplat.service.GoodsImageService;
import cn.shi.leasplat.service.UserService;
import cn.shi.leasplat.util.FilePath;
import cn.shi.leasplat.util.Result;

@Controller
@RequestMapping("/file")
public class FileController {

	@Resource(name = "fileService")
	private FileService fileService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GoodsImageService goodsImageService;
	
	@RequestMapping("/read.do")
	@ResponseBody
	public Result getById(@RequestParam(value="imgId") Integer id)
	{
		Result res = new Result();
		try {
			File file = fileService.getById(id);
			res.setData(file);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	//读取图片输出
	@RequestMapping("/readImg.do")
	public void readImg(@RequestParam Integer imgId, HttpServletResponse response)
	{
		OutputStream out = null;
		FileInputStream fis = null;
		try {
			File file = fileService.getById(imgId);
			java.io.File f = new java.io.File(file.getPath());
			out = response.getOutputStream();
			fis = new FileInputStream(f);
			byte attr[] = new byte[2048];
			int len = -1;
			while ((len = fis.read(attr)) > -1)
			{
				out.write(attr);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
		//读取商品图片输出
		@RequestMapping("/readImgTwo.do")
		public void readImg2(@RequestParam Integer imageId, HttpServletResponse response)
		{
			OutputStream out = null;
			FileInputStream fis = null;
			try {
				GoodsImage goodsImage = goodsImageService.getById(imageId);
				java.io.File f = new java.io.File(goodsImage.getPath());
				out = response.getOutputStream();
				fis = new FileInputStream(f);
				byte attr[] = new byte[2048];
				int len = -1;
				while ((len = fis.read(attr)) > -1)
				{
					out.write(attr);
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	
	@RequestMapping("/save")
	@ResponseBody
	@Auditable(moduleName="文件管理", operationName="添加")
	public Result save(HttpServletRequest req, String imageName)
	{
		//System.out.println(imageName);
		  Result res = new Result();
		  InputStream is = null;
		  FileOutputStream fos = null;
	        try {
	        	
	        	String userId = "";
	            Cookie [] cookie = req.getCookies();
	    		for (int i = 0;i < cookie.length;i++)
	    		{
	    			if ("userId".equals(cookie[i].getName()))
	    			{
	    				userId = cookie[i].getValue();
	    			}
	    		}
	    		User user = userService.findUserById(Integer.parseInt(userId));
	            Random r = new Random();
	            Date date = new Date();
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	            String logoPathDir = FilePath.FILE_PATH + java.io.File.separator
	            		+ user.getUserName() + java.io.File.separator + "goodsImage" 
	            		+ java.io.File.separator + dateFormat.format(date) + java.io.File.separator;
	            //TODO:单文件上传没问题，还要测试多文件上传
	            //D:\leasplat\admin\goodsImage\20170404\20170404222846678-18415284
	            String newFileName = sdf.format(date) + "-" + (r.nextInt(10000000) + 10000000);
	            MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest)req;
	            //获取文件
	            MultipartFile fil = mhsr.getFile(imageName);
	            //获取文件名
	            //String fileName = fil.getOriginalFilename();
	            //System.out.println(fileName);
	            BufferedImage image = ImageIO.read(fil.getInputStream());
	            java.io.File goodsFile = new java.io.File(logoPathDir);
	            //设置权限 
	            goodsFile.setWritable(true, false);
	            //判断目录不存在
	            if (!goodsFile.exists()) goodsFile.mkdirs();
	            
	            is = fil.getInputStream();
	            fos = new FileOutputStream(new java.io.File(logoPathDir, newFileName));
	            
	            int len = -1;
	            byte [] buff = new byte[4096];
	            while((len = is.read(buff)) > -1)
	            {
	            	fos.write(buff,0,len);
	            }
	            //插入数据库
	    		File file = new File();//实体类
	    		file.setPath(logoPathDir + newFileName);
	    		fileService.save(file);
	    		Integer imageId = fileService.getId();
	    		file = fileService.getById(imageId);
	    		res.setData(file);
	            }catch (Exception e) {
					res.setError(e);
				}finally{
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			return res;
	}
}
