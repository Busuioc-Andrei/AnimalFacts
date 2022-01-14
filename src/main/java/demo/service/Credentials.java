package demo.service;

import java.util.Base64;

public class Credentials {
    public static final String AUTHORIZATION = "Authorization";
    private String name;
    private String password;

    public Credentials(String header) {
        if(header.startsWith("Basic ")) {
            header = new String(Base64.getDecoder().decode(header.substring("Basic ".length())));
            if(header.indexOf(':') > 0) {
                name = header.substring(0, header.indexOf(':'));
                password = header.substring(header.indexOf(':') + 1);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
