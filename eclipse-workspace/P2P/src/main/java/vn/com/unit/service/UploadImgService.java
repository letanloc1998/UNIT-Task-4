package vn.com.unit.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;

public class UploadImgService {

	public static String resizeImgCloudinaryByUrl(String url, Integer width, Integer height) {
		String result_url = url.replace("/image/upload/q_auto/", "/image/upload/");
		return result_url.replace("/image/upload/",
				"/image/upload/q_auto/w_" + width.toString() + ",h_" + height.toString() + "/");
	};

	public static String uploadCloudinary(MultipartFile multipartFile) {
		return uploadCloudinary(multipartFile, null, null);
	}

	public static String uploadCloudinary(MultipartFile multipartFile, Integer width, Integer height) {

		// Limit width, height img
		if (width == null || height == null) {
			width = 1024;
			height = 1024;
		}

		String time = String.valueOf(System.currentTimeMillis());

		String multipart_file_name = time + "_" + multipartFile.getOriginalFilename();

		String file_path = new File("").getAbsolutePath() + "/" + multipart_file_name;

		File temp_file = new File(file_path);

		try {

			multipartFile.transferTo(temp_file);

			Map<String, String> config = new HashMap<String, String>();
			config.put("cloud_name", "sodepr");
			config.put("api_key", "434272393799268");
			config.put("api_secret", "0TRwfILbqMsDPXyT_r8QCdsxpIM");
			Cloudinary cloudinary = new Cloudinary(config);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("folder", "p2po");
			params.put("public_id", time);
			params.put("overwrite", "false");

			params.put("transformation",
					new Transformation().width(1024).height(1024).quality("auto").fetchFormat("auto").crop("limit"));

			Map uploadResult = cloudinary.uploader().upload(temp_file, params);

			String url = (String) uploadResult.get("url");

			url = url.replace("/image/upload/", "/image/upload/q_auto/");

			temp_file.delete();

			return url;

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

}
