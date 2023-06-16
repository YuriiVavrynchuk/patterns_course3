package ua.lviv.iot.TripadvisorMVC.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
	private User author;

	@ManyToOne
	@JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
	private Restaurant restaurant;

	@Column(name = "rating")
	private Float rating;

	@Column(name = "feedback")
	private String feedback;

	@Column(name = "status")
	private String status;

	@Column(name = "date_of_publishing")
	private Date dateOfPublishing;

	public Feedback(Integer id, User author, Restaurant restaurant, Float rating, String feedback, String status,
					Date dateOfPublishing) {
		super();
		this.id = id;
		this.author = author;
		this.restaurant = restaurant;
		this.rating = rating;
		this.feedback = feedback;
		this.status = status;
		this.dateOfPublishing = dateOfPublishing;
	}

	public Feedback(User author, Restaurant restaurant, Float rating, String feedback, String status,
					Date dateOfPublishing) {
		super();
		this.author = author;
		this.restaurant = restaurant;
		this.rating = rating;
		this.feedback = feedback;
		this.status = status;
		this.dateOfPublishing = dateOfPublishing;
	}

	public Feedback() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOfPublishing() {
		return dateOfPublishing;
	}

	public void setDateOfPublishing(Date dateOfPublishing) {
		this.dateOfPublishing = dateOfPublishing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((dateOfPublishing == null) ? 0 : dateOfPublishing.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Feedback other = (Feedback) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (dateOfPublishing == null) {
			if (other.dateOfPublishing != null) {
				return false;
			}
		} else if (!dateOfPublishing.equals(other.dateOfPublishing)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (rating == null) {
			if (other.rating != null) {
				return false;
			}
		} else if (!rating.equals(other.rating)) {
			return false;
		}
		if (restaurant == null) {
			if (other.restaurant != null) {
				return false;
			}
		} else if (!restaurant.equals(other.restaurant)) {
			return false;
		}
		if (feedback == null) {
			if (other.feedback != null) {
				return false;
			}
		} else if (!feedback.equals(other.feedback)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", author=" + author + ", restaurant=" + restaurant + ", rating=" + rating
				+ ", feedback=" + feedback + ", status=" + status + ", dateOfPublishing=" + dateOfPublishing + "]";
	}
}