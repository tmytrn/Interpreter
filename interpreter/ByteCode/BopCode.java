package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class BopCode extends ByteCode {
    private String operator;
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        int secondArg =vm.popRunStack();
        int firstArg = vm.popRunStack();

        if(operator.equals("+")){
             vm.pushRunStack(secondArg + firstArg);
        }
        else if(operator.equals("*")){
            vm.pushRunStack(firstArg *secondArg);
        }
        else if(operator.equals("-")){
            vm.pushRunStack(firstArg - secondArg);
        }
        else if(operator.equals("/")){
            vm.pushRunStack(firstArg/secondArg);
        }
        else if(operator.equals("==")){
            if(firstArg==secondArg)
            vm.pushRunStack(1);
            else
                vm.pushRunStack(0);
        }
        else if(operator.equals("!=")){
            if(firstArg != secondArg)
                vm.pushRunStack(1);
            else
                vm.pushRunStack(0);
        }
        else if(operator.equals("<=")){
            if(firstArg<=secondArg)
                vm.pushRunStack(1);
            else
                vm.pushRunStack(0);
        }
        else if(operator.equals(">")){
            if(firstArg > secondArg)
                vm.pushRunStack(1);
            else
                vm.pushRunStack(0);
        }
        else if(operator.equals(">=")){
            if(firstArg >= secondArg)
                vm.pushRunStack(1);
            else
                vm.pushRunStack(0);
        }
        else if(operator.equals("<")){
            if(firstArg < secondArg)
                vm.pushRunStack(1);
            else
                vm.pushRunStack(0);
        }
        else if(operator.equals("|")){

            if(firstArg==1 || secondArg==1)
                vm.pushRunStack(1);
            else
                vm.pushRunStack(0);
        }
        else if (operator.equals("&")) {
            if (firstArg == 1 && secondArg == 1)
                vm.pushRunStack(1);
            else
                vm.pushRunStack(0);
        }
        //pop 2 items off the stack and perform the operation given
    }
    @Override
    public String toString(){
        return "BOP ";
    }
}
