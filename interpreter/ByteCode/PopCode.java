package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class PopCode extends ByteCode{
    private int n;
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm) {
        vm.popNFromStack(n);
    }
    @Override
    public String toString(){
        return "POP";
    }
}
