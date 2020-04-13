package lab6client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.ws.rs.core.MediaType;
import lav6client.SimpleObjects.SimpleData;

public class Lab6Client {
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
                    List<SimpleData> buff = service.Select(buffObject);
                    for(int i = 0; i < buff.size(); i++) {
                        res += (i+1) + ". id = " + buff.get(i).getId() + " fild1 = " + buff.get(i).getFild1() + " fild2 = " + buff.get(i).getFild2() + " fild3 = " + buff.get(i).getFild3() + " fild4 = " + buff.get(i).getFild4() + "; \n";
                    }
                    break;
                case "2":
                    buffObject = ReadClass(reader, 0);
                    res = service.Insert(buffObject);
                    break;
                case "3":
                    buffObject = ReadClass(reader, 1);
                    res = service.Update(buffObject);
                    break;
                case "4":
                    System.out.println("Input id:");
                    res = service.Delete(reader.readLine());
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
