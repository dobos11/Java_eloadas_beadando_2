package com.example.java_eloadas_beadando_2;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class RestKliens {
    static HttpsURLConnection connection;
    static String token = "1aaa49374c4d0b812e0ced6e0892bcaa3072d5e5eede2ca139c3d7d350001ecf";
    public static void main(String[] args) throws IOException {
        GET(null);
        // Emailnek egyedinek kell lenni!!!
        POST("Horváth Károly", "male", "email4@data.hu","active");
        String ID="4024";
        GET(ID);
        PUT(ID,"Horváth János2", "male", "email3@data.hu","active");
        GET(ID);
        DELETE(ID);
        GET(ID);
        GET(null);
    }

    static void GET(String ID) throws IOException {  // Get a list of users
        System.out.println("\nGET...");
        String url = "https://gorest.co.in/public/v1/users";
        if(ID!=null)
            url=url+"/"+ID;
        URL usersUrl = new URL(url); // Url for making GET request
        connection = (HttpsURLConnection) usersUrl.openConnection();
        connection.setRequestMethod("GET");  // Set request method
        if(ID!=null)
            connection.setRequestProperty("Authorization", "Bearer " + token);
        segéd3(HttpsURLConnection.HTTP_OK);
        //HttpsURLConnection.HTTP_OK => 200

    }

    static void segéd3(int code) throws IOException {
        int statusCode = connection.getResponseCode();   // Getting response code
        System.out.println("statusCode: "+statusCode);
        if (statusCode == code) {     // If responseCode is code, data fetch successful
            // Kiolvassa a válasz adatait:
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonResponseData = new StringBuffer();
            String readLine = null;
            while ((readLine = in.readLine()) != null)   // Append response line by line
                jsonResponseData.append(readLine);
            in.close();
            System.out.println("List of users: " + jsonResponseData.toString());    // Print result in string format
        } else {
            System.out.println("Hiba!!!");
        }
        connection.disconnect();
    }

    static void POST(String name, String gender, String email, String status) throws IOException {
        System.out.println("\nPOST...");
        URL postUrl = new URL("https://gorest.co.in/public/v1/users");  // Url for making POST request
        connection = (HttpsURLConnection) postUrl.openConnection();
        connection.setRequestMethod("POST");            // Set POST as request method
        segéd1();
        // Adding Body payload for POST request
        String params = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", \"email\":\""+email+"\", \"status\":\""+status+"\"}";
        segéd2(params);
        segéd3(HttpsURLConnection.HTTP_CREATED);

    }


    static void segéd1(){
        // Setting Header Parameters
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setUseCaches(false);
        connection.setDoOutput(true);
    }

    static void segéd2(String params) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        wr.write(params);
        wr.close();
        connection.connect();
    }

    static void PUT(String ID, String name, String gender, String email, String status) throws IOException {
        System.out.println("\nPUT...");
        String url = "https://gorest.co.in/public/v1/users"+"/"+ID;
        URL postUrl = new URL(url);  // Url for making PUT request
        connection = (HttpsURLConnection) postUrl.openConnection();
        connection.setRequestMethod("PUT");            // Set PUT as request method
        segéd1();
        String params = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", \"email\":\""+email+"\", \"status\":\""+status+"\"}";   // Adding Body payload for POST request
        segéd2(params);
        segéd3(HttpsURLConnection.HTTP_OK);
    }

    static void DELETE(String ID) throws IOException {
        System.out.println("\nDELETE...");
        String url = "https://gorest.co.in/public/v1/users"+"/"+ID;
        URL postUrl = new URL(url);  // Url for making PUT request
        connection = (HttpsURLConnection) postUrl.openConnection();
        connection.setRequestMethod("DELETE");            // Set DELETE as request method
        segéd1();
        segéd3(HttpsURLConnection.HTTP_NO_CONTENT);
        //(HttpsURLConnection.HTTP_NO_CONTENT) => 201

    }





}


