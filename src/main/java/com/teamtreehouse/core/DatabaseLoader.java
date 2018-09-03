package com.teamtreehouse.core;

import com.teamtreehouse.course.Course;
import com.teamtreehouse.course.CourseRepository;
import com.teamtreehouse.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {

  private final CourseRepository courses;

  @Autowired
  public DatabaseLoader(CourseRepository courses) {
    this.courses = courses;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Course course = new Course("Java Basics", "https://teamtreehouse.com/library/java-basics");
    Review review = new Review(3, "You ARE a dork!!!");
    course.addReview(review);
    courses.save(course);

    String[] templates = {
      "Up and running with %s",
      "%s Basics",
      "%s for Beginners",
      "%s for Neckbeards",
      "Under the Hood: %s"
    };
    String[] buzzwords = {
      "Java 9",
      "Scala",
      "Groovy",
      "Hibernate",
      "Spring REST Data",
      "Spring HATEOAS",
    };
    List<Course> cs = new ArrayList<>();
    IntStream.range(0, 100)
      .forEach(i -> {
        String template = templates[i % templates.length];
        String buzzword = buzzwords[i % buzzwords.length];
        String title = String.format(template, buzzword);
        Course c = new Course(title, "https://teamtreehouse.com/library/java-basics");
        c.addReview(new Review(i % 5, String.format("Moar %s please!!!", buzzword)));
        cs.add(c);
      });
    courses.saveAll(cs);
  }

}