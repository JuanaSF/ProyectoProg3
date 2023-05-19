package ar.com.ucema.reservation.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ActivityProfileId", referencedColumnName="activity_profile_id")
    private ActivityProfile profile;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="user_id")
    private User provider;

    @Column(nullable = false)
    private String title;

    private String description;

    private String category;

    @Column(nullable = false)
    private Integer availableCapacity;

    @Column(nullable = false)
    private Double price;

    private LocalDate date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityStatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ActivityStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ActivityStatusEnum status) {
        this.status = status;
    }

    public ActivityProfile getProfile() {
        return profile;
    }

    public void setProfile(ActivityProfile profile) {
        this.profile = profile;
    }
}
