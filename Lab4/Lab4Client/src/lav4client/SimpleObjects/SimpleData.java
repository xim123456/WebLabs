package lav4client.SimpleObjects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SimpleData {    
    private String id;
    private String fild3;
    private String fild4;
    private String fild1;
    private String fild2;

    public SimpleData() {
        id = fild1 = fild2 = fild3 = fild4 = "";
    }
    
    public SimpleData(String id, String fild1, String fild2, String fild3, String fild4) {
        this.id = id;
        this.fild1 = fild1;
        this.fild2 = fild2;
        this.fild3 = fild3;
        this.fild4 = fild4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFild3() {
        return fild3;
    }

    public void setFild3(String fild3) {
        this.fild3 = fild3;
    }

    public String getFild4() {
        return fild4;
    }

    public void setFild4(String fild4) {
        this.fild4 = fild4;
    }

    public String getFild1() {
        return fild1;
    }

    public void setFild1(String fild1) {
        this.fild1 = fild1;
    }

    public String getFild2() {
        return fild2;
    }

    public void setFild2(String fild2) {
        this.fild2 = fild2;
    }
    
    @Override
    public String toString(){
        return "SimpleData{id=" + id + ",fild1=" + fild1 + ",fild2=" + fild2 + ",fild3=" + fild3 + ",fild4=" + fild4 + "}";
    }
}