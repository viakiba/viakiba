package haust.viakiba.cheat.infogetentity;

import java.util.List;

public class XinWenRoot {

    private int code;
    private String text;
    private List<XinWen> xinwen;
    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setText(String text) {
         this.text = text;
     }
     public String getText() {
         return text;
     }

    public void setList(List<XinWen> xinwen) {
         this.xinwen = xinwen;
     }
     public List<XinWen> getList() {
         return xinwen;
     }

}
