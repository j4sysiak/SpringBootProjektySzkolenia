package pl.jaceksysiak.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(
		value = {
				@NamedQuery(name="query_get_all_courses", query="Select  c  From Course c"),
				@NamedQuery(name="query_get_100_courses", query="Select  c  From Course c where name like '%100 Steps'")	
		}
		)
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	//One Course has Many Reviews 
	@OneToMany(mappedBy="course"/* by default is LAZY, fetch = FetchType.EAGER*/)
	private List<Review> reviews = new ArrayList<>();
	
	// Many Couses To Many Students
	@ManyToMany(mappedBy="courses")  
	//student is the owning side of the relation between STUDENT and COURSES
	//dzięki temu 'mappedBy' nie bedzie dwóch tabel join pomiędzy Course i Student (STUDENT_COURSES)
	private List<Student> students = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
}
