package model.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Admin {

    private static Admin instance;

    private String username;
    private String password;

    private String secretQuestion;
    private String secretAnswer;

    public Admin(String username, String password, String secretQuestion, String secretAnswer) {
        this.username = username;
        this.password = password;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
    }

    public static Admin getInstance(String username, String password, String secretQuestion, String secretAnswer) {
        if (instance == null) {
            instance = new Admin(username, password, secretQuestion, secretAnswer);
        }
        return instance;
    }

    public static Admin getInstance() {
        return instance;
    }


}
