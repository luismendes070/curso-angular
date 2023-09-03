package com.loiane.dto;

import org.hibernate.validator.constraints.Length;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class CourseDTO {

        @JsonProperty("_id")
        private Long id;

        @NotBlank
        @NotNull
        @Length(min = 5, max = 100)
        private String name;

        @NotNull @Length(max = 10) @Pattern(regexp = "Back-end|Front-end")
        private String category;

        public CourseDTO(Long id, String name, String category) {
                this.id = id;
                this.name = name;
                this.category = category;
        }

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getCategory() {
                return category;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                CourseDTO that = (CourseDTO) o;
                return Objects.equals(id, that.id) &&
                        Objects.equals(name, that.name) &&
                        Objects.equals(category, that.category);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, category);
        }

        @Override
        public String toString() {
                return "CourseDTO{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", category='" + category + '\'' +
                        '}';
        }
}
