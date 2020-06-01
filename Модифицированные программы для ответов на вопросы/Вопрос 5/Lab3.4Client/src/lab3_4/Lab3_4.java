
package lab3_4;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import service.BadFormatException;
import service.IdNotFoundException;
import service.SimpleData;
import service.SqlServiceWithError_Service;

public class Lab3_4 {

    public static void main(String[] args) throws MalformedURLException, IOException, BadFormatException, IdNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SqlServiceWithError_Service prob = new SqlServiceWithError_Service(new URL("http://desktop-vimllah:8080/Lab3/SqlServiceWithError?wsdl"));
        SimpleData buffObject;
         while(true) {
            String res = "";
            System.out.println("1.Select Data\n2.Insert Data\n3.Update Data\n4.Delete Data\n5.Load Image\n6.Upload Image\nYou chose: ");
            switch(reader.readLine()){
                case "1":
                    buffObject = ReadClass(reader, 0);
                    List<SimpleData> buff = prob.getSqlServiceWithErrorPort().selectData(buffObject);
                    for(int i = 0; i < buff.size(); i++) {
                        res += (i+1) + ". id = " + buff.get(i).getId() + " fild1 = " + buff.get(i).getFild1() + " fild2 = " + buff.get(i).getFild2() + " fild3 = " + buff.get(i).getFild3() + " fild4 = " + buff.get(i).getFild4() + "; \n";
                    }
                    break;
                case "2":
                    buffObject = ReadClass(reader, 0);
                    res = prob.getSqlServiceWithErrorPort().insertData(buffObject);
                    break;
                case "3":
                    buffObject = ReadClass(reader, 1);
                    if(buffObject.getId().length() != 0) {
                        res = prob.getSqlServiceWithErrorPort().updateData(buffObject);
                    }
                    break;
                case "4":
                    System.out.println("Input id:");
                    res = prob.getSqlServiceWithErrorPort().deleteData(Integer.parseInt(reader.readLine()));
                    break;
                case "5":
                    System.out.println("Input image name from server:");
                    String name = reader.readLine();
                    byte[] prob2 = prob.getSqlServiceWithErrorPort().downloadImage(name);
                    ByteArrayInputStream bis = new ByteArrayInputStream(prob2);
                    BufferedImage bImage2 = ImageIO.read(bis);
                    ImageIO.write(bImage2, "png", new File("c:\\imagesClient\\" + name) );
                    res = "Ok";
                    break;
                case "6":
                    System.out.println("Input image name from client:");
                    String name2 = reader.readLine();
                    BufferedImage bImage = ImageIO.read(new File("c:\\imagesClient\\" +name2));
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ImageIO.write(bImage, "png", bos );
                    res = prob.getSqlServiceWithErrorPort().uploadImage(bos.toByteArray());
                    break;
            }
            if(res.length() != 0) {
                System.out.println(res);
            }
            else {
                System.out.println("Incorect command. Try again");
            }
        }
    }
    
    static SimpleData ReadClass(BufferedReader reader, int prov) throws IOException {
        SimpleData buffObject = new SimpleData();

        for (int i = 0; i < 5;i++) {
            switch(i){
                case 0:
                    System.out.println("Input id:");
                    buffObject.setId(reader.readLine());
                    break;
                case 1:
                    System.out.println("Input fild1:");
                    buffObject.setFild1(reader.readLine());
                    break;
                case 2:
                    System.out.println("Input fild2:");
                    buffObject.setFild2(reader.readLine());
                    break;
                case 3:
                    System.out.println("Input fild3:");
                    buffObject.setFild3(reader.readLine());
                    break;
                case 4:
                    System.out.println("Input fild4:");
                    buffObject.setFild4(reader.readLine());
                    break;
            }
       }
        return buffObject;
    }
}
