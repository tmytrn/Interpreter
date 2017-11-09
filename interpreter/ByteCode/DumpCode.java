package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class DumpCode extends ByteCode {

    String arg;
    public void init(ArrayList<String> args) {
        arg = args.get(0);
    }
    public void execute(VirtualMachine vm) {
        if(arg.equals("ON"))
            vm.dumpMode(true);
        if(arg.equals("OFF"))
            vm.dumpMode(false);
    }
    @Override
    public String toString(){
        return null;
    }
}
