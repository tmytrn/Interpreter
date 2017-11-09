package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public abstract class ByteCode {

    public abstract void  init(ArrayList<String> args);
    public abstract void execute(VirtualMachine vm);
     public abstract String toString();

}
