package haust.viakiba.mail.business;

import java.util.List;
public class JsonsRootBeanGs {

    private String ebusinessid;
    private boolean success;
    private String logisticcode;
    private List<Shippers> shippers;
    public void setEbusinessid(String ebusinessid) {
         this.ebusinessid = ebusinessid;
     }
     public String getEbusinessid() {
         return ebusinessid;
     }

    public void setSuccess(boolean success) {
         this.success = success;
     }
     public boolean getSuccess() {
         return success;
     }

    public void setLogisticcode(String logisticcode) {
         this.logisticcode = logisticcode;
     }
     public String getLogisticcode() {
         return logisticcode;
     }

    public void setShippers(List<Shippers> shippers) {
         this.shippers = shippers;
     }
     public List<Shippers> getShippers() {
         return shippers;
     }

}
