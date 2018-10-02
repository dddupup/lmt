package Utils;

import Pojo.Poi;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;



/**
 * Created by shaohao on 2018/10/1.
 */
public class CreateExcel {
    private int id=0;
    public static String path="";


    public void createExcel(Poi poi) throws IOException {
        System.out.println(poi.getDevice());
        System.out.println(poi.getCustom());
        System.out.println(poi.getIpc());



        String[] Row0={"设备类型",poi.getDevice(),"语言类型(中文:2,其它:1)","2"};
        String[] Row1={"IP通道号","流ID","IP通道地址","协议","管理端口","设备通道号","用户名","管理员密码","传输协议","路径","域编码","传输模式","流类型"};
        ArrayList<String> Rown=new ArrayList<>();
        String[] strings={"",poi.getIpc(),poi.getCustom(),"554","1","admin","Abc12345","自动","","","0","0"};
        for (int i=0;i<strings.length;i++){
            Rown.add(strings[i]);
        }
        //创建工作簿
        HSSFWorkbook workbook=new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet=workbook.createSheet();
        //创建表头
        HSSFRow row0=sheet.createRow(0);
        HSSFRow row1=sheet.createRow(1);
        //创建第一行单元格并写入数据
        HSSFCell cell=null;
        HSSFCell cell1=null;

        //写入头部数据
        for (int i=0;i<Row0.length;i++){
            cell=row0.createCell(i);
            cell.setCellValue(Row0[i]);
        }
        for (int i=0;i<Row1.length;i++){
            cell1=row1.createCell(i);
//            System.out.println("1111111111111");
            cell1.setCellValue(Row1[i]);

        }

        //写入数据
        for (int i=2;i<poi.getNum()+2;i++){
            HSSFRow nrow=sheet.createRow(i);
            id=i-1;
            Rown.add(0, String.valueOf(id));
            for(int j=0;j<13;j++){
                System.out.println(id);
                HSSFCell ncell=nrow.createCell(j);
                ncell.setCellValue(Rown.get(j));
            }
            Rown.remove(0);
        }
        File temp=File.createTempFile("poi",".xlsx");
        String absolutePath=temp.getAbsolutePath();//获取绝对路径
        System.out.println(absolutePath);
        FileOutputStream outputStream = new FileOutputStream(absolutePath);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        path=absolutePath;
    }
    public void deleteFile(){
        File temp=new File(path);
        temp.delete();
        System.out.println("file has been deleted!!!!");
    }


}

