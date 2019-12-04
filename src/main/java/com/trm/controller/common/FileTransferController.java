package com.trm.controller.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.trm.constants.SystemConstants;
import com.trm.entity.business.CommonResponse;
import com.trm.entity.exception.BusinessException;
import com.trm.model.file.DownloadFileRequest;
import com.trm.model.file.FileEntity;
import com.trm.model.file.FilePathRequest;
import com.trm.model.file.FilePathsResponse;
import com.trm.model.file.IOException_Exception;
import com.trm.model.file.UploadFileRequest;
import com.trm.model.file.UploadResponse;
import com.trm.util.FileUtil;
import com.trm.util.UploadFileUtil;

@Controller
public class FileTransferController {

    private static Logger logger = LoggerFactory.getLogger(FileTransferController.class);
    /** 图片文件类型 */
    private static String[] PIC_TYPES = { "jpg", "jpeg", "bmp", "png", "pic" };

    /** 视频文件类型 */
    private static String[] VEDIO_TYPES = { "rm", "rmvb", "mov", "mtv", "dat", "wmv", "avi", "3gp", "amv", "dmv" };

    /**视频文件路径*/
    private static final String VEDIO_PATH = "vedio/";

    /** 文本文件类型 */
    private static String[] DOCUMENTS_TYPES = { "txt", "doc", "docx", "xls", "xlsx", "ppt", "pptx" };

    /**文本文件路径*/
    private static final String DOCUMENT_PATH = "doc/";

    /** 压缩文件类型 */
    private static String[] COMPRESS_TYPES = { "rar", "zip" };

    /**压缩文件路径*/
    private static final String COMPRESSED_PATH = "comp/";

    /**其他文件路径*/
    private static final String OTHER_PATH = "other/";

    /**图片虚拟路径*/
    @Value("#{filePath.virtual_path}")
    private String virtualPath;
    /**图片物理路径*/
    @Value("#{filePath.physical_path}")
    private String physicalPath;

    /**除图片以外的文件虚拟路径*/
    @Value("#{filePath.virtual_file_path}")
    private String virtualFilePath;
    /**除图片以外的文件物理路径*/
    @Value("#{filePath.physical_file_path}")
    private String physicalFilePath;

    @Value("#{filePath.domain}")
    private String domain;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public FilePathsResponse uploadFile(UploadFileRequest uploadRequest) throws BusinessException, IOException {

        CommonsMultipartFile[] files = uploadRequest.getFiles();
        if (null == files) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("files is null(文件为空)");
            throw bs;
        }
        List<UploadResponse> uploadResponses = new ArrayList<UploadResponse>();
        //因为服务端需要接收一个FileEntity实例，这个实例包含了文件的所有信息
        List<FileEntity> fs = new ArrayList<FileEntity>();
        for (int i = 0; i < files.length; i++) {
            if (null != uploadRequest.getFiles()[i] && null != uploadRequest.getFiles()[i].getOriginalFilename()) {

                //接收前端传过来的文件对象
                MultipartFile multipartFile = uploadRequest.getFiles()[i];

                String name = multipartFile.getOriginalFilename();
                FileEntity fe = new FileEntity();
                fe.setFileName(name.substring(0, name.lastIndexOf(".")));
                fe.setFileType(name.substring(name.lastIndexOf(".") + 1));
                //把文件以字节的形式传递给服务端
                //				fe.setFile(multipartFile.getBytes());
                fs.add(fe);

                String fileName = fe.getFileName();
                String fileType = fe.getFileType();
                logger.info("======fileName:" + fileName + ",fileType:" + fileType);
                String originalName = fileName + "." + fileType;

                // 文件路径：  由/module/year/month/day/file.type组成
                // String filePath = "/" + module + "/" + FileUtil.createDatePath() + "/" + FileUtil.createFileName(6)+"."+fileType;
                String filePath = "/" + FileUtil.createDatePath() + "/" + FileUtil.createFileName(6) + "." + fileType;
                String accessPath = "";
                String path = "";
                // 非图片访问、存储路径
                if (isPicture(fileType)) {
                    // 图片访问路径
                    accessPath = virtualPath + filePath;
                    // 图片存储路径
                    path = physicalPath + filePath;
                } else {
                    accessPath = virtualFilePath + filePath;
                    path = physicalFilePath + filePath;
                }

                long size = this.getFileLength(path);

                // 得到上传的文件的文件名
                InputStream inputStream = multipartFile.getInputStream();

                UploadFileUtil.uploadFileToDes(inputStream, path);
                uploadResponses
                        .add(new UploadResponse(accessPath, originalName, null, size, fileType, new Date(), null));
            }
        }
        //返回上传文件的虚拟路径,虚拟路径包括了域名
        FilePathsResponse fps = new FilePathsResponse();

        List<String> list = new ArrayList<String>();
        for (UploadResponse upload : uploadResponses) {
            list.add(domain + upload.getAccessPath());
        }
        fps.setFilePaths(list);
        for (int i = 0; i < fps.getFilePaths().size(); i++) {
            logger.info("文件的虚拟路径:" + fps.getFilePaths().get(i));
        }
        return fps;
    }

    @RequestMapping(value = "/downFile", method = RequestMethod.POST)
    public ModelAndView downFile(DownloadFileRequest request) throws IOException {
        ModelAndView view = new ModelAndView();
        URL fileUrl = null;
        // 获取文件的类型
        int index = request.getFilePath().lastIndexOf(".");
        String type = request.getFilePath().substring(index);
        // 文件存储的路径
        String newPath = request.getTargetPath() + "/" + request.getName() + type;

        try {
            fileUrl = new URL(request.getFilePath());
            DataHandler handler = new DataHandler(fileUrl);
            // 复制文件到指定的路径下
            UploadFileUtil.uploadFileToDes(handler.getInputStream(), newPath);
            view.setViewName("success");
        } catch (MalformedURLException e) {
            logger.error("下载文件异常！ " + e.getMessage());
            throw e;
        }

        return view;
    }

    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse deleteFile(@RequestBody FilePathRequest uploadRequest) throws IOException_Exception, IOException {
		String sPath = uploadRequest.getFilePath();
		FileUtil fileUtil = new FileUtil();
		CommonResponse msg = new CommonResponse();
		logger.info("=============================before replace filePath: " + sPath);
		if(sPath.contains(virtualPath)) {
			// 将传入的虚拟路径转换为物理路径
			sPath = sPath.replace(virtualPath, physicalPath);
		}
		if(sPath.contains(virtualFilePath)) {
			// 将传入的虚拟路径转换为物理路径
			sPath = sPath.replace(virtualFilePath, physicalFilePath);
		}
		logger.info("=============================after replace filePath: " + sPath);
		
		boolean deleteFlag = fileUtil.deleteFolder(sPath);
		if(deleteFlag) {
			msg.setMessage(SystemConstants.TRM_SUCCESS);
		}
		else{
			msg.setMessage(SystemConstants.TRM_ERROR);
		}
		return msg;
	}
    
    /**
     * 判断上传的文件类型是否为图片
     * @param type
     * @return
     */
    private boolean isPicture(String type) {
        if (Arrays.asList(PIC_TYPES).contains(type.toLowerCase()))
            return true;
        else
            return false;
    }

    /**  
     * @description 根据文件类型得到其存储的子路径  
     * @param type 文件类型
     * @return String    文件存储的子路径 
     */
    @SuppressWarnings("unused")
    private String getFileSubPathByType(String type) {

        String subPath = OTHER_PATH;
        if (Arrays.asList(VEDIO_TYPES).contains(type.toLowerCase())) {
            return VEDIO_PATH;
        }
        if (Arrays.asList(DOCUMENTS_TYPES).contains(type.toLowerCase())) {
            return DOCUMENT_PATH;
        }
        if (Arrays.asList(COMPRESS_TYPES).contains(type.toLowerCase())) {
            return COMPRESSED_PATH;
        }
        return subPath;
    }

    /**  
     * @description 根据文件路径得到文件大小
     * @param path 文件路径
     * @return long 文件大小
     */
    private long getFileLength(String path) {
        long size = 0;
        File f = new File(path);
        if (f.exists() && f.isFile()) {
            size = f.length();
        }
        return size;
    }

}
