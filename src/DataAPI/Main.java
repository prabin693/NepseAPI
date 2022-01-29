//By Sijan Bhandari
package DataAPI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static NepseAPI API = new NepseAPI();

    public static void main(String[] args) {
        startAPI();
        checkArgs(args);

    }

    static void startAPI() {
        try {
            API.startPage();
            System.out.println("API Started..");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void checkArgs(String[] arg) {
        if (arg.length > 0) {
            switch (arg[0]) {
                case "isopen" -> {
                    System.out.println("---------------");
                    if (API.isMarketOpen()) {
                        System.out.println("Market is open now");
                    } else {
                        System.out.println("market is closed now");
                    }
                }
                case "search" -> {
                    if (arg.length > 1) {
                        if (arg.length > 2) {
                             if (arg[2].equals("GUI")) {
                            API.getBySymbol(arg[1],true);
                            }
                        }else{
                            API.getBySymbol(arg[1],false);
                        }
                    } else {
                        System.out.println("plese enter symbol after search");
                    }
                }
                case "all" -> {
                    API.displayaAll();
                }
                case default -> {
                    System.out.println("Wrong arguement");
                }
            }
        } else {
            System.out.println("empty arguement..skipping..");
        }
    }

}