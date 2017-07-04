package com.very.youxian.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.very.youxian.setting.YouXianSetting;
import com.very.youxian.util.IdGenerator;

@RestController
@ComponentScan
@RequestMapping("/upload")
public class FileUploadController {
	private static final Logger LOGGER = Logger.getLogger(FileUploadController.class);
	@Autowired
	private YouXianSetting yxSetting;

	@CrossOrigin
	@RequestMapping(value = "/img", method = RequestMethod.POST)
	@ResponseBody
	public List<String> handleFileUpload(HttpServletRequest request) {
		List<String> imglst = new ArrayList<String>();
		try {
			List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("uploadimg");
			MultipartFile file = null;
			BufferedOutputStream stream = null;

			for (int i = 0; i < files.size(); ++i) {
				file = files.get(i);
				if (file.isEmpty()) {
					break;
				}
				try {
					String originalFileName = file.getOriginalFilename();
					LOGGER.info("uploadFlePath:" + originalFileName);
					// 截取上传文件的文件名
					String uploadFileName = originalFileName.substring(originalFileName.lastIndexOf('\\') + 1, originalFileName.indexOf('.'));
					LOGGER.info("multiReq.getFile()" + uploadFileName);
					// 截取上传文件的后缀
					String uploadFileSuffix = originalFileName.substring(originalFileName.indexOf('.') + 1, originalFileName.length());
					LOGGER.info("uploadFileSuffix:" + uploadFileSuffix);

					File dir = new File(yxSetting.getUploadImagePath());
					if (!dir.exists()) {
						dir.mkdirs();
					}
//					String saveName = IdGenerator.uuid32() + "." + uploadFileSuffix;
					stream = new BufferedOutputStream(new FileOutputStream(new File(dir.getAbsolutePath() + File.separator + originalFileName)));
					byte[] bytes = file.getBytes();
					stream.write(bytes, 0, bytes.length);
					imglst.add(originalFileName);
				} catch (Exception e) {
					LOGGER.error(e.toString(), e);
					throw e;
				} finally {
					try {
						if (stream != null) {
							stream.close();
						}
					} catch (IOException e) {
						LOGGER.error(e.toString(), e);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			return null;
		}
		return imglst;
	}
}
