package com.deepan;

import okhttp3.HttpUrl;
import okhttp3.Request;

import java.util.Scanner;

public class CurrencyConverterApp {

    public static void main(String[] args) {
        System.out.println("Currency Conversion using Exchange Rate API");
        System.out.println("================================================");

        Scanner scanner = new Scanner(System.in);
        String from = scanner.next();
        String to = scanner.next();
        String amount = scanner.next();

        // Create a base URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.apilayer.com/exchangerates_data/convert").newBuilder();

        // Add query parameters
        urlBuilder.addQueryParameter("from", from);
        urlBuilder.addQueryParameter("to", to);
        urlBuilder.addQueryParameter("amount", amount);

        // Build the URL
        HttpUrl url = urlBuilder.build();

        System.out.println(url);

        Request request = new Request.Builder()
                .url(url)
                .addHeader("apiKey","")
                .method("GET",null)
                .build();

//        get the conversion amount using the exchange rate api with the above inputs
//        https://api.apilayer.com/exchangerates_data/convert?to=INR&from=SGD&amount=100

        System.out.println(from);
        System.out.println(to);
        System.out.println(amount);

    }
}
