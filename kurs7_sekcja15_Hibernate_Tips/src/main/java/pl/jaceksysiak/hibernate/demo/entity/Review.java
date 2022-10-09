package pl.jaceksysiak.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private ReviewRating rating;

	private String description;
	
	//Many Reviews To One Course
	@ManyToOne(/*By default is EAGER*/fetch = FetchType.LAZY)
	private Course course;

	protected Review() {
	}

	public Review(ReviewRating rating, String description) {
		//super();
		this.rating = rating;
		this.description = description;
	}



	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + ", course=" + course + "]";
	}

 

}
