package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by tmytrn on 10/9/17.
 */
public class ReadCode extends ByteCode {
    public void init(ArrayList<String> args) {

    }

    public void execute(VirtualMachine vm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int val = scanner.nextInt();
        vm.pushRunStack(val);
    }
    @Override
    public String toString(){
        return "READ";
    }
}
