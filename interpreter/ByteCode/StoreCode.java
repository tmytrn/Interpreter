package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class StoreCode extends ByteCode {
    int num;
    private String var;
    int printTop;
    public void init(ArrayList<String> args) {
        num = Integer.parseInt(args.get(0));
        var = args.get(1);
    }

    public void execute(VirtualMachine vm) {
            vm.store(num);
            printTop = vm.peekRunStack();
    }
    @Override
    public String toString(){
        String str = "STORE "+ num + " " + var + "\t" + var +" = "+ printTop;

        return str;
    }
}
