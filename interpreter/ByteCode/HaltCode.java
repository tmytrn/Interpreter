package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class HaltCode extends ByteCode {
    public void init(ArrayList<String> args) {

    }

    public void execute(VirtualMachine vm) {
        vm.endProgram();
    }
    @Override
    public String toString(){
        return "HALTCODE ";
    }
}
