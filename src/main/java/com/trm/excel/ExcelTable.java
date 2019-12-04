package com.trm.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trm.constants.SystemConstants;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author <a href="mailto:humorbeau@163.com">胡渊博</a>
 * @date 2017年1月6日  
 * @modify by zhaosimiao 2017-3-27 9:52:42
 * @version 1.0
 */
public class ExcelTable {

    private static Logger logger = LoggerFactory.getLogger(ExcelTable.class);

    @SuppressWarnings("rawtypes")
    private Hashtable columnsById = new Hashtable();
    @SuppressWarnings("rawtypes")
    private Hashtable columnsByName = new Hashtable();
    @SuppressWarnings("rawtypes")
    private List table = new LinkedList();
    private Workbook currentWorkbook = null;

    private void loadWorkbook(String filepath) {
        try {
            currentWorkbook = Workbook.getWorkbook(new File(filepath));
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(FileInputStream stream) throws InterruptedException, IOException {
        if (null != stream) {
            stream.close();
        }
        if (null != currentWorkbook) {
            currentWorkbook.close();
        }
    }

    public void loadWorkbook(InputStream inputStream) {
        try {
            currentWorkbook = Workbook.getWorkbook(inputStream);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open(String filepath) {
        loadWorkbook(filepath);
        this.loadSheet(currentWorkbook, 0);
    }

    public void open(InputStream inputStream) {
        loadWorkbook(inputStream);
        this.loadSheet(currentWorkbook, 0);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void loadSheet(Workbook workbook, int sheetNumber) {
        Sheet sheet = workbook.getSheet(0);
        int rowCount = sheet.getRows();
        int colCount = sheet.getColumns();
        int startRow = 3; //开始读取数据的行数
        for (int i = 0; i < colCount; i++) {
            Cell colTlt = sheet.getCell(i, startRow);
            String title = colTlt.getContents();
            columnsById.put(new Integer(i), title);
            columnsByName.put(title, new Integer(i));
        }
        for (int i = startRow; i < rowCount; i++) {
            boolean blankRow = true;
            List rowList = new ArrayList();
            for (int j = 0; j < colCount; j++) {
                Cell cell = sheet.getCell(j, i);
                String cellCont = cell.getContents();
                CellType cellType = cell.getType();
                /**
                 * modify by zhaosimiao 2017-3-27 13:36:36
                 */
                /**********************************BEGIN*******************************************/
                if (StringHelper.isNotEmpty(cellCont)) {
                    // 处理单元格时间格式类型:yy-M-d
                    if (CellType.DATE.equals(cellType)) {
                        logger.info("====================Cell Type:" + cellType);
                        logger.info("====================Cell Value:" + cellCont);
                        // 解析Excel中直接获取的时间格式(windows:yy-M-d)(linux:M/d/yy)
                        DateCell dc = (DateCell) cell;
                        Date date = dc.getDate();
                        logger.info("====================Cell Date:" + date);
                        // 格式化为 yyyy-MM-dd
                        cellCont = new SimpleDateFormat(SystemConstants.DATE_PATTERN).format(date);
                        logger.info("====================After Date:" + cellCont);
                    } else {
                        // 处理单元格时间格式类型:yyyy/MM/dd
                        String ymd = "^(([0-9]{4}|[1-9][0-9]{3})/(((0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)/(0[1-9]|[12][0-9]|30))|(02/(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))/02/29)";
                        Pattern pattern = Pattern.compile(ymd);
                        Matcher matcher = pattern.matcher(cellCont);
                        boolean matchFlag = matcher.matches();
                        if (matchFlag) {
                            logger.info("====================Cell Type:" + cellType);
                            logger.info("====================Cell Value:" + cellCont);
                            try {
                                // 解析Excel中直接获取的时间格式 yy-M-d
                                Date date = new SimpleDateFormat(SystemConstants.DATE_PATTERN_TWO).parse(cellCont);
                                logger.info("====================Cell Date:" + date);
                                // 格式化为 yyyy-MM-dd
                                cellCont = new SimpleDateFormat(SystemConstants.DATE_PATTERN).format(date);
                                logger.info("====================After Date:" + cellCont);
                            } catch (ParseException e) {
                                logger.debug("Date Parse Error!");
                                e.printStackTrace();
                            }
                        }
                    }
                }
                /**********************************END*******************************************/

                if (cell.getType() != CellType.EMPTY) {
                    blankRow = false;
                }
                rowList.add(cellCont);
            }
            if (!blankRow) {
                table.add(rowList);
            }
        }
    }

    public void loadSheet(int sheetNumber) {
        this.loadSheet(currentWorkbook, sheetNumber);
    }

    @SuppressWarnings("rawtypes")
    public void print() {
        if (table.size() == 0)
            return;
        int colCount = ((List) table.get(0)).size();
        for (int i = 0; i < colCount; i++) {
            String colStr = (String) columnsById.get(new Integer(i));
            System.out.print(colStr + "\t");
        }
        System.out.println();

        for (int i = 0; i < table.size(); i++) {
            List row = (List) table.get(i);
            for (int j = 0; j < row.size(); j++) {
                String cellStr = (String) row.get(j);
                System.out.print(cellStr + "\t");
            }
            System.out.println();
        }
    }

    @SuppressWarnings("rawtypes")
    public List Row(int rowIdx) {
        return (List) table.get(rowIdx);
    }

    @SuppressWarnings("rawtypes")
    public String Cell(int rowIdx, int colIdx) {
        return (String) ((List) table.get(rowIdx)).get(colIdx);
    }

    public String Cell(int rowIdx, String colName) {
        int colIdx = (Integer) columnsByName.get(colName);
        return Cell(rowIdx, colIdx);
    }

    public Workbook getCurrentWorkbook() {
        return currentWorkbook;
    }

    public int getRowCount() {
        return table.size();
    }

    public int getColumnCount() {
        return columnsByName.size();
    }

    public int getColumnName(String colName) {
        Integer colIdx = (Integer) columnsByName.get(colName);
        if (colIdx == null)
            return 0;
        else
            return colIdx;
    }
}
