package com.my.myutils.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

public class AgoraConsoleAdminInsert {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/qyz/files/Console.xlsx"; // Excel文件名

        FileInputStream file = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0); // 获取第一个工作表
        int rowNum = 65;

        String type = null;
        String cnType = null;
        for (int i = 2; i < rowNum; i++) { // 从第二行开始遍历
            Row row = sheet.getRow(i);
            Cell cellA = row.getCell(0); // 获取A列单元格 英文type
            Cell cellB = row.getCell(1); // 获取B列单元格 英文name
            Cell cellH = row.getCell(7); // 获取H列单元格 中文type
            Cell cellI = row.getCell(8); // 获取I列单元格 中文name


            if (StringUtils.isNotBlank(cellA.getStringCellValue())) {
                type = cellA.getStringCellValue();// 获取A列数据
            }
            String name = cellB.getStringCellValue(); // 获取B列数据
            if (StringUtils.isNotBlank(cellH.getStringCellValue())) {
                cnType = cellH.getStringCellValue(); // 获取H列数据
            }
            String cnName = cellI.getStringCellValue(); // 获取I列数据
            System.err.println("update function_list set cnName = '"+ cnName +"',cnType = '" + cnType + "' where name = '" + name + "' and type = '" + type + "';");
        }
        System.err.println("=============================");
        System.err.println("=============================");
        System.err.println("=============================");

        HashSet<String> set = new HashSet<>();
        for (int i = 2; i <rowNum; i++) {
            Row row = sheet.getRow(i);
            Cell free = row.getCell(2);
            Cell starter = row.getCell(3);
            Cell pro = row.getCell(4);
            Cell enterptise = row.getCell(5);

            Cell freeCn = row.getCell(9);
            Cell starterCn = row.getCell(10);
            Cell proCn = row.getCell(11);
            Cell enterptiseCn = row.getCell(12);

            String s1 = "update function_list set cnValue = '"+ freeCn +"' where value = '" + free + "';";
            String s2 = "update function_list set cnValue = '"+ starterCn +"' where value = '" + starter + "';";
            String s3 = "update function_list set cnValue = '"+ proCn +"' where value = '" + pro + "';";
            String s4 = "update function_list set cnValue = '"+ enterptiseCn +"' where value = '" + enterptise + "';";
            set.add(s1);
            set.add(s2);
            set.add(s3);
            set.add(s4);
        }
        for (String s : set) {
            System.err.println(s);
        }

        System.err.println("=============================");
        System.err.println("=============================");
        System.err.println("=============================");

        System.err.println("update function_list set cnPlanName = '免费版' where plan_name = 'Free';");
        System.err.println("update function_list set cnPlanName = '基础版' where plan_name = 'Starter';");
        System.err.println("update function_list set cnPlanName = '进阶版' where plan_name = 'Pro';");
        System.err.println("update function_list set cnPlanName = '企业版' where plan_name = 'Enterprise';");


        workbook.close();

    }
}
