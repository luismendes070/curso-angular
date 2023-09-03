# patch

XmlService.ts

    // Angular HTTP API | Part 27 - Sending PATCH Request 2 https://youtu.be/if90tYBdCsg
    patchUser(course:Course): Observable<Course>{
      return this.http.patch<Course>('${this.apiUrl}/courses/id/${courses.id}', course);
    }
