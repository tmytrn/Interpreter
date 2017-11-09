package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class LoadCode extends ByteCode {
    private int num;
    String var;
    public void init(ArrayList<String> args) {
        num = Integer.parseInt(args.get(0));
        var = args.get(1);
    }

    public void execute(VirtualMachine vm) {
        vm.load(num);
    }
    @Override
    public String toString(){
        String str = "LOAD" + num + " ";
        if(var != null)
            str += var + " " + "<load " + var + ">";
        return str;
    }
}

