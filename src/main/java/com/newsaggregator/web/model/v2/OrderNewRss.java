package com.newsaggregator.web.model.v2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "scrum_order_new_rss")
public class OrderNewRss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String linkToResourse;
    String linkToRss;
    Date date = new Date();
}
