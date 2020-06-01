package lab3client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import service.BadFormatException_Exception;
import service.IdNotFoundException_Exception;
import service.SimpleData;
import service.SqlServiceWithError_Service;

public class Lab3Client {
    public static void main(String[] args) throws MalformedURLException, IOException, BadFormatException_Exception, IdNotFoundException_Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SqlServiceWithError_Service prob = null;
        synchronized(prob) {
            prob = new SqlServiceWithError_Service(new URL("http://desktop-vimllah:8080/Lab3/SqlServiceWithError?wsdl"));
        }
        SimpleData buffObject;

        while(true) {
            String res = "";
            System.out.println("1.Select Data\n2.Insert Data\n3.Update Data\n4.Delete Data\nYou chose: ");
            switch(reader.readLine()){
                case "1":
                    buffObject = ReadClass(reader, 0);
                    List<SimpleData> buff = null;
                    synchronized(prob) {
                        buff = prob.getSqlServiceWithErrorPort().selectData(buffObject);
                    }
                    for(int i = 0; i < buff.size(); i++) {
                        res += (i+1) + ". id = " + buff.get(i).getId() + " fild1 = " + buff.get(i).getFild1() + " fild2 = " + buff.get(i).getFild2() + " fild3 = " + buff.get(i).getFild3() + " fild4 = " + buff.get(i).getFild4() + "; \n";
                    }
                    break;
                case "2":
                    buffObject = ReadClass(reader, 0);
                    synchronized(prob) {
                        res = prob.getSqlServiceWithErrorPort().insertData(buffObject);
                    }
                    break;
                case "3":
                    buffObject = ReadClass(reader, 1);
                    if(buffObject.getId().length() != 0) {
                        synchronized(prob) {
                            res = prob.getSqlServiceWithErrorPort().updateData(buffObject);
                        }
                    }
                    break;
                case "4":
                    System.out.println("Input id:");
                    synchronized(prob) {
                        res = prob.getSqlServiceWithErrorPort().deleteData(Integer.parseInt(reader.readLine()));
                    }
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
