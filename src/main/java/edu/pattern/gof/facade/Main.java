package edu.pattern.gof.facade;

/**
 * Facade pattern hides the complexities of the system and provides an interface to the client
 * using which the client can access the system. This type of design pattern comes under structural
 * pattern as this pattern adds an interface to exiting system to hide its complexities.
 * This  pattern  involves  a  single  class  which  provides  simplified  methods  which  are  required  by
 * client and delegates calls to existing system classes methods.
 */

public class Main {
    public static void main(String ... args){
        Facade facade = new Facade("localhost", "tukshaitov","password");
        facade.sendMessage("tukshaitov@gmail.com",
                            "sergio@azdata.net",
                            "С днем рождения дорогой друг!",
                            "С лучшими пожеланиями.",
                            "Great things", null);
    }
}