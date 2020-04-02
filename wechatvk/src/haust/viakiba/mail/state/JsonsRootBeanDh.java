package haust.viakiba.mail.state;

import java.util.List;
public class JsonsRootBeanDh {

    private String ebusinessid;
    private String shippercode;
    private boolean success;
    private String logisticcode;
    private String state;
    private List<Traces> traces;
    public void setEbusinessid(String ebusinessid) {
         this.ebusinessid = ebusinessid;
     }
     public String getEbusinessid() {
         return ebusinessid;
     }

    public void setShippercode(String shippercode) {
         this.shippercode = shippercode;
     }
     public String getShippercode() {
         return shippercode;
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

    public void setState(String state) {
         this.state = state;
     }
     public String getState() {
         return state;
     }

    public void setTraces(List<Traces> traces) {
         this.traces = traces;
     }
     public List<Traces> getTraces() {
         return traces;
     }

}