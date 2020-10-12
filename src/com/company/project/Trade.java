package com.company.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Trade {
    private String symbol;
    private String date;
    private long timestamp;
    private int quantity;
    private double price;

    public Trade() {
    }

    public Trade(String symbol, String date, long timestamp, int quantity, double price) {
        this.symbol = symbol;
        this.date = date;
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public LocalTime getLocalTime() {
        return LocalTime.ofNanoOfDay(this.timestamp * 1000000);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        //holds all trades
        List<Trade> trades = new ArrayList<>();
        String line = null;

        try {
            FileReader fileReader = new FileReader("Trades.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while ((line = bufferedReader.readLine()) != null) {
                Scanner s = new Scanner(line).useDelimiter(",");

                String symbol = s.next();
                String date = s.next();
                long timestamp = s.nextLong();
                int quantity = s.nextInt();
                double price = s.nextDouble();

                trades.add(new Trade(symbol, date, timestamp, quantity, price));
            }

            //sort by timestamp and quantity


            //trades with quantity greater than 200
            List<Trade> tradesWithQuantityGreaterThan200 = trades.stream().filter(t -> t.getQuantity() > 200).collect(Collectors.toList());
            System.out.println("Trades with Quantity above 200 " + tradesWithQuantityGreaterThan200.size());


            //trades mapping and cost - quantity and price todo: use parallel streams
            Map<String, Double> symbolWithValuesList = trades.stream()
                    .collect(Collectors.toMap(Trade::getSymbol, t -> t.getQuantity() * t.getPrice()));


            bufferedReader.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
