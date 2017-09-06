package com.concretepage.entity;

import javax.persistence.*;

@Entity
@Table(name = "assets")
public class Asset {
    private int id;
    private String uri;
    private String type;
    private String name;
    private Integer itemId;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "URI", nullable = true, length = 255)
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "itemID", nullable = true)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (id != asset.id) return false;
        if (uri != null ? !uri.equals(asset.uri) : asset.uri != null) return false;
        if (type != null ? !type.equals(asset.type) : asset.type != null) return false;
        if (name != null ? !name.equals(asset.name) : asset.name != null) return false;
        if (itemId != null ? !itemId.equals(asset.itemId) : asset.itemId != null) return false;
        if (description != null ? !description.equals(asset.description) : asset.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
