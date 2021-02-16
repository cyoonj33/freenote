

public class Member {
	int no= 1234;

    String username="세종대왕";

    String tel="010-1002-2322";

    String addr="서울시 마포구 백범로";

    

    

   public Member() { } 

	public Member(int no, String username,String tel, String addr) {

		this.no=no;

		this.username = username;

		this.tel = tel;

		this.addr=addr;

	}

   public void memberPrn() {

   	System.out.printf("%d, %s, %s, %s\n",no,username,tel,addr);

}  //겟터 세터 만들기1  vo,dto라고 함
   //getter setter
   //변수명의 앞에다 겟 붙이고,대문자
   public int getNo() {
	   return no;
   }
    public void setNo(int no) {
    	this.no=no;
    }
   public String getUsername() {
	   return username;
   }
   public void setUsername(String username) {
	   this.username=username;
   }

   
   //2마우스 오른쪽 소스-겟터셋터 누르기
public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}
   
}
