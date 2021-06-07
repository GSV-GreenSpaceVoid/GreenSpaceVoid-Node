package com.greenspacevoidnode.common.player;

import com.esotericsoftware.kryonet.Connection;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "Player")
public class Player {
    @Id @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "currency")
    private BigDecimal currency;








    private Connection connection; //Mapped on player login!


    public Player(){

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public void setCurrency(BigDecimal currency) {
        this.currency = currency;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
