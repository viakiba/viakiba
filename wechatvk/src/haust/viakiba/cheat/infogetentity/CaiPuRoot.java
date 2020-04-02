package haust.viakiba.cheat.infogetentity;

import java.util.List;

public class CaiPuRoot {

    private int code;
    private String text;
    private List<CaiPu> caipu;
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

    public void setList(List<CaiPu> caipu) {
         this.caipu = caipu;
     }
     public List<CaiPu> getList() {
         return caipu;
     }

}
