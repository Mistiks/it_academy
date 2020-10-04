package homeworks.homework6;

public class Person {
    private String nick;
    private String password;

    public Person(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public String getNick() {
        return this.nick;
    }

    public String getPassword() {
        return this.password;
    }

    public String getInfo() {
        return "Nick: " + getNick() + "\t" + " Password: " + getPassword();
    }
}
