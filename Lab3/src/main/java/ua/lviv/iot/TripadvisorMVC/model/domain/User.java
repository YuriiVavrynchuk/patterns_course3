package ua.lviv.iot.TripadvisorMVC.model.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "avatar_url")
	private String avatarUrl;

	@Column(name = "date_of_accession")
	private Date dateOfAccession;

	@Column(name = "description")
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id", nullable = true)
	private Address address;

	public User() {
	}

	public User(String username, String password, String avatarUrl, Date dateOfAccession, String description,
			Address address) {
		this.username = username;
		this.password = password;
		this.avatarUrl = avatarUrl;
		this.dateOfAccession = dateOfAccession;
		this.description = description;
		this.address = address;
	}

	public User(Integer id, String username, String password, String avatarUrl, Date dateOfAccession,
			String description, Address address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatarUrl = avatarUrl;
		this.dateOfAccession = dateOfAccession;
		this.description = description;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Date getDateOfAccession() {
		return dateOfAccession;
	}

	public void setDateOfAccession(Date dataOfAccession) {
		this.dateOfAccession = dataOfAccession;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result + ((avatarUrl == null) ? 0 : avatarUrl.hashCode());
		result = prime * result + ((dateOfAccession == null) ? 0 : dateOfAccession.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (avatarUrl == null) {
			if (other.avatarUrl != null) {
				return false;
			}
		} else if (!avatarUrl.equals(other.avatarUrl)) {
			return false;
		}
		if (dateOfAccession == null) {
			if (other.dateOfAccession != null) {
				return false;
			}
		} else if (!dateOfAccession.equals(other.dateOfAccession)) {
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
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", avatarUrl=" + avatarUrl
				+ ", dateOfAccession=" + dateOfAccession + ", description=" + description + ", address=" + address
				+ "]";
	}
}