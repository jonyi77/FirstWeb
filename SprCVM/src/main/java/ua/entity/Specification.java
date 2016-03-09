package ua.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Specification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Season season;
	@Enumerated(EnumType.ORDINAL)
	private Sex sex;
	@ManyToOne
	private Brand brand;
	private String top;
	private String materialSole;
	@ManyToOne
	private Category category;
	private String heel;
	private String liningMaterial;
	@ManyToOne
	private Country country;
	@ManyToOne
	private Style style;
	@ManyToOne
	private Color color;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "specification")
	private List<Article> article;

	public Specification() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getMaterialSole() {
		return materialSole;
	}

	public void setMaterialSole(String materialSole) {
		this.materialSole = materialSole;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getHeel() {
		return heel;
	}

	public void setHeel(String heel) {
		this.heel = heel;
	}

	public String getLiningMaterial() {
		return liningMaterial;
	}

	public void setLiningMaterial(String liningMaterial) {
		this.liningMaterial = liningMaterial;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

}
