package com.boot.analysis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class ExcelAnalysis {

	public static void main(String[] args) {
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		List<Map<String, String>> list = null;
		String cellData = null;
		String filePath = "D:\\qv导入\\new_qq\\熊Z_战争史研究WHS_QQ.xls";
		String columns[] = { "账号", "对方账号", "状态" ,"首次采集时间" , "最近采集时间" };
		wb = readExcel(filePath);
		if (wb != null) {
			// 用来存放表中数据
			list = new ArrayList<Map<String, String>>();
			// 获取第一个sheet
			sheet = wb.getSheetAt(0);
			// 获取最大行数
			int rownum = sheet.getPhysicalNumberOfRows();
			// 获取第一行
			row = sheet.getRow(0);
			
			for(int rowNum = 0; rowNum<=sheet.getLastRowNum();rowNum++){
				//获取每一行
			    Row row1 = (Row) sheet.getRow(rowNum);
			    if(row1 == null){
			      continue;
			    }
			  //遍历列cell
			    for(int cellNum = 0; cellNum<=row.getLastCellNum();cellNum++){
			      //获取每一列
			      Cell cell = (Cell) row.getCell(cellNum);
			      ja.add(cell);
			      if(cell == null){
			        continue;
			      }
			    }
			}
			// 获取最大列数
			int colnum = row.getPhysicalNumberOfCells();
			for (int i = 1; i < rownum; i++) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				row = sheet.getRow(i);
				if (row != null) {
					for (int j = 0; j < colnum; j++) {
						cellData = (String) getCellFormatValue(row.getCell(j));
						map.put(columns[j], cellData);
					}
				} else {
					break;
				}
				list.add(map);
			}
		}
		// 遍历解析出来的list
		String regx = "^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$";
		List<Map<String, Object>> joResult = new ArrayList<Map<String, Object>>();
		for (Map<String, String> map : list) {
			Map<String, Object> joMap = new HashMap<String, Object>();
			for (Entry<String, String> entry : map.entrySet()) {
				 String value = entry.getValue();
				 //如果value是科学计数的话，就将此转换为字符串,如果不是就显示正常的value值即可
				 Pattern pattern = Pattern.compile(regx);
				 boolean matches = pattern.matcher(value).matches();
				 if(matches){
					 BigDecimal StrVlaue = new BigDecimal(value);
					 joMap.put(entry.getKey(), StrVlaue.toPlainString());
				 }else {
					 joMap.put(entry.getKey(), value);
				}
			}
			joResult.add(joMap);
		}
		jo.put("fields", columns);
		jo.put("records", joResult);
		System.out.println(jo);
	}

	/**
     * 读取Excel表格表头的内容
     * @param InputStream
     * @return String 表头内容的数组
     */
	private POIFSFileSystem fs;
    private Workbook wb;
    private Sheet sheet;
    private Row row;
    public String[] readExcelTitle(InputStream is) {
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = (String) getCellFormatValue(row.getCell((short) i));
        }
        return title;
    }
	
	// 读取excel
	public static Workbook readExcel(String filePath) {
		Workbook wb = null;
		if (filePath == null) {
			return null;
		}
		String extString = filePath.substring(filePath.lastIndexOf("."));
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
			if (".xls".equals(extString)) {
				return wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(extString)) {
				return wb = new XSSFWorkbook(is);
			} else {
				return wb = null;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}

	public static Object getCellFormatValue(Cell cell) {
		Object cellValue = null;
		if (cell != null) {
			// 判断cell类型
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC: {
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			}
			case Cell.CELL_TYPE_FORMULA: {
				// 判断cell是否为日期格式
				if (DateUtil.isCellDateFormatted(cell)) {
					// 转换为日期格式YYYY-mm-dd
					cellValue = cell.getDateCellValue();
				} else {
					// 数字
					cellValue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING: {
				cellValue = cell.getRichStringCellValue().getString();
				break;
			}
			default:
				cellValue = "";
			}
		} else {
			cellValue = "";
		}
		return cellValue;
	}
}
