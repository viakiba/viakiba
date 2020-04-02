package haust.viakiba.sucai.test;



import haust.viakiba.sucai.AccessToken;

public class TestUtil {
	public static void main(String[] args) throws Exception {
		String accessToken = AccessToken.getAccessToken();
		System.out.println(accessToken);
	}
}
