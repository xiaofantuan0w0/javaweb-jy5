package com.itdr.pojo;

public class Uusers {
    private String username;
    private Integer password;
    private String email;
    private Integer phone;
    private String question;
    private String answer;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        String a =
                ",uname:"+this.getUsername()+
                ",psd:"+this.getPassword()+
                ",email:"+this.getEmail()+
                ",tel:"+this.getPhone()
                +",question:"+this.getQuestion()
                  + ",answer:"+this.getAnswer();
        return a;
    }
}
