package com.food.test;

import com.razorpay.RazorpayClient;

public class TestRazorpay {
	public static void main(String[] args) {

        try {

            RazorpayClient client =new RazorpayClient("rzp_test_TEGSzLIlJklQwS", "9EwYyF46rKWQjQm36VS2yh2x");

            System.out.println("Razorpay SDK Loaded Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
