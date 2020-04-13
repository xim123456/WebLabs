package lab5client;


import com.sun.jersey.api.client.Client; 
import com.sun.jersey.api.client.ClientResponse; 
import com.sun.jersey.api.client.GenericType; 
import com.sun.jersey.api.client.WebResource; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.ws.rs.core.MediaType;
import lav5client.SimpleObjects.SimpleData;

public class Lab5Client {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleService service = new SimpleService();
        SimpleData buffObject;
         while(true) {
            String res = "";
            System.out.println("1.Select Data\n2.Insert Data\n3.Update Data\n4.Delete Data\nYou chose: ");
            switch(reader.readLine()){
                case "1":
                    buffObject = ReadClass(reader, 0);
                    try {
                        res = "id";
                        if(buffObject.getId().length() != 0) 
                            Integer.parseInt(buffObject.getId());
                        res = "find3";
                        if(buffObject.getFild3().length() != 0) 
                            Integer.parseInt(buffObject.getFild3());
                        res = "find4";
                        if(buffObject.getFild4().length() != 0) 
                            Integer.parseInt(buffObject.getFild4());
                    } 
                    catch (Exception ex){
                        System.out.println("Error in " + res);
                        res = "";
                        break;
                    }
                    
                    List<SimpleData> buff = service.Select(buffObject);
                    for(int i = 0; i < buff.size(); i++) {
                        res += (i+1) + ". id = " + buff.get(i).getId() + " fild1 = " + buff.get(i).getFild1() + " fild2 = " + buff.get(i).getFild2() + " fild3 = " + buff.get(i).getFild3() + " fild4 = " + buff.get(i).getFild4() + "; \n";
                    }
                    break;
                case "2":
                    buffObject = ReadClass(reader, 0);
                    try {
                        res = "id";
                        if(buffObject.getId().length() != 0) 
                            Integer.parseInt(buffObject.getId());
                        res = "find3";
                        Integer.parseInt(buffObject.getFild3());
                        res = "find4";
                        Integer.parseInt(buffObject.getFild4());
                    } 
                    catch (Exception ex){
                        System.out.println("Error in " + res);
                        res = "";
                        break;
                    }
                    
                    res = service.Insert(buffObject);
                    break;
                case "3":
                    buffObject = ReadClass(reader, 1);
                    try {
                        res = "find3";
                        Integer.parseInt(buffObject.getFild3());
                        res = "find4";
                        Integer.parseInt(buffObject.getFild4());
                    } 
                    catch (Exception ex){
                        System.out.println("Error in " + res);
                        res = "";
                        break;
                    }
                    
                    if(buffObject != null) {
                        res = service.Update(buffObject);
                    }
                    else {
                        System.out.println("Error id. Try again");
                    }
                    break;
                case "4":
                    System.out.println("Input id:");
                    res = service.Delete(Integer.parseInt(reader.readLine()));
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
                    if(prov == 1) {
                        try{
                            Integer.parseInt(buffObject.getId());
                        } 
                        catch (Exception ex) {
                            return null;
                        }
                    }
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
