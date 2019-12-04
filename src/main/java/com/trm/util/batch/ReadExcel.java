package com.trm.util.batch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.trm.constants.SystemConstants;
import com.trm.entity.exception.BusinessException;
import com.trm.util.CommonUtil;

public class ReadExcel {
    private final int startRow = 2;

    /**
     * 读取excel中的数据
     * @param path
     * @return List<BatchEquip>
     * @author zhaosimiao
     */
    public List<BatchEquip> readExcel(String path) throws BusinessException{

        if (path != null && !path.equals("")) {
            String ext = getExt(path);
            if (ext != null && !ext.equals("")) {
                if (ext.equals("xls")) {
                    return readXls(path);
                } else if (ext.equals("xlsx")) {
                    return readXlsx(path);
                }
            }
        }
        return new ArrayList<BatchEquip>();
    }

    /**
     * 读取后缀为xls的excel文件的数据
     * @param path
     * @return List<BatchEquip>
     * @author zhaosimiao
     */
    private List<BatchEquip> readXls(String path) throws BusinessException{

        HSSFWorkbook hssfWorkbook = null;
        try {
            InputStream is = new FileInputStream(path);
            hssfWorkbook = new HSSFWorkbook(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BatchEquip batch = null;
        List<BatchEquip> list = new ArrayList<BatchEquip>();
        if (hssfWorkbook != null) {
            // Read the Sheet
        	// 只读取sheet1中的数据，不循环遍历每个sheet
            /*for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {*/
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
                /*if (hssfSheet == null) {
                    continue;
                }*/
                // Read the Row
                for (int rowNum = startRow; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        batch = new BatchEquip();
                        
                        HSSFCell cellEquipName = hssfRow.getCell(0);
                        HSSFCell cellEquipType = hssfRow.getCell(1);
                        HSSFCell cellServiceRange = hssfRow.getCell(2);
                        HSSFCell cellEquipVerCode = hssfRow.getCell(3);
                        HSSFCell cellProCountry = hssfRow.getCell(4);
                        HSSFCell cellCreateFirm = hssfRow.getCell(5);
                        HSSFCell cellServiceMode = hssfRow.getCell(6);
                        HSSFCell cellEquipValue = hssfRow.getCell(7);
                        HSSFCell cellPurchaseDate = hssfRow.getCell(8);
                        HSSFCell cellLinkPerson = hssfRow.getCell(9);
                        HSSFCell cellEmail = hssfRow.getCell(10);
                        HSSFCell cellLinkPhone = hssfRow.getCell(11);
                        HSSFCell cellUseField = hssfRow.getCell(12);
                        HSSFCell cellQualification = hssfRow.getCell(13);
                        HSSFCell cellTecFeature = hssfRow.getCell(14);

                        String equipName = getValue(cellEquipName);
                        String equipType = getValue(cellEquipType);
                        String serviceRange = getValue(cellServiceRange);
                        String equipVerCode = getValue(cellEquipVerCode);
                        String proCountry = getValue(cellProCountry);
                        String createFirm = getValue(cellCreateFirm);
                        String serviceMode = getValue(cellServiceMode);
                        String equipValue = getValue(cellEquipValue);
                        String purchaseDate = getValue(cellPurchaseDate);
                        String linkPerson = getValue(cellLinkPerson);
                        String email = getValue(cellEmail);
                        String linkPhone = getValue(cellLinkPhone);
                        String useField = getValue(cellUseField);
                        String qualification = getValue(cellQualification);
                        String tecFeature = getValue(cellTecFeature);
                        
                        if (!CommonUtil.isEmpty(equipName, equipType, serviceRange, equipVerCode, proCountry, createFirm, serviceMode, equipValue, purchaseDate,
                    			 linkPerson, email, linkPhone, useField, qualification, tecFeature)) {
	                        batch.setEquipName(equipName);
	                        batch.setEquipType(equipType);
	                        batch.setServiceRange(serviceRange);
	                        batch.setEquipVerCode(equipVerCode);
	                        batch.setProCountry(proCountry);
	                        batch.setCreateFirm(createFirm);
	                        batch.setServiceMode(serviceMode);
	                        batch.setEquipValue(equipValue);
	                        batch.setPurchaseDate(purchaseDate);
	                        batch.setLinkPerson(linkPerson);
	                        batch.setEmail(email);
	                        batch.setLinkPhone(linkPhone);
	                        batch.setUseField(useField);
	                        batch.setQualification(qualification);
	                        batch.setTecFeature(tecFeature);
	                        list.add(batch);
                        }
                        else {
                            BusinessException bs = new BusinessException();
                            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
                            bs.setExceptionMsg("导入模板中，存在填写不完整的行信息，请核对！");
                            throw bs;
                        }
                    }
                /*}*/
            }
        }
        return list;
    }

    /**
     * 读取后缀为xlsx的excel文件的数据
     * @param path
     * @return List<BatchEquip>
     * @author zhaosimiao
     */
    private List<BatchEquip> readXlsx(String path) throws BusinessException{

        XSSFWorkbook xssfWorkbook = null;
        try {
            InputStream is = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BatchEquip batch = null;
        List<BatchEquip> list = new ArrayList<BatchEquip>();
        if (xssfWorkbook != null) {
            // Read the Sheet
            /*for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {*/
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
                /*if (xssfSheet == null) {
                    continue;
                }*/
                // Read the Row
                for (int rowNum = startRow; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                    	
                    	batch = new BatchEquip();
                        
                    	XSSFCell cellEquipName = xssfRow.getCell(0);
                        XSSFCell cellEquipType = xssfRow.getCell(1);
                        XSSFCell cellServiceRange =xssfRow.getCell(2);
                        XSSFCell cellEquipVerCode = xssfRow.getCell(3);
                        XSSFCell cellProCountry = xssfRow.getCell(4);
                        XSSFCell cellCreateFirm = xssfRow.getCell(5);
                        XSSFCell cellServiceMode = xssfRow.getCell(6);
                        XSSFCell cellEquipValue = xssfRow.getCell(7);
                        XSSFCell cellPurchaseDate = xssfRow.getCell(8);
                        XSSFCell cellLinkPerson = xssfRow.getCell(9);
                        XSSFCell cellEmail = xssfRow.getCell(10);
                        XSSFCell cellLinkPhone = xssfRow.getCell(11);
                        XSSFCell cellUseField = xssfRow.getCell(12);
                        XSSFCell cellQualification = xssfRow.getCell(13);
                        XSSFCell cellTecFeature = xssfRow.getCell(14);

                        String equipName = getValue(cellEquipName);
                        String equipType = getValue(cellEquipType);
                        String serviceRange = getValue(cellServiceRange);
                        String equipVerCode = getValue(cellEquipVerCode);
                        String proCountry = getValue(cellProCountry);
                        String createFirm = getValue(cellCreateFirm);
                        String serviceMode = getValue(cellServiceMode);
                        String equipValue = getValue(cellEquipValue);
                        String purchaseDate = getValue(cellPurchaseDate);
                        String linkPerson = getValue(cellLinkPerson);
                        String email = getValue(cellEmail);
                        String linkPhone = getValue(cellLinkPhone);
                        String useField = getValue(cellUseField);
                        String qualification = getValue(cellQualification);
                        String tecFeature = getValue(cellTecFeature);
                        
                        if (!CommonUtil.isEmpty(equipName, equipType, serviceRange, equipVerCode, proCountry, createFirm, serviceMode, equipValue, purchaseDate,
                    			 linkPerson, email, linkPhone, useField, qualification, tecFeature)) {
	                        batch.setEquipName(equipName);
	                        batch.setEquipType(equipType);
	                        batch.setServiceRange(serviceRange);
	                        batch.setEquipVerCode(equipVerCode);
	                        batch.setProCountry(proCountry);
	                        batch.setCreateFirm(createFirm);
	                        batch.setServiceMode(serviceMode);
	                        batch.setEquipValue(equipValue);
	                        batch.setPurchaseDate(purchaseDate);
	                        batch.setLinkPerson(linkPerson);
	                        batch.setEmail(email);
	                        batch.setLinkPhone(linkPhone);
	                        batch.setUseField(useField);
	                        batch.setQualification(qualification);
	                        batch.setTecFeature(tecFeature);
	                        list.add(batch);
                        }
                        else {
                            BusinessException bs = new BusinessException();
                            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
                            bs.setExceptionMsg("导入模板中，存在填写不完整的行信息，请核对！");
                            throw bs;
                        }
                    }
                /*}*/
            }
        }
        return list;
    }

    /**
     * 获取文件扩展名
     * @param path
     * @return String
     * @author zhaosimiao
     */
    private String getExt(String path) {
        if (path == null || path.equals("") || !path.contains(".")) {
            return null;
        } else {
            return path.substring(path.lastIndexOf(".") + 1, path.length());
        }
    }

    /**
     * 判断后缀为xlsx的excel文件的数据类型
     * @param xssfRow
     * @return String
     * @author zhaosimiao
     */
    private String getValue(XSSFCell xssfRow) {
        if (null == xssfRow) {
            return null;
        }
        // 处理时间类型  add by zhaosimiao
        String dateType = xssfRow.getCellStyle().getDataFormatString();
        if ("yyyy/mm;@".equals(dateType)
                || "m/d/yy".equals(dateType)
                || "yy/m/d".equals(dateType)
                || "mm/dd/yy".equals(dateType)
                || "dd-mmm-yy".equals(dateType)
                || "yyyy/m/d".equals(dateType)) {
            Date date = xssfRow.getDateCellValue();
            if(null == date){
                return null;
            }
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
        else {
        	xssfRow.setCellType(Cell.CELL_TYPE_STRING);
            return String.valueOf(xssfRow.getStringCellValue());
        }

        /*if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }*/
    }

    /**
     * 判断后缀为xls的excel文件的数据类型
     * @param hssfCell
     * @return String
     * @author zhaosimiao
     */
    private String getValue(HSSFCell hssfCell) {
        if (null == hssfCell) {
            return null;
        }
        // 处理时间类型  add by zhaosimiao
        if ("yyyy/mm;@".equals(hssfCell.getCellStyle().getDataFormatString())
                || "m/d/yy".equals(hssfCell.getCellStyle().getDataFormatString())
                || "yy/m/d".equals(hssfCell.getCellStyle().getDataFormatString())
                || "mm/dd/yy".equals(hssfCell.getCellStyle().getDataFormatString())
                || "dd-mmm-yy".equals(hssfCell.getCellStyle().getDataFormatString())
                || "yyyy/m/d".equals(hssfCell.getCellStyle().getDataFormatString())) {
            Date date = hssfCell.getDateCellValue();
            if(null == date){
                return null;
            }
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
        else {
        	hssfCell.setCellType(Cell.CELL_TYPE_STRING);
        	return String.valueOf(hssfCell.getStringCellValue());
        }

        /*if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }*/
    }

    public static void main(String[] args) throws BusinessException{
        // System.out.println(new ReadExcel().readExcel("D://patent.xlsx").size());
        //    	List<BatchEquip> list = new ReadExcel().readXlsx("D://apply.xls");
        List<BatchEquip> list = new ReadExcel().readExcel("D://apply.xls");
        for (BatchEquip batch : list) {
            System.out.println(batch.toString());
        }
    }

}
