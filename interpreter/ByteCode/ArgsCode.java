package interpreter.ByteCode;

import interpreter.VirtualMachine;


import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class ArgsCode extends ByteCode{
    private int frame;
    public void execute(VirtualMachine vm) {
            vm.newFrame(frame);
    }//create new frame in the runtime stack

    public void init(ArrayList<String> args) {
        frame = Integer.parseInt(args.get(0));
    }
    @Override
    public String toString(){
        return "ARGS " + frame;
    }

}

