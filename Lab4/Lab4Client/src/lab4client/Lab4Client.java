package lab4client;


import com.sun.jersey.api.client.Client; 
import com.sun.jersey.api.client.ClientResponse; 
import com.sun.jersey.api.client.GenericType; 
import com.sun.jersey.api.client.WebResource; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.ws.rs.core.MediaType;
import lav4client.SimpleObjects.SimpleData;

public class Lab4Client {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleService service = new SimpleService();
        SimpleData buffObject;
         while(true) {
            buffObject = ReadClass(reader);
            List<SimpleData> buff = service.Select(buffObject);
            for(int i = 0; i < buff.size(); i++) {
                System.out.println((i+1) + ". id = " + buff.get(i).getId() + " fild1 = " + buff.get(i).getFild1() + " fild2 = " + buff.get(i).getFild2() + " fild3 = " + buff.get(i).getFild3() + " fild4 = " + buff.get(i).getFild4() + ";");
            }
        }
    }
    
    static SimpleData ReadClass(BufferedReader reader) throws IOException {
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
