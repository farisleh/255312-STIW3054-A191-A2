package com.faris.stiw3054;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.*;

public class FollowingStat1{

    public List<Data> showAcc1() {

        String url = "https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxOS0wMi0yMFQxMTo1NDozNSswODowMM4Cfdf-&tab=followers";
        String url2 = "https://github.com/";


        try {

            Document document = Jsoup.connect(url).get();
            Elements name = document.getElementsByClass("link-gray pl-1");

            final List<Data> statistic = new ArrayList<Data>();

            for (final Element nameFollower : name) {
                String follower = nameFollower.getElementsByClass("link-gray pl-1").text();
                String list1 = url2 + follower;
                Document doc = Jsoup.connect(list1).get();
                final Element repo = doc.getElementsByClass("Counter hide-lg hide-md hide-sm").get(0);
                final Element followers = doc.getElementsByClass("Counter hide-lg hide-md hide-sm").get(3);
                final Element stars = doc.getElementsByClass("Counter hide-lg hide-md hide-sm").get(2);
                final Element following = doc.getElementsByClass("Counter hide-lg hide-md hide-sm").get(4);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        System.out.printf("| %-29s| %-23s| %-20s| %-17s| %-22s|\n", nameFollower.text(), repo.text(), followers.text(), stars.text(), following.text());
                        statistic.add(new Data(nameFollower.text(), repo.text(), followers.text(), stars.text(), following.text()));
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return statistic;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}