package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class LabelCode extends ByteCode {
    private String address;
    public void init(ArrayList<String> args) {
       address = args.get(0);
    }
    public String getAddress(){
        return address;
    }
    public void execute(VirtualMachine vm) {}
        @Override
        public String toString(){
            return "LABEL ";
        }


}
