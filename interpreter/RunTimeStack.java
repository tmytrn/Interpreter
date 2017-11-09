package interpreter;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {
    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;


    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    /******************************
    methods for runTimeStack
     ******************************/

    public void dump(){
        if(!runTimeStack.isEmpty()) {
            //make a new list to get values from framPointer
            ArrayList<Integer> framOrg = new ArrayList<>();
            for (int i = 0; i < framePointer.size(); i++) {
                int frame = framePointer.get(i);
                if (frame > 0)
                    framOrg.add(frame);

            }
            System.out.print("[");
            int ind =0;
            boolean addComma = true;
            for(int i=0; i < runTimeStack.size(); i++){
                if(!framOrg.isEmpty() && ind < framOrg.size()){
                     if(framOrg.get(ind) == i){
                        System.out.print("] [");

                     }
                }
                if(!framOrg.isEmpty() && ind < framOrg.size()){
                    if(framOrg.get(ind) == i+1 ){
                        addComma = false;
                    }
                }

                System.out.print(runTimeStack.get(i));
                if ((runTimeStack.size() != 1) && ((runTimeStack.size() - 1) != i) && addComma){
                    System.out.print(",");
                }

                if(!addComma){
                    addComma = true;
                }

                //prints the comma and resets value
            }
            System.out.println("]");


        }
    }
    public int peek(){
        return  runTimeStack.get(runTimeStack.size()-1);
    }

    public int pop(){
        return runTimeStack.remove(runTimeStack.size()-1);
    }

    public int push(int i){
        runTimeStack.add(i);
        return i;
    }
    public int size(){
        return runTimeStack.size();
    }

    /************************
    methods for framePointer
     **********************/


    public Integer push(Integer e){
        runTimeStack.add(e);
        return e;
    }

    public void newFrameAt(int offset) {
        //if (offset > 0) {
            int newFrame = runTimeStack.size() - offset;
            framePointer.push(newFrame);
        //}
    }
    // do later
    public int store(int offset){
        int val = runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(offset+ framePointer.peek(), val);
        return val;}
    //do later
    public int load(int offset){
        int data = runTimeStack.get(offset + framePointer.peek());
        runTimeStack.add(data);
        return data;}
    //do later
    public void popFrame(){
        framePointer.pop();
    }
    public void reset(){
        //pop the top of runtimestack
        int data = runTimeStack.remove(runTimeStack.size()-1);
        while(runTimeStack.size() > framePointer.peek()) {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        framePointer.pop();
        runTimeStack.add(data);

    }






    
}
