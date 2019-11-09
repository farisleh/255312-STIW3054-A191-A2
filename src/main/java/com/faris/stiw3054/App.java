package com.faris.stiw3054;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println("| Login id                     | Number of repositories | Number of followers | Number of stars  | Number of following   |");
        System.out.println("|------------------------------|------------------------|---------------------|------------------|-----------------------|");





        ReadToExcel save = new ReadToExcel();
        save.saveData();
        FollowingStat1 acc1 = new FollowingStat1();
        acc1.showAcc1();
        FollowingStat2 acc2 = new FollowingStat2();
        acc2.showAcc2();
        FollowingStat3 acc3 = new FollowingStat3();
        acc3.showAcc3();


        System.out.println(" ");
        System.out.println("Writing data into excel");
        System.out.println("Success");
    }
}
