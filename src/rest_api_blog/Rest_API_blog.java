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
    public static void getText() throws MalformedURLException, IOException
    {
        URL url = new URL("http://127.0.0.1:8080/blog/article");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println(con.getResponseMessage());
        InputStream input = con.getInputStream();
        int c;
        while((c = input.read())!= -1)
            System.err.print((char)c);
    }
    
    public static void getJSON() throws MalformedURLException, IOException, JSONException
    {
        URL url = new URL("http://127.0.0.1:8080/blog/article.json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println(con.getResponseMessage());
        InputStream input = con.getInputStream();
        int c;
        String data = new String();
        while((c = input.read())!= -1)
            data += (char)c;
        JSONArray json = new JSONArray(data);
        for (int i = 0; i < json.length(); i++)
            System.err.println(json.getJSONObject(i));
    }
    
    public static void formattingJSON() throws MalformedURLException, IOException, JSONException
    {
        URL url = new URL("http://127.0.0.1:8080/blog/article.json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println(con.getResponseMessage());
        InputStream input = con.getInputStream();
        int c;
        String data = new String();
        while((c = input.read())!= -1)
            data += (char)c;
        JSONArray json = new JSONArray(data);
        JSONObject obj;
        for (int i = 0; i < json.length(); i++){
            obj = json.getJSONObject(i);
            System.err.println("Object " + (i+1));
            System.err.println("Title: " + obj.getString("title"));
            System.err.println("Text: " + obj.getString("text"));
            System.err.println("Creation date: " + obj.getString("creation_date"));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
        System.err.println("Text");
        getText();
        System.err.println("JSON");
        getJSON();
        System.err.println("Formatting JSON");
        formattingJSON();
        
    }
    
}
