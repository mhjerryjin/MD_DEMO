/**
 *
 */
package com.mingdao.util;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.Boolean;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//import net.ait.criterion.core.entity.IdEntity;
//import net.ait.criterion.core.com.mingdao.util.BeanUtil;
//import net.ait.criterion.core.com.mingdao.util.DateFormatUtil;

/**
 * @author zhenjia(wangzhenjia@ait.net.cn)
 * @Date 2006-4-21 12:41:50
 */
public class ExcelCreateController extends ExcelController {

    /**
     *
     */
    protected WritableSheet ws;

    protected WritableWorkbook wb;

    public ExcelCreateController() {

    }

    /**
     * 创建工作薄
     *
     * @return
     */
    public void createWorkbook() {
        try {
            wb = Workbook.createWorkbook(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建工作表
     *
     * @return
     */
    public void createSheet() {
        if (wb == null) {
            createWorkbook();
        }
        if (sheetName != null) {
            if (sheetIndex == -1) {
                ws = wb.createSheet(sheetName, 0);
            } else if (sheetIndex > -1) {
                ws = wb.createSheet(sheetName, sheetIndex);
            }
        }
    }

    /**
     * 向工作表添加内容
     *
     * @param content
     */
    public void setContent(String content) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Label l = new Label(cellCol, cellRow, content);
            try {
                ws.addCell(l);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按格式向工作表添加内容
     *
     * @param content
     * @param wc
     */
    public void setContent(String content, WritableCellFormat wc) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Label l = new Label(cellCol, cellRow, content, wc);
            try {
                ws.addCell(l);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按格式向工作表添加内容和批注
     *
     * @param content
     * @param wc
     */
    public void setContent(String content, WritableCellFormat wc, String comment) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Label l = new Label(cellCol, cellRow, content, wc);
            WritableCellFeatures cellFeatures = new WritableCellFeatures();
            cellFeatures.setComment(comment);
            l.setCellFeatures(cellFeatures);
            try {
                ws.addCell(l);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 向工作表添加数字
     *
     * @param number
     */
    public void setNumber(int number) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Number n = new Number(cellCol, cellRow, number);
            try {
                ws.addCell(n);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNumber(long number) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Number n = new Number(cellCol, cellRow, number);
            try {
                ws.addCell(n);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNumber(double number) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Number n = new Number(cellCol, cellRow, number);
            try {
                ws.addCell(n);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNumber(double number, WritableCellFormat wc) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Number n = new Number(cellCol, cellRow, number, wc);
            try {
                ws.addCell(n);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNumber(int number, WritableCellFormat wc) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Number n = new Number(cellCol, cellRow, number, wc);
            try {
                ws.addCell(n);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按照格式向工作表添加数字
     *
     * @param number
     * @param format
     */
    public void setNumber(int number, String format) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            NumberFormat nf = new NumberFormat(format);
            WritableCellFormat wcf = new WritableCellFormat(nf);
            Number n = new Number(cellCol, cellRow, number, wcf);
            try {
                ws.addCell(n);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 向工作表添加布尔值
     *
     * @param b
     */
    public void setBolean(boolean b) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Boolean bool = new Boolean(cellCol, cellRow, b);
            try {
                ws.addCell(bool);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 向工作表添加时间
     *
     * @param date
     */
    public void setDateTime(Date date, WritableCellFormat wc) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            DateTime datetime = new DateTime(cellCol, cellRow, date, wc);
            try {
                ws.addCell(datetime);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 向工作表添加时间
     *
     * @param date
     */
    public void setDateTime(Date date) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            DateTime datetime = new DateTime(cellCol, cellRow, date);
            try {
                ws.addCell(datetime);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按照格式向工作表添加时间
     *
     * @param date
     * @param format
     */
    public void setDateTime(Date date, String format) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            DateFormat datef = new DateFormat(format);
            WritableCellFormat wcf = new WritableCellFormat(datef);
            DateTime datetime = new DateTime(cellCol, cellRow, date, wcf);
            try {
                ws.addCell(datetime);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将内容写入Excel
     */
    public void write() {
        if (wb != null) {
            try {
                wb.write();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭Excel创建对象
     */
    public void closeWorkBook() {
        if (wb != null) {
            try {
                wb.close();
            } catch (WriteException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public File getExcelFile() {
        return file;
    }

    @SuppressWarnings("deprecation")
    public void setProtected(boolean b) {
        if (ws != null) {
            ws.setProtected(b);
        }
    }

    public void mergeCells(int col1, int row1, int col2, int row2) {
        if (ws != null) {
            try {
                ws.mergeCells(col1, row1, col2, row2);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFormula(String formula) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Formula f = new Formula(cellCol, cellRow, formula);
            try {
                ws.addCell(f);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFormula(String formula, WritableCellFormat wc) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            Formula f = new Formula(cellCol, cellRow, formula, wc);
            try {
                ws.addCell(f);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setColumnView(int widthSize) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            ws.setColumnView(cellCol, widthSize);
        }
    }

    public void setColumnView(int col, int widthSize) {
        if (ws == null) {
            createSheet();
        }
        ws.setColumnView(col, widthSize);
    }

    public void setRowView(int heightSize) {
        if (ws == null) {
            createSheet();
        }
        if (cellCol != -1 && cellRow != -1) {
            try {
                ws.setRowView(cellRow, heightSize);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            }
        }
    }

    public void addCell(WritableCell cell) {
        if (ws == null) {
            createSheet();
        }
        try {
            ws.addCell(cell);
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

}