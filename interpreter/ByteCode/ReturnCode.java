package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class ReturnCode extends ByteCode {
    private String id;
    private int prevPC;
    public void init(ArrayList<String> args) {
        if(args.size() != 0)
            id = args.get(0);


    }

    public void execute(VirtualMachine vm) {
        vm.reset();
        prevPC = vm.getPrevPC();
        vm.changePC(prevPC);

    }
    @Override
    public String toString(){
        String str = "RETURN " + id + " exit: " + prevPC;
        return str;

    }
}

