package com.one.lambdas;

public class FirstLambda {
    public static void main(String[] args) {
        //pre-java 8
        I i = new I(){
            @Override
            public void m(){
                System.out.println("I::m()");
            }
        };
        i.m();

        //Java 8 - Lambda expression (method code)
        I lambdaI = () -> {
            System.out.println("Lambda version (method code)");
        };

        I lambda2 = () ->  System.out.println("Lambda version");

        lambdaI.m();
        lambda2.m();
    }
}

interface I{
    void m();
}