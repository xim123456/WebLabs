package Service;

import Errors.BadFormatException;
import Errors.ErrorBean;
import Errors.IdNotFoundException;
import SimpleObject.SimpleData;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(serviceName="SqlServiceWithError")
public class SqlServiceWithError {
    
    @WebMethod(operationName = "SelectData")
    public SimpleData[] SelectData(@WebParam(name = "data") SimpleData findData) throws BadFormatException {
        ArrayList<SimpleData> res = new ArrayList<SimpleData>();
        String where = "";
        
        checkFilds(findData);
        
        if(findData.getId().length() != 0) {
            where = "id = '" + findData.getId() + "'";
            }
        if(findData.getFild1().length() != 0) {
            if(where.length() != 0){
                where += " AND ";
            }
            where += "fild1 = '" + findData.getFild1() + "'";
        }
        if(findData.getFild2().length() != 0) {
            if(where.length() != 0){
                where += " AND ";
            }
            where += "fild2 = '" + findData.getFild2() + "'";
        }
        if(findData.getFild3().length() != 0) {
            if(where.length() != 0){
                where += " AND ";
            }
            where += "fild3 = '" + findData.getFild3() + "'";
        }
        if(findData.getFild4().length() != 0) {
            if(where.length() != 0){
                where += " AND ";
            }
            where += "fild4 = '" + findData.getFild4() + "'";
        }
        if(where.length() != 0){
            where = " WHERE " + where;
        }
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblabs?useSSL=false","xim","ew23ew23");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lab1" + where);
            
            while(rs.next())  {
                res.add(new SimpleData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex)  {
            res.add(new SimpleData("",ex.toString(),"","",""));
        }
        
        SimpleData[] arrRows  = new SimpleData[res.size()];
        for(int i = 0; i < arrRows.length; i++) {
            arrRows[i] = res.get(i);
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SqlServiceWithError.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrRows;
    }
    
    @WebMethod(operationName = "InsertData")
    public String InsertData(@WebParam(name = "data") SimpleData findData) throws BadFormatException{
        int ID = 0;
        String filds = "", values = "";
        
        checkFilds(findData);
        
        if(findData.getFild1().length() != 0) {
            filds =  "fild1";
            values = "'" + findData.getFild1() + "'";
        }
        if(findData.getFild2().length() != 0) {
            filds = (filds.length() == 0)? "fild2" :filds + ",fild2";
            values = (values.length() == 0)?findData.getFild2():values + ",'" + findData.getFild2() + "'";
        }
        if(findData.getFild3().length() != 0) {
            filds = (filds.length() == 0)? "fild3" :filds + ",fild3";
            values = (values.length() == 0)?findData.getFild3():values + "," + findData.getFild3();
        }
        if(findData.getFild4().length() != 0) {
            filds = (filds.length() == 0)? "fild4" :filds + ",fild4";
            values = (values.length() == 0)?findData.getFild4():values + "," + findData.getFild4();
        }
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblabs?useSSL=false","xim","ew23ew23");
            PreparedStatement st = con.prepareStatement("INSERT INTO lab1(" + filds + ") VALUES(" + values + ")", Statement.RETURN_GENERATED_KEYS);
            ID = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(ID == 1 && rs.next())
                ID = rs.getInt(1);
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex)  {
            return ex.toString();
        }
        return String.valueOf(ID);
    }
    
        @WebMethod(operationName = "UpdateData")
    public String UpdateData(@WebParam(name = "data") SimpleData findData) throws BadFormatException, IdNotFoundException{
        String values = "";
        
        checkFilds(findData);
        checkId(findData.getId());
        
        if(findData.getFild1().length() != 0) {
            values = "fild1='" + findData.getFild1() + "'";
        }
        if(findData.getFild2().length() != 0) {
            if(values.length() != 0)
                values = values + ",";
            values = values + "fild2='" + findData.getFild2()+ "'";
        }
        if(findData.getFild3().length() != 0) {
            if(values.length() != 0)
                values = values + ",";
            values = values + "fild3=" + findData.getFild3();
        }
        if(findData.getFild4().length() != 0) {
            if(values.length() != 0)
                values = values + ",";
            values = values + "fild4=" + findData.getFild4();
        }
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblabs?useSSL=false","xim","ew23ew23");
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE lab1 SET " + values + " WHERE id = " + findData.getId());
            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex)  {
            return ex.toString();
        }
        return "OK";
    }
    
    @WebMethod(operationName = "DeleteData")
    public String DeleteData(@WebParam(name = "idData") int idData) throws IdNotFoundException{
        
        checkId(String.valueOf(idData));
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblabs?useSSL=false","xim","ew23ew23");
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM lab1 WHERE id = " + idData);
            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex)  {
            return ex.toString();
        }
        return "OK";
    }
    
    @WebMethod(operationName = "downloadImage")
    public Image downloadImage(String name) {

        try {
            File image = new File("c:\\images\\" + name);
            return ImageIO.read(image);
        } 
        catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }

    @WebMethod(operationName = "uploadImage")
    public String uploadImage(Image data) {

            if(data!=null){
                    BufferedImage bi = (BufferedImage)data;
                    File f = new File("c:\\images\\new.png");
                    try{
                        ImageIO.write(bi, "png", f);
                    }
                    catch (Exception ex ){
                        return "Upload Failed!";
                    }
                    return "Upload Successful";
            }

            return "Upload Failed!";
    }

    private void checkFilds(SimpleData findData) throws BadFormatException {
        String fild = "";
        try {
            fild = "id";
            if(findData.getId().length() != 0)
                Integer.parseInt(findData.getId());
            fild = "fild3";
            if(findData.getFild3().length() != 0)
                Integer.parseInt(findData.getFild3());
            fild = "fild4";
            if(findData.getFild4().length() != 0)
                Integer.parseInt(findData.getFild4());
        }
        catch(Exception ex){
            throw new BadFormatException("Bad format in fild " + fild, ErrorBean.defaultInstance());
        }
    }
    
    private void checkId(String id) throws IdNotFoundException {
        boolean prov = true;
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblabs?useSSL=false","xim","ew23ew23");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lab1 WHERE id = " + id);
            
            while(rs.next())  {
                prov = false;
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex)  {
            prov = true;
        }
        
        if(prov) {
            throw new IdNotFoundException("Id not found", ErrorBean.defaultInstance());
        }
    }
}
