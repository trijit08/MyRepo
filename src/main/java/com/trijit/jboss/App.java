package com.trijit.jboss;

import java.io.IOException;
import static java.lang.System.out;
import java.net.InetAddress;
import java.rmi.UnknownHostException;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.helpers.ClientConstants;
import org.jboss.dmr.ModelNode;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws UnknownHostException
    {
        ModelNode node=new ModelNode();
        
        System.out.println();
       node.get("operation").set("read-resource");
       
       ModelNode addr=node.get("address");
       addr.add("subsystem","naming");
       node.get("operations").set(true);
       node.get("recursive").set(true);
       try{
       ModelControllerClient  clt=ModelControllerClient.Factory.create(InetAddress.getByName("127.0.0.1"), 9999);
       System.out.println("SDFDF"+ClientConstants.OP);
       System.out.println("RESULT: "+clt.execute(node).get("result").toString());
       }
       catch(IOException e){
           System.out.println("Connection ISSUE!!!");
           e.printStackTrace();
       }
       
       
       
    }
}
