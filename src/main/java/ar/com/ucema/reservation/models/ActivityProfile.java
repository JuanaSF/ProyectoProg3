package ar.com.ucema.reservation.models;

import jakarta.persistence.*;

@Entity
@Table(name = "activity_profile")
public class ActivityProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_profile_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="user_id")
    private User provider;

    @Column(nullable = false)
    private String title;

    private String description;

    private String category;

    @Column(nullable = false)
    private Integer maxCapacity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityProfileStatusEnum status;

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

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ActivityProfileStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ActivityProfileStatusEnum status) {
        this.status = status;
    }
}
