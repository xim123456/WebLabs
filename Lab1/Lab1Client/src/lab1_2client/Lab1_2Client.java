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
        String filds = "";
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
                        fild = "";
                    }
                }
            if (fild != "") {
                filds += "<" + fildName + ">" + fild + "</" + fildName + ">";
            }
        }
        
        
        
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
            + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:SimpleService\">"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                    + "<urn:SimpleRequest>"
                        + "<findData>"
                            + filds
                        + "</findData>"
                    + "</urn:SimpleRequest>"
                + "</soapenv:Body>"
            + "</soapenv:Envelope>";
        
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
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
}