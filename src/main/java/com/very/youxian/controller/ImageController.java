package com.very.youxian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.very.youxian.entity.ImageStore;
import com.very.youxian.service.ImageStoreService;
import com.very.youxian.util.IdGenerator;

@RestController
@ComponentScan
@RequestMapping("/image")
public class ImageController {
	@Autowired
	private ImageStoreService imageStoreService;

	@RequestMapping("/")
	public String home() {
		return "Hello";
	}

	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Integer addImage(@RequestBody ImageStore image) {
		image.setImageId(IdGenerator.uuid32());
		Integer result = imageStoreService.addImage(image);
		return result;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/findimagebyitemid", method = RequestMethod.POST)
	@ResponseBody
	public List<ImageStore> findImageByItemId(@RequestBody ImageStore image) {
		List<ImageStore> imglst = imageStoreService.findImageByItemId(image.getItemId());
		return imglst;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteImage(@RequestBody ImageStore image) {
		Integer result = imageStoreService.deleteImageByName(image.getItemId(),image.getImageName());
		return result;
	}	
}
