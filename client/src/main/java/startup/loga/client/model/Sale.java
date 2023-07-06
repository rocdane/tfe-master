package startup.loga.client.model;

import startup.loga.client.app.factory.ICashflow;

import java.io.Serializable;
import java.util.Date;

public class Sale implements ICashflow, Serializable {
    private Long id;
    private Date createdAt;
    private String client;
    private Article article;
    private Double price;
    private Integer quantity;
    private Double amount;

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String getDescription() {
        return "Vente : "+getArticle().getDesignation();
    }

    @Override
    public Double getValue() {
        return amount;
    }

    @Override
    public Date getDate() {
        return createdAt;
    }
}
