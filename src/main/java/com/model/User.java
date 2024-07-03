package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

import javax.validation.constraints.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name="UserData")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	@NotNull(message="Invalid id.Pls Enter your id")
	private long userId;
	@Size(max=20,min=3,message="Invalid name.Size should be between 3 and 20")
	@NotEmpty(message="Enter your name")
	private String username;
	@Email(message="Invalid Email address, enter proper email ID")
	@NotEmpty(message="please enter your email id")
	private String useremailid;
	@Digits(integer=3,fraction=0,message="Invalid age")
	private int age;
	@Max(value=5,message="Invalid number of articles.Maximum allowed is 5")
	private String currentTimeOfWritingArticles;
	@Min(value=3,message="Invalid number of articles for review.Minimum should be 3")
	private String allowedForArticleReviewing;
	@NotBlank(message="Proficiency  level 3 should not be blank")
	private String proficiency3;
	@Null(message="Proficiency  level4  should  be blank")
	private String proficiency4;
	@Pattern(regexp="YN",flags= {
			Pattern.Flag.CASE_INSENSITIVE
	},message="Invalid Proficiency level5.Enter Y or N")
	private String proficiency5;
	@Positive(message="Invalid Rating.Value should be positive")
	private int rating;
	@NegativeOrZero(message="Invalid Blocklisted Status.Input Value should be negative or zero")
	private int blocklisted;
	@Future(message="Invalid Date .It should be provided as future date")
	private Date futuredate;
	@FutureOrPresent(message="Invalid Date .It should be provided as future or present date")
	private Date futureOrPresentdate;
	
	@PastOrPresent(message="Invalid Date .It should be provided as past or present date")
	private Date pastOrPresentdate;
	@Range(min=1,max=3,message="Invalid value.Value must be in specified range")
	private int rangeEx;
	@URL(message="Invalid URL")
    private String url;
	@CreditCardNumber(message="Invalid CreditCArd Number")
	private String creditCardExample;
	
	
	
	public User() {
		super();
	}
	
	
	public User(long userId, String username, String useremailid, int age, String currentTimeOfWritingArticles,
			String allowedForArticleReviewing, String proficiency3, String proficiency4, String proficiency5,
			int rating, int blocklisted, Date futuredate, Date futureOrPresentdate, Date pastOrPresentdate, int rangeEx,
			String url, String creditCardExample) {
		super();
		this.userId = userId;
		this.username = username;
		this.useremailid = useremailid;
		this.age = age;
		this.currentTimeOfWritingArticles = currentTimeOfWritingArticles;
		this.allowedForArticleReviewing = allowedForArticleReviewing;
		this.proficiency3 = proficiency3;
		this.proficiency4 = proficiency4;
		this.proficiency5 = proficiency5;
		this.rating = rating;
		this.blocklisted = blocklisted;
		this.futuredate = futuredate;
		this.futureOrPresentdate = futureOrPresentdate;
		this.pastOrPresentdate = pastOrPresentdate;
		this.rangeEx = rangeEx;
		this.url = url;
		this.creditCardExample = creditCardExample;
	}
	
	
	
	
	
	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUseremailid() {
		return useremailid;
	}



	public void setUseremailid(String useremailid) {
		this.useremailid = useremailid;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getCurrentTimeOfWritingArticles() {
		return currentTimeOfWritingArticles;
	}



	public void setCurrentTimeOfWritingArticles(String currentTimeOfWritingArticles) {
		this.currentTimeOfWritingArticles = currentTimeOfWritingArticles;
	}



	public String getAllowedForArticleReviewing() {
		return allowedForArticleReviewing;
	}



	public void setAllowedForArticleReviewing(String allowedForArticleReviewing) {
		this.allowedForArticleReviewing = allowedForArticleReviewing;
	}



	public String getProficiency3() {
		return proficiency3;
	}



	public void setProficiency3(String proficiency3) {
		this.proficiency3 = proficiency3;
	}



	public String getProficiency4() {
		return proficiency4;
	}



	public void setProficiency4(String proficiency4) {
		this.proficiency4 = proficiency4;
	}



	public String getProficiency5() {
		return proficiency5;
	}



	public void setProficiency5(String proficiency5) {
		this.proficiency5 = proficiency5;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public int getBlocklisted() {
		return blocklisted;
	}



	public void setBlocklisted(int blocklisted) {
		this.blocklisted = blocklisted;
	}



	public Date getFuturedate() {
		return futuredate;
	}



	public void setFuturedate(Date futuredate) {
		this.futuredate = futuredate;
	}



	public Date getFutureOrPresentdate() {
		return futureOrPresentdate;
	}



	public void setFutureOrPresentdate(Date futureOrPresentdate) {
		this.futureOrPresentdate = futureOrPresentdate;
	}



	public Date getPastOrPresentdate() {
		return pastOrPresentdate;
	}



	public void setPastOrPresentdate(Date pastOrPresentdate) {
		this.pastOrPresentdate = pastOrPresentdate;
	}



	public int getRange() {
		return rangeEx;
	}



	public void setRange(int rangeEx) {
		this.rangeEx = rangeEx;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getCreditCardExample() {
		return creditCardExample;
	}



	public void setCreditCardExample(String creditCardExample) {
		this.creditCardExample = creditCardExample;
	}

	
}