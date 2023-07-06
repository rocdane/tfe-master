package startup.loga.client.model;

import java.io.Serializable;
import java.util.List;

public class Atelier implements Serializable
{
    private Long id;

    private String name;

    private String legalNotice;

    private String address;

    private String contact;

    private List<Space> spaces ;

    private List<Department> departments;

    private List<Finance> finances;

    private List<Article> articles;

    private List<FixedAssets> immobilities;

    public Atelier() {
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

    public String getLegalNotice() {
        return legalNotice;
    }

    public void setLegalNotice(String legalNotice) {
        this.legalNotice = legalNotice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Finance> getFinances() {
        return finances;
    }

    public void setFinances(List<Finance> finances) {
        this.finances = finances;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<FixedAssets> getImmobilities() {
        return immobilities;
    }

    public void setImmobilities(List<FixedAssets> immobilities) {
        this.immobilities = immobilities;
    }

    public void addSpace(Space space){
        space.setAtelier(this);
        this.spaces.add(space);
    }

    public void addDepartment(Department department){
        department.setAtelier(this);
        this.departments.add(department);
    }

    public void addFinance(Finance finance){
        finance.setAtelier(this);
        this.finances.add(finance);
    }

    public void addArticle(Article article){
        article.setAtelier(this);
        this.articles.add(article);
    }

    public void addFixedAssets(FixedAssets fixedAssets){
        fixedAssets.setAtelier(this);
        this.immobilities.add(fixedAssets);
    }
}
