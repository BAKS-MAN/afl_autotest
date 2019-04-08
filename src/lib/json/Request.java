package lib.json;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class Request {

    protected static final String
       BOOKING_URL = "https://afl-test.test.aeroflot.ru/sb/booking/api/app/book/v4";





    public static String getPNR() {

        Response response;
        String responseJson;
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "");
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(BOOKING_URL)
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try {
            response = client.newCall(request).execute();
            responseJson = response.body().string();
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return responseJson;
    }

    public static Response post(){
        OkHttpClient httpClient = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,"");

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(BOOKING_URL)
                .post(body)
                .addHeader("Content-Type","application/json")
                .build();
        Response response;
        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        if (!response.isSuccessful())
            throw new IllegalArgumentException("Failed : HTTP code : "+ String.valueOf(response.code()));
        return response;
        }
}
