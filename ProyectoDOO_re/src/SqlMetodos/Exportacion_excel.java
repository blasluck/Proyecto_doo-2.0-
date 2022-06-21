/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlMetodos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Daniel
 */
public class Exportacion_excel {

    Workbook wb ;
    
    public void reporte_Historial(JTable tabla){   
        System.out.println("LLeuge al reporte");
        Workbook book = new XSSFWorkbook();
        
        
        Sheet sheet = book.createSheet("Historial");
        
        
        try{
            /*Ingreso del logo de la empresa*/
            InputStream is = new FileInputStream("src/images/logo_mechanic.jpg"); 
            
            byte[] bytes = IOUtils.toByteArray(is); //CAPTURA DE IMG
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();
            
            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();//Para dibujar la img
            
            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);// ubicacion de columna de la imagen
            anchor.setRow1(1);//Ubicacion de filas de la img
            /*Le pasamos el parametro para crear la img en el excel*/
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(2,3);//Le damos el tamno en el que aparecera 
            
             /**TITULO*/
            CellStyle titulo_estilo = book.createCellStyle();
            titulo_estilo.setAlignment(HorizontalAlignment.CENTER); // Alineamiento del titulo
            titulo_estilo.setVerticalAlignment(VerticalAlignment.CENTER);//centrado
            Font fuenteTitulo= book.createFont(); //Creacion de la fuente del titulo
            fuenteTitulo.setFontName("Arial");//Nombre del estilo de letra
            fuenteTitulo.setBold(true);//negrita
            fuenteTitulo.setFontHeightInPoints((short) 14);//tamano de letra
            titulo_estilo.setFont(fuenteTitulo);
            Row filaTitulo = sheet.createRow(2);
            Cell celda_title = filaTitulo.createCell(4);
            celda_title.setCellStyle(titulo_estilo);
            celda_title.setCellValue("Reporte de Historial de productos");
                     
            
            /*CABEZERA DE LA TABLA */            
            String[] cabecera=  new String[]{"Codigo","Producto","Entradas","Salidas","Stock"};
            //Diseno de la cabezera
            CellStyle heardStyle = book.createCellStyle();
                heardStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                heardStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                heardStyle.setBorderBottom(BorderStyle.THIN);
                heardStyle.setBorderLeft(BorderStyle.THIN);
                heardStyle.setBorderRight(BorderStyle.THIN);
                heardStyle.setBorderBottom(BorderStyle.THIN);
                
            //Diseno de la fuente   
            Font font = book.createFont();
                font.setFontName("Arial");
                font.setBold(true);
                font.setColor(IndexedColors.WHITE.getIndex());
                font.setFontHeightInPoints((short) 12);
                heardStyle.setFont(font);
                
                
                
            Row fila_encabezados = sheet.createRow(5);
                
                for(int i=0; i< cabecera.length; i++){
                    Cell celdaEncab = fila_encabezados.createCell(i+2);
                    celdaEncab.setCellStyle(heardStyle);
                    celdaEncab.setCellValue(cabecera[i]);
                }
                
                
            
            /*LLENADO de datos desde mysql*/    
            
            //Diseno de los datos
            CellStyle datos_estilo = book.createCellStyle();
            datos_estilo.setBorderBottom(BorderStyle.THIN);
            datos_estilo.setBorderLeft(BorderStyle.THIN);
            datos_estilo.setBorderRight(BorderStyle.THIN);
            datos_estilo.setBorderBottom(BorderStyle.THIN);
            

            try {
                int num_fila = tabla.getRowCount();
                int numCol = tabla.getColumnCount();//Numero de columnas de la database
                int n=6;
                
                for(int i= n ; i<num_fila+6; i++){
                        Row filaDat = sheet.createRow(i);//continuara la fila seguida de la cabezera
                        for(int j=0; j<numCol; j++){
                            Cell celdaDates = filaDat.createCell(j+2);
                            celdaDates.setCellStyle(datos_estilo);
                            celdaDates.setCellValue(tabla.getValueAt(i-6, j).toString());// se pone +1 por que el indice empieza del 1 
                        }
                }   
            } catch (Exception e) {
               System.out.println("Error al imprimir sql:"+ e);
            }
                //para ajustar las columnas de acuerdo a su contenido
                    sheet.autoSizeColumn(2); 
                    sheet.autoSizeColumn(3);
                    sheet.autoSizeColumn(4);
              
                sheet.setZoom(140);//para acerca apenas abra
                
            /*Creacion del archivo ya escrito*/
            
            FileOutputStream fileout = new FileOutputStream("Historial.xlsx");
            book.write(fileout);
            fileout.close();
            System.out.println("ACABE");
            
        }catch(FileNotFoundException f){
                System.out.println("Error al capturar img" + f.getMessage());
        }catch(IOException e){
            System.out.println("Error al almacenar img: " +  e.getMessage());
        }
    }
    
    
    
}
