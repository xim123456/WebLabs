package Services;

import SimpleObject.SimpleData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Metods") 
//@Produces({MediaType.APPLICATION_JSON})
public class SimpleService {
    
    @GET
    @Path("/SelectData") 
    public List<SimpleData> SelectData(@QueryParam("id") String id, @QueryParam("fild1") String fild1, @QueryParam("fild2") String fild2, @QueryParam("fild3") String fild3, @QueryParam("fild4") String fild4) {
        ArrayList<SimpleData> res = new ArrayList<SimpleData>();
        String where = "";
        
        SimpleData findData = new SimpleData(id, fild1, fild2, fild3, fild4);
        
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
        
        return res;
    }
    
    @GET
    @Path("/InsertData") 
    public String InsertData(@QueryParam("id") String id, @QueryParam("fild1") String fild1, @QueryParam("fild2") String fild2, @QueryParam("fild3") String fild3, @QueryParam("fild4") String fild4) {
        int ID = 0;
        String filds = "", values = "";
        
        SimpleData findData = new SimpleData(id, fild1, fild2, fild3, fild4);
        
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
    
    @GET
    @Path("/UpdateData") 
    public String UpdateData(@QueryParam("id") String id, @QueryParam("fild1") String fild1, @QueryParam("fild2") String fild2, @QueryParam("fild3") String fild3, @QueryParam("fild4") String fild4) {
        String values = "";
        
        SimpleData findData = new SimpleData(id, fild1, fild2, fild3, fild4);
        
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
    
    
    @GET
    @Path("/DeleteData") 
    public String DeleteData(@QueryParam("id") String id) {
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weblabs?useSSL=false","xim","ew23ew23");
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM lab1 WHERE id = " + id);
            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex)  {
            return ex.toString();
        }
        return "OK";
    }
}
