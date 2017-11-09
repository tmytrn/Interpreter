package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class WriteCode extends ByteCode {
    public void init(ArrayList<String> args) {

    }

    public void execute(VirtualMachine vm) {
        int i = vm.peekRunStack();
        System.out.println(i);
    }
    @Override
    public String toString(){
        return "WRITE";
    }
}
