package ru.raif.cources;

/**
 * Created by a.pervushov on 20.11.2017.
 */
public class TryWithResources {

    public static void main(String[] args) throws Exception {

        try ( OpenDoor door = new OpenDoor() ) {
            door.swing(); /*this throws a SwingExecption*/
        }
        catch (Exception e) {
            System.out.println("Is there a draft? " + e.getClass());
        }
        finally {
            System.out.println("I'm putting a sweater on, regardless. ");
        }
    }
}

class OpenException extends Exception {}
class SwingException extends Exception {}
class CloseException extends Exception {}

class OpenDoor implements AutoCloseable {

    public OpenDoor() throws Exception {
        System.out.println("The door is open.");
    }
    public void swing() throws Exception {
        System.out.println("The door is becoming unhinged.");
        throw new SwingException();
    }

    public void close() throws Exception {
        System.out.println("The door is closed.");
    }
}
