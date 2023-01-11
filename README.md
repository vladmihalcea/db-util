[![License](https://img.shields.io/github/license/vladmihalcea/db-util.svg)](https://raw.githubusercontent.com/vladmihalcea/db-util/master/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/com.vladmihalcea/db-util.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.vladmihalcea%22)
[![JavaDoc](http://javadoc.io/badge/com.vladmihalcea/db-util.svg)](http://www.javadoc.io/doc/com.vladmihalcea/db-util)

## Merged into Hypersistence Utils

The `db-utils` project was discontinued because it was merged into [Hypersistence Utils](https://github.com/vladmihalcea/hypersistence-utils/).

### Introduction

This library contains all sorts of DB utilities like:

* Optimistic Concurrency Retry
* JPA SQL statement count validator

### Are you struggling with application performance issues?

<a href="https://vladmihalcea.com/hypersistence-optimizer/?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil">
<img src="https://vladmihalcea.com/wp-content/uploads/2019/03/Hypersistence-Optimizer-300x250.jpg" alt="Hypersistence Optimizer">
</a>

Imagine having a tool that can automatically detect if you are using JPA and Hibernate properly. No more performance issues, no more having to spend countless hours trying to figure out why your application is barely crawling.

Imagine discovering early during the development cycle that you are using suboptimal mappings and entity relationships or that you are missing performance-related settings. 

More, with Hypersistence Optimizer, you can detect all such issues during testing and make sure you don't deploy to production a change that will affect data access layer performance.

[Hypersistence Optimizer](https://vladmihalcea.com/hypersistence-optimizer/?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil) is the tool you've been long waiting for!

#### Training

If you are interested in on-site training, I can offer you my [High-Performance Java Persistence training](https://vladmihalcea.com/trainings/?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil)
which can be adapted to one, two or three days of sessions. For more details, check out [my website](https://vladmihalcea.com/trainings/?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil).

#### Consulting

If you want me to review your application and provide insight into how you can optimize it to run faster, 
then check out my [consulting page](https://vladmihalcea.com/consulting/?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil).

#### High-Performance Java Persistence Video Courses

If you want the fastest way to learn how to speed up a Java database application, then you should definitely enroll in [my High-Performance Java Persistence video courses](https://vladmihalcea.com/courses/?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil).

#### High-Performance Java Persistence Book

Or, if you prefer reading books, you are going to love my [High-Performance Java Persistence book](https://vladmihalcea.com/books/high-performance-java-persistence?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil) as well.

<a href="https://vladmihalcea.com/books/high-performance-java-persistence?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil">
<img src="https://i0.wp.com/vladmihalcea.com/wp-content/uploads/2018/01/HPJP_h200.jpg" alt="High-Performance Java Persistence book">
</a>

<a href="https://vladmihalcea.com/courses?utm_source=GitHub&utm_medium=banner&utm_campaign=dbutil">
<img src="https://i0.wp.com/vladmihalcea.com/wp-content/uploads/2018/01/HPJP_Video_Vertical_h200.jpg" alt="High-Performance Java Persistence video course">
</a>

### Installation

You can get the framework from Maven Central by using the following dependency:

    <dependency>
        <groupId>com.vladmihalcea</groupId>
        <artifactId>db-util</artifactId>
        <version>1.0.7</version>
    </dependency>

### User guide

You can find usage examples on [my blog](https://vladmihalcea.com):

- [How to detect the Hibernate N+1 query problem during testing](https://vladmihalcea.com/how-to-detect-the-n-plus-one-query-problem-during-testing/)
- [Optimistic Locking Retry with JPA](http://vladmihalcea.com/optimistic-locking-retry-with-jpa/)
