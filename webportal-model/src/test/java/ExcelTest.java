import com.softel.model.utils.TimeVo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class ExcelTest {
    public static void main(String[] args) throws Exception {
        // 创建Excel的工作书册 Workbook,对应到一个excel文档
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet();

        XSSFRow row = sheet.createRow(0);

        TimeVo timeVo = new TimeVo();
        System.out.println(timeVo.getYear());
        System.out.println(timeVo.getMonth());
        System.out.println(timeVo.getDay());
        System.out.println(timeVo.getHour());
        System.out.println(timeVo.getMinute());
        System.out.println(timeVo.getSecond());
        System.out.println(timeVo.getMillsecond());

        CellStyle style = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        //style.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd hh:mm:ss"));
        style.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        Cell cell = row.createCell(0);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(timeVo.getDate());
        cell.setCellStyle(style);
        String begin = "date(2017,09,14)";
        String end = "date(2017,12,31)";

        DataValidationHelper helper = sheet.getDataValidationHelper();
        XSSFDataValidationConstraint constraint = (XSSFDataValidationConstraint) helper.createDateConstraint(
                XSSFDataValidationConstraint.OperatorType.BETWEEN, begin, end, "yyyy-MM-dd HH:mm:ss");
        CellRangeAddressList regions = new CellRangeAddressList(0, 2, 0, 2);

        DataValidation dataValidate = helper.createValidation(constraint, regions);

        dataValidate.createErrorBox("错误", "格式错误");
        dataValidate.setShowErrorBox(true);
        dataValidate.createPromptBox("提示", "日期格式为2017-10-12 12:30:30");
        dataValidate.setShowPromptBox(true);
        dataValidate.setSuppressDropDownArrow(true);
        sheet.addValidationData(dataValidate);


        FileOutputStream os = new FileOutputStream("D:\\workbook.xlsx");
        workbook.write(os);
        os.close();
    }
}
