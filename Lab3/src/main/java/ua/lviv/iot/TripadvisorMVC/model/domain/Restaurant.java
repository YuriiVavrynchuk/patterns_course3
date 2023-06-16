package ua.lviv.iot.TripadvisorMVC.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "rating")
	private Float rating;

	@Column(name = "description")
	private String description;

	@Column(name = "lower_price")
	private Double lowerPrice;

	@Column(name = "top_price")
	private Double topPrice;

	@Column(name = "menu_url")
	private String menuUrl;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
	private User owner;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
	private Address address;

	public Restaurant(Integer id, String name, Float rating, String description, Double lowerPrice, Double topPrice,
			String menuUrl, User owner, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.description = description;
		this.lowerPrice = lowerPrice;
		this.topPrice = topPrice;
		this.menuUrl = menuUrl;
		this.owner = owner;
		this.address = address;
	}

	public Restaurant(String name, Float rating, String description, Double lowerPrice, Double topPrice, String menuUrl,
			User owner, Address address) {
		super();
		this.name = name;
		this.rating = rating;
		this.description = description;
		this.lowerPrice = lowerPrice;
		this.topPrice = topPrice;
		this.menuUrl = menuUrl;
		this.owner = owner;
		this.address = address;
	}

	public Restaurant() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getLowerPrice() {
		return lowerPrice;
	}

	public void setLowerPrice(Double lowerPrice) {
		this.lowerPrice = lowerPrice;
	}

	public Double getTopPrice() {
		return topPrice;
	}

	public void setTopPrice(Double topPrice) {
		this.topPrice = topPrice;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lowerPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((menuUrl == null) ? 0 : menuUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		temp = Double.doubleToLongBits(topPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Restaurant other = (Restaurant) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (Double.doubleToLongBits(lowerPrice) != Double.doubleToLongBits(other.lowerPrice)) {
			return false;
		}
		if (menuUrl == null) {
			if (other.menuUrl != null) {
				return false;
			}
		} else if (!menuUrl.equals(other.menuUrl)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (owner == null) {
			if (other.owner != null) {
				return false;
			}
		} else if (!owner.equals(other.owner)) {
			return false;
		}
		if (rating == null) {
			if (other.rating != null) {
				return false;
			}
		} else if (!rating.equals(other.rating)) {
			return false;
		}
		if (Double.doubleToLongBits(topPrice) != Double.doubleToLongBits(other.topPrice)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", rating=" + rating + ", description=" + description
				+ ", lowerPrice=" + lowerPrice + ", topPrice=" + topPrice + ", menuUrl=" + menuUrl + ", owner=" + owner
				+ ", address=" + address + "]";
	}
}