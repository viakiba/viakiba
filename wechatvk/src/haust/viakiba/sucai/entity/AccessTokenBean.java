package haust.viakiba.sucai.entity;

public class AccessTokenBean {

    private String accessToken;
    private int expiresIn;
    public void setAccessToken(String accessToken) {
         this.accessToken = accessToken;
     }
     public String getAccessToken() {
         return accessToken;
     }

    public void setExpiresIn(int expiresIn) {
         this.expiresIn = expiresIn;
     }
     public int getExpiresIn() {
         return expiresIn;
     }

}