package interpreter.ByteCode;

import interpreter.Interpreter;
import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */;
public class LitCode extends ByteCode {;
    private int arg;
    private String var;
    public void init(ArrayList<String> args) {
        arg = Integer.parseInt(args.get(0));
        if(args.isEmpty())
            var = args.get(1);

    }

    public void execute(VirtualMachine vm) {
        Integer i = new Integer(arg);
        vm.lit(arg);
    }
    @Override
    public String toString(){
        String str = "LIT " + arg + " " ;
        if(var != null)
            str+= "int " + var;
        return str;
    }
}
