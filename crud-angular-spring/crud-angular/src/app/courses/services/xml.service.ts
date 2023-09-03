import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class XmlService {

   apiUrl:string = '/api/xml';

  // ng g s courses/services/xml
  // constructor() { } // end empty constructor

    constructor(private http: HttpClient) { }

    // Angular HTTP API | Part 27 - Sending PATCH Request 2 https://youtu.be/if90tYBdCsg
    patchXml(course:Course): Observable<Course>{
      return this.http.patch<Course>('${this.apiUrl}/courses/id/${courses.id}', course);
    }

  getXmlData() {
    return this.http.get('/api/xml', { responseType: 'text' });
  }

} // end class XmlService
