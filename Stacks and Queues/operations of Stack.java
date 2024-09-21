import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
      int top=-1;
      int n=5;
      int[] stack=new int[n];
     top= push(stack,1,top);
       top= push(stack,2,top);
       top=   push(stack,3,top);
     top= pop(stack,top);
      top= pop(stack,top);
      peek(stack,top);
      display (stack,top);
         top=   push(stack,4,top);
     display (stack,top);
        }
public static int push(int[] stack,int x,int top){
    if(top==stack.length-1){
      System.out.println("stack overflow");
      return top;
    }
    top++;
    stack[top]=x;
    System.out.println("element inserted is "+x+" at the "+top);
    return top;
}
public static int pop(int[] stack,int top){
      if(top==-1){
    System.out.println("stack underflow");
    return -1;
      }
 System.out.println("element deleted is "+stack[top]);
  top--;
  return top;
    }
    public static void peek(int[] stack,int top){
        if(top==-1){
    System.out.println("stack underflow");
    return;
      }
      System.out.println("top most element:"+stack[top]);
}
    public static void display(int[] stack,int top){
        System.out.print("elements are: ");
     for(int i=top;i>=0;i--){
         System.out.print(stack[i]+" ");
     }   
    System.out.println();
    }
}