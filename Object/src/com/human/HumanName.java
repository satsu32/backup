package com.human;

public class HumanName {
	public String sei;
	private String mei;
	public HumanName(){

		//コンストラクタ
		mei="kobayasi";
		sei="satuki";
	}
		public HumanName(String sei, String mei){
			this.sei=sei;
			this.mei=mei;
		}

	public String getname(){
		return sei + mei;
	}

	public String getmei(){
		return mei;
	}
}


