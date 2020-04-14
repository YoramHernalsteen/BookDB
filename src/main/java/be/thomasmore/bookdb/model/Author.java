package be.thomasmore.bookdb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    private int id;
    private String name;
    private String mostKnownFor;
    private String moreInfo;

    public Author() {
    }

    public Author(int id,  String name, String mostKnownFor, String moreInfo) {
        this.id = id;
        this.name = name;
        this.mostKnownFor = mostKnownFor;
        this.moreInfo = moreInfo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMostKnownFor() {
        return mostKnownFor;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMostKnownFor(String mostKnownFor) {
        this.mostKnownFor = mostKnownFor;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
