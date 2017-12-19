package com.human;

public class HUMAN {

	public static void main(String[] args) {


		System.out.println("HelloWorld");


        HumanName human=new HumanName();
        System.out.println(human.getname());

        String sei1 =human.sei;
        String mei1 =human.getmei();



        HumanName human2=new HumanName("田中","太郎");
        System.out.println(human2.getname());




	}


}
