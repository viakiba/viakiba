package a_jdbc;

import java.io.InputStream;
import java.util.Scanner;

public class Test{
	  public static void main(String args[]) throws Exception{
	    int n=2;
	    n=System.in.read();
	    fun(n);
	  }


	private static void fun(int n) {
		// TODO Auto-generated method stub
		int p=n,q=n,k=0;
		int g=0,h=0;
		int a[][]=new int[n][n];
		for(int i=0;i<p;i++){
			p=i;
			for(int j=0;j<q;j++){
				a[i][j]=k;
				k++;				
			}
			p=p-1;
		}
	}
	}
