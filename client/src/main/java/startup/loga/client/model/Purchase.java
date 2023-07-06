package startup.loga.client.model;

import java.io.Serializable;
import java.util.Date;

public class Purchase implements Serializable {
    private Long id;
    private Date createdAt;
    private String furnisher;
    private Article article;
    private Double price;
    private Integer quantity;
    private Double amount;

    public Purchase() {
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

    public String getFurnisher() {
        return furnisher;
    }

    public void setFurnisher(String furnisher) {
        this.furnisher = furnisher;
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
}
