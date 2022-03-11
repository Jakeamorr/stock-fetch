package net.jakemorris.stockfetch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exchange")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exchange_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "longName")
    private String longName;

    @Column(name = "refId")
    private String refId;

    @Column(name = "type")
    private String type;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "exchange_id")
    private List<Quote> quotes = new ArrayList<>();

    public Exchange() {}

    public Exchange(String name, String longName, String refId, String type) {
        this.name = name;
        this.longName = longName;
        this.refId = refId;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
