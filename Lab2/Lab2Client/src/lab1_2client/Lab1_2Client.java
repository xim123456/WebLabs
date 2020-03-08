package lab1_2client;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Lab1_2Client {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8080/SimpleService/SimpleService";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filds = "", metod = "", variv = "";
        
        while(true) {
            System.out.println("1.Select Data\n2.Insert Data\n3.Update Data\n4.Delete Data\nYou chose: ");
            switch(reader.readLine()){
                case "1":
                    filds = ReadClass(0);
                    metod = "SelectData";
                    break;
                case "2":
                    filds = ReadClass(0);
                    metod = "InsertData";
                    break;
                case "3":
                    filds = ReadClass(1);
                    metod = "UpdateData";
                    if(filds.length() == 0){
                        System.out.println("Incorect id. Try again");
                    }
                    break;
                case "4":
                    metod = "DeleteData";
                    System.out.println("Input id:");
                    String fild = reader.readLine();
                    try{
                        Integer.parseInt(fild);
                    }
                    catch (Exception ex){
                        fild = "";
                    }
                    if(fild.length() == 0){
                        System.out.println("Incorect id. Try again");
                    }
                    else {
                        filds = "<idData>" + fild + "</idData>";
                    }
                    break;
            }
        
            if(filds.length() != 0)
                break;
        }
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes("<?xml version=\"1.0\" encoding=\"utf-8\"?>"
            + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:SimpleService\">"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                    + "<urn:" + metod + ">"
                        + filds
                    + "</urn:" + metod + ">"
                + "</soapenv:Body>"
            + "</soapenv:Envelope>");
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            System.out.println(responseStatus);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("response:\n" + response.toString().replaceAll("><", ">\n<"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    static String ReadClass(int prov) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filds = "<data>";
        for (int i = 0; i < 5;i++) {
            String fildName = "";
            switch(i){
                case 0:
                    fildName = "id";
                    break;
                case 1:
                    fildName = "fild1";
                    break;
                case 2:
                    fildName = "fild2";
                    break;
                case 3:
                    fildName = "fild3";
                    break;
                case 4:
                    fildName = "fild4";
                    break;
            }
            System.out.println("Input " + fildName + ":");
            String fild = reader.readLine();
                if(i == 0 || i == 3 || i == 4){
                    try{
                        Integer.parseInt(fild);
                    }
                    catch (Exception ex){
                        if(prov == 1 && i == 0)
                            return "";
                        fild = "";
                    }
                }
            if (fild != "") {
                filds += "<" + fildName + ">" + fild + "</" + fildName + ">";
            }
       }
        return filds + "</data>";
    }
}