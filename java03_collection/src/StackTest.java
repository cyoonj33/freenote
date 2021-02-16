import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<Integer> stack = new Stack<Integer>();//제너릭있음
		//filo:먼저 추가된 객체가 제일 마지막에 아웃풋된다
        stack.push(100);//오토박싱됨 인티저로 변함
        stack.push(200);
        stack.push(300);
        stack.push(400);
        //마지막넣은 것부터 빠지기 시작함 300뺄려면 400 300 둘다 빠짐
        
        while(!stack.empty()) {
        	System.out.println(stack.pop());
        	System.out.println(stack.size());
        }
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
//셋을 상속받은 이들은 중복 ㄴㄴ