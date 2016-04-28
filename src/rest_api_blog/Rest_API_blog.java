/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest_api_blog;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;


/**
 *
 * @author Alessandro Bugatti <alessandro.bugatti@gmail.com>
 */
public class Rest_API_blog {
    private static HttpURLConnection getConnection(String address) throws MalformedURLException, IOException
    {
        URL url = new URL(address);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        return con;
    }
    
    public static void getText() throws MalformedURLException, IOException
    {
        HttpURLConnection con = getConnection("http://127.0.0.1:8080/blog/articles.html");
        if (con.getResponseCode() == 200)
        {
            InputStream input = con.getInputStream();
            int c;
            while((c = input.read())!= -1)
                System.out.print((char)c);
            System.out.println("");
        }
        else
            System.err.println(con.getResponseMessage());
    }
        
    
    public static void getJSON() throws MalformedURLException, IOException, JSONException
    {
        HttpURLConnection con = getConnection("http://127.0.0.1:8080/blog/articles");
        if (con.getResponseCode() == 200)
        {
            InputStream input = con.getInputStream();
            int c;
            String data = new String();
            while((c = input.read())!= -1)
                data += (char)c;
            JSONArray json = new JSONArray(data);
            for (int i = 0; i < json.length(); i++)
                System.out.println(json.getJSONObject(i));
        }
        else
            System.err.println(con.getResponseMessage());
    }
    
    public static void parsingJSON() throws MalformedURLException, IOException, JSONException
    {
        HttpURLConnection con = getConnection("http://127.0.0.1:8080/blog/articles");
        if (con.getResponseCode() == 200)
        {
            InputStream input = con.getInputStream();
            int c;
            String data = new String();
            while((c = input.read())!= -1)
                data += (char)c;
            JSONArray json = new JSONArray(data);
            JSONObject obj;
            for (int i = 0; i < json.length(); i++){
                obj = json.getJSONObject(i);
                System.out.println("Object " + (i+1));
                System.out.println("Title: " + obj.getString("title"));
                System.out.println("Text: " + obj.getString("text"));
                System.out.println("Creation date: " + obj.getString("creation_date"));
            }
        }
        else
            System.err.println(con.getResponseMessage());
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
        System.out.println("---Retrieve HTML---\n");
        getText();
        System.out.println("\n---Retrieve JSON---\n");
        getJSON();
        System.out.println("\n---Retrieve and parsing JSON---\n");
        parsingJSON();
        
    }
    
}
