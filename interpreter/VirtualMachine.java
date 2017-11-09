package interpreter;
import interpreter.ByteCode.ByteCode;

import java.util.Stack;


public class VirtualMachine {

    private RunTimeStack runStack;
    private int pc;
    private Stack<Integer> returnAddrs;
    private boolean isRunning;
    private Program program;
    private boolean isDumping = false;


    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        pc =0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            // check if dumping is on
            if(isDumping){
                System.out.println(code);
                runStack.dump();
            }
            System.out.println("PC is at :" + pc);
            //System.out.println(code.toString());
            //runStack.dump();
            //System.out.println((pc+1) + ": " + code.toString() + ", peek: " + runStack.peek());
            pc++;
        }
    }
    public int popRunStack(){return runStack.pop();}
    public void dumpMode(boolean bool){
        isDumping = bool;
    }
    public void newFrame(int frame) {
        runStack.newFrameAt(frame);
    }
    public void popNFromStack(int n){
        if(n < runStack.size()){
            while(n>=0){
                runStack.pop();
                n--;
            }
        }
    }
    public void savePC(){returnAddrs.push(pc);}
    public int getPrevPC(){return returnAddrs.pop();}
    public int peekRunStack(){return runStack.peek();}
    public void endProgram(){isRunning = false;}
    public void changePC(int n){pc =n;}
    public void pushRunStack(int n){runStack.push(n);}
    public void store(int n){runStack.store(n);}
    public void load(int n){runStack.load(n);}
    public void lit(Integer i){runStack.push(i);}
    public void reset(){runStack.reset();
    }

}
