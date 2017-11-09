package interpreter;

import interpreter.ByteCode.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        //false branch, call, goto
        int i = 1;
        HashMap <String, Integer> ads = new HashMap<>();
        //Find all label codes and out them into the ads hashmap
        while(i < program.getSize()){
            ByteCode addrs = program.getCode(i);
            if(addrs instanceof LabelCode){
                ads.put(((LabelCode) addrs).getAddress(), i);
                //System.out.println("Label found " + ((LabelCode)addrs).getAddress() + " " + i);
            }
            i++;

        }
        i=0;
        //find all goto, call, falsebranch codes and swap address with values in hashmap
        while(i <program.getSize()){
            ByteCode adrs = program.getCode(i);
            if(adrs instanceof CallCode) {
                if (ads.containsKey(((CallCode) adrs).getAddress()))
                ((CallCode) adrs).setAddress(ads.get(((CallCode) adrs).getAddress()));
                //System.out.println("CallCode found " + ((CallCode)adrs).getAddress());
            }
            if(adrs instanceof GotoCode){
                if(ads.containsKey(((GotoCode)adrs).getAddress()))
                ((GotoCode)adrs).setAddress(ads.get(((GotoCode)adrs).getAddress()));
                //System.out.println("Goto found " + ((GotoCode)adrs).getAddress());
            }
            if(adrs instanceof FalseBranchCode){
                if(ads.containsKey(((FalseBranchCode)adrs).getAddress()))
                ((FalseBranchCode)adrs).setAddress(ads.get(((FalseBranchCode)adrs).getAddress()));
                //System.out.println("FalseBranch found " + ((FalseBranchCode)adrs).getAddress());
            }
            i++;

        }


    }
    public void add(ByteCode code){
        program.add(code);
    }




}
