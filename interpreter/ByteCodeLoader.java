
package interpreter;
import interpreter.ByteCode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;
    ArrayList<String> args;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given bytecode from CodeTable
     *      create an instance of the bytecode class name returned from code table.
     *      Parse any additional arguments for the given bytecode and send them to
     *      the newly created bytecode instance via the init function.
     */
    public Program loadCodes() {
        String code;
        program = new Program();
        try{
            while((code = byteSource.readLine())!= null){
                StringTokenizer str = new StringTokenizer(code);
                String token = str.nextToken();
                String codeClass = CodeTable.getClassName(token);

                //crete new instance of specific byteCode class
                ByteCode byteCode = (ByteCode)Class.forName("interpreter.ByteCode." + codeClass).newInstance();
                //create arrayList for bytecode arguments
                args = new ArrayList<>();
                while(str.hasMoreTokens())
                    args.add(str.nextToken());
                //pass the arrayList into the byteCode's init method
                byteCode.init(args);
                //add the byteCode to the Program
                program.add(byteCode);

                }
                //resolve program addresses
                program.resolveAddrs(program);
            }
            catch (ClassNotFoundException e) {


            }
            catch(IOException e){

            } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return program;
    }
}
